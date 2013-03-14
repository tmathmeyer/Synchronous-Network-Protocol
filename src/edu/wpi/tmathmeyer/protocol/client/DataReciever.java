package edu.wpi.tmathmeyer.protocol.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.Socket;

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
		for(Packet p : allowablePackets)Logger.log(p);
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public void run() {
		try{
			while(receiving){
				byte read = this.in.readByte();
				d.print(read);
				Constructor[] c = Logger.retrieve(read).getConstructors();
				for(Constructor k : c)
					if (k.getParameterTypes().length == 1 && k.getParameterTypes()[0] == DataInputStream.class)
						this.d.processPacket((Packet) k.newInstance(in));
			}
		}
		catch(Exception e){
			e.printStackTrace();
			this.receiving = false;
		}
	}
}