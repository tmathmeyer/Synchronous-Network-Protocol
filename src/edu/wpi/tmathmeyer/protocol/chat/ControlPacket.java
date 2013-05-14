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

public class ControlPacket implements Packet {

	public byte data;
	
	@Override
	public byte getPacketID() {
		return 0x15;
	}

	@Override
	public void write(DataOutputStream d) throws IOException {
		d.writeByte(0x15);
		d.writeByte(data);
	}
	
	public ControlPacket(byte data){
		this.data = data;
	}

	public ControlPacket(DataInputStream in) throws Exception{
		data = in.readByte();
	}
	
	/*
	 * 0x00 login failed
	 * 0x01 login successful
	 */

}
