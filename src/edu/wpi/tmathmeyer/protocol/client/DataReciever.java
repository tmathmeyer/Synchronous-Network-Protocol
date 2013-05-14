/*******************************************************************************
 * Copyright (c) 2013 Ted Meyer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Ted Meyer - initial API and implementation
 ******************************************************************************/
package edu.wpi.tmathmeyer.protocol.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.Socket;
import java.util.Collection;

import edu.wpi.tmathmeyer.protocol.Logger;
import edu.wpi.tmathmeyer.protocol.Packet;

public class DataReciever implements Runnable{
	
	private DataInputStream in;
	private boolean receiving = true;
	DataHandler d;
	
	/**
	 * 
	 * @param socket the Socket from which to read data
	 * @param d the DataHandler to which the data will be sent
	 * @param allowablePackets the packets that this client will accept
	 * @throws IOException in case of socket issues
	 */
	public DataReciever(Socket socket, DataHandler d, Packet[] allowablePackets) throws IOException{
		this.in = new DataInputStream(socket.getInputStream());
		this.d = d;
		this.addValidPacketTypes(allowablePackets);
	}
	
	public void addValidPacketTypes(Packet[] p) {
		for(Packet pp : p){
			addValidPacket(pp);
		}
	}

	public void addValidPacketTypes(Collection<Packet> p){
		for(Packet pp : p){
			addValidPacket(pp);
		}
	}
	
	public void addValidPacket(Packet p){
		Logger.log(p);
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public void run() {
		System.out.println("started reciever from: "+d.getClass());
		try{
			while(receiving){
				byte read = this.in.readByte();
				d.print(read);
				Constructor[] c = Logger.retrieve(read).getConstructors();
				for(Constructor k : c)
					if (k.getParameterTypes().length == 1 && k.getParameterTypes()[0] == DataInputStream.class){
						Packet p = (Packet) k.newInstance(in);
						d.print(p.getClass());
						this.d.processPacket(p);
					}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			//System.out.println(e.toString());
			this.receiving = false;
			d.kill();
		}
	}
}
