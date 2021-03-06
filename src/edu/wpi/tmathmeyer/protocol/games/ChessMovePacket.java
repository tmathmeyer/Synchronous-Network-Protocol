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
package edu.wpi.tmathmeyer.protocol.games;

import java.io.DataOutputStream;
import java.io.IOException;

import edu.wpi.tmathmeyer.protocol.Packet;

public class ChessMovePacket implements Packet {
	private String fromLoc;
	private String toLoc;
	
	public ChessMovePacket(String from, String to){
		this.setFromLoc(from);
		this.setToLoc(to);
	}
	
	public ChessMovePacket(DataOutputStream out){
		
	}
	
		
	@Override
	public byte getPacketID() {
		return 0x00;
	}

	@Override
	public void write(DataOutputStream d) throws IOException {
		
	}

	/**
	 * @return the toLoc
	 */
	public String getToLoc() {
		return toLoc;
	}

	/**
	 * @param toLoc the toLoc to set
	 */
	public void setToLoc(String toLoc) {
		this.toLoc = toLoc;
	}

	/**
	 * @return the fromLoc
	 */
	public String getFromLoc() {
		return fromLoc;
	}

	/**
	 * @param fromLoc the fromLoc to set
	 */
	public void setFromLoc(String fromLoc) {
		this.fromLoc = fromLoc;
	}

}
