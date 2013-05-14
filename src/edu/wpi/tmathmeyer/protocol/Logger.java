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

import java.util.HashMap;


public class Logger {
	public static HashMap<String, Packet> map = new HashMap<String, Packet>();
	public static void log(Packet p){
		Logger.map.put(p.getPacketID()+"", p);
	}
	@SuppressWarnings("rawtypes")
	public static Class retrieve(byte ID){
		Packet p = Logger.map.get(ID+"");
		try{
			return p.getClass();
		}
		catch(Exception e){
			System.out.println("weeeeeeeeeeee");
			return null;
		}
	}
}
