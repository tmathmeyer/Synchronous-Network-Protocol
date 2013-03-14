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
