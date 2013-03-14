package edu.wpi.tmathmeyer.protocol.tools;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import edu.wpi.tmathmeyer.protocol.chat.MessagePacket;

public class PacketValidator {
	LinkedList<Integer> data = new LinkedList<Integer>();
	int pos = 0;
	
	public int read(){
		int res = data.get(pos);
		pos++;
		return res;
	}
	
	public void write(int i){
		this.data.add(i);
	}
	
	public DataOutputStream getDataOutputStream(){
		return new DataOutputStream(new PsuedoOutputStream(this));
	}
	
	public DataInputStream getDataInputStream(){
		return new DataInputStream(new PseudoInputStream(this));
	}
	
	
	public static void main(String[] args) throws IOException{
		MessagePacket p = new MessagePacket("this is a message", "ted");
		PacketValidator pv = new PacketValidator();
		
		p.write(pv.getDataOutputStream());
		MessagePacket clone = new MessagePacket(pv.getDataInputStream());
		System.out.println(clone.getMessage());
	}
}
