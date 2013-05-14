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
package edu.wpi.tmathmeyer.protocol.tools;

import java.io.IOException;

public class PseudoInputStream extends java.io.InputStream{

	PacketValidator pv;
	
	public PseudoInputStream(PacketValidator pv){
		this.pv = pv;
	}
	
	@Override
	public int read() throws IOException {
		return pv.read();
	}

}
