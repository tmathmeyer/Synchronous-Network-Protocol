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

import java.io.DataOutputStream;
import java.net.Socket;

import edu.wpi.tmathmeyer.protocol.Packet;


public interface DataHandler extends Runnable{

	/**
	 * 
	 * @param p the incoming packet
	 * @throws Exception
	 */
	public Packet processPacket(Packet p) throws Exception;
	
	
	/**
	 * 
	 * @return the version of the client (for server use, not yet implemented)
	 */
	public byte getVersionID();
	
	
	/**
	 * 
	 * @param p the packet that tells the client whether it has been authenticated or denied
	 * @return whether the client has been authenticated
	 * @throws Exception all methods that involve packets in their parameters or returns throw exceptions
	 */
	public boolean authenticate(Packet p) throws Exception;
	
	
	/**
	 * 
	 * @return the output stream provided by the socket
	 */
	public DataOutputStream getByteOutputStream();
	
	
	/**
	 * 
	 * @param r the reciever to be started
	 */
	public void startReciever(DataReciever r);
	
	
	/**
	 * 
	 * @return the socket currently in use
	 */
	public Socket getSocket();
	
	
	/**
	 * 
	 * @throws Exception Objects are people too, and they dont always like being shutdown like that. jerk.
	 */
	public void closeOutStream() throws Exception;
	
	
	/**
	 * 
	 * @param o this method can be used by the client to get the packet header byte for any operation sans packet handling
	 */
	public void print(Object o);
	
	/**
	 * kills the data handler
	 */
	public void kill();
}
