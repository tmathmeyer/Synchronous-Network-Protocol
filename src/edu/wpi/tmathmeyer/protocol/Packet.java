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
package edu.wpi.tmathmeyer.protocol;

import java.io.DataOutputStream;
import java.io.IOException;

public interface Packet {
	/**
	 * 
	 * @return the ID of the packet
	 */
	public byte getPacketID();
	
	
	/**
	 * 
	 * @param d the dataoutputstream for the packet data to be written to
	 * @throws IOException a closed or malformed DoS
	 */
	public abstract void write(DataOutputStream d) throws IOException;
}
