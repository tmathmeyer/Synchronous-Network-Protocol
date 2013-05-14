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
package edu.wpi.tmathmeyer.protocol.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.wpi.tmathmeyer.protocol.Packet;

public class MessageGroupPacket implements Packet{
	
	private byte[] messageGroups;
	private short messageGroupSize;
	private DataInputStream in;
	
	
	/**
	 * EXAMPLE PACKET
	 * server to client;
	 * 
	 * [----packetID: 0x02---------------] [---client list packet--------------]
	 * [----messageGroupCount: 2---------] [---the number of groups 2 (short)--]
	 * [----messageGroup: {0x00,0x01}----] [---the channels included in--------]
	 * 
	 * END EXAMPLE
	 * @param in the DataInputStream from which byte information is being read
	 * @throws IOException if no data can be read from the data input stream, an IO exception is thrown
	 */
	public MessageGroupPacket(DataInputStream in) throws IOException{
		this.setIn(in);
		this.setMessageGroupSize(in.readShort());
		this.setMessageGroups(new byte[this.getMessageGroupSize()]);
		for(int i = 0; i < this.getMessageGroupSize(); i++)
			this.getMessageGroups()[i] = in.readByte();
	}
	public MessageGroupPacket(){}


	/**
	 * @return the messageGroups
	 */
	public byte[] getMessageGroups() {
		return messageGroups;
	}


	/**
	 * @param messageGroups the messageGroups to set
	 */
	public void setMessageGroups(byte[] messageGroups) {
		this.messageGroups = messageGroups;
	}


	/**
	 * @return the messageGroupSize
	 */
	public short getMessageGroupSize() {
		return messageGroupSize;
	}


	/**
	 * @param messageGroupSize the messageGroupSize to set
	 */
	public void setMessageGroupSize(short messageGroupSize) {
		this.messageGroupSize = messageGroupSize;
	}


	/**
	 * @return the in
	 */
	public DataInputStream getIn() {
		return in;
	}


	/**
	 * @param in the in to set
	 */
	public void setIn(DataInputStream in) {
		this.in = in;
	}


	@Override
	public byte getPacketID() {
		return 0x02;
	}


	@Override
	public void write(DataOutputStream d) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
