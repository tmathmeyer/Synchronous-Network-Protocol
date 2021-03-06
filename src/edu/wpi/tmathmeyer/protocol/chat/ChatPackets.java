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

import edu.wpi.tmathmeyer.protocol.Packet;

public class ChatPackets {
	
	public static Packet[] pkts = {new CommandPacket("kill", "everyone lol", (byte) 0), 
									new ControlPacket((byte) 0), 
									new LoginPacket(), 
									new MessageGroupListPacket(null, null),
									new MessageGroupPacket(),
									new MessagePacket(null, null),
									new PrivateMessagePacket(null, null),
									new UsersPacket(null, (byte) 0, null, null)};
	
	/**
	 * 
	 * loginPacket : 0x00
	 * 
     * messagePacketListPacket : 0x01
     * 
     * messageGroupPacket : 0x02
     * 
     * messageGroupList : 0x03
     * 
     * commandPacket : 0x04
     * 
     * privateMessagePacket : 0x05
     * 
     * usersPacket : 0x09
     * 
     * controlPacket : 0x15
	 * 
	 */
}
