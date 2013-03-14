package edu.wpi.tmathmeyer.protocol.tools;

import java.io.IOException;

public class PsuedoOutputStream extends java.io.OutputStream{
	
	PacketValidator pv;
	
	public PsuedoOutputStream(PacketValidator pv){
		this.pv = pv;
	}
	
	@Override
	public void write(int b) throws IOException {
		pv.write(b);
	}
	
}
