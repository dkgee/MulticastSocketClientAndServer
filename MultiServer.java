package com.tk.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 功能:组播数据
 * 描述:
 * @author jinhuatao
 * @date 2015-3-4 下午6:07:56
 */
public class MultiServer {
	public static void main(String[] args) {
		try {
			//创建socket
			MulticastSocket socket = new MulticastSocket(10000);
			InetAddress group = InetAddress.getByName("231.0.0.0");
			socket.joinGroup(group);
			
			//接受数据包
			for(int i=0;i < 100;i++){
				byte[] buffer = new byte[256];
				DatagramPacket receivePacket = 
						new DatagramPacket(buffer, buffer.length);
				socket.receive(receivePacket);
				
				byte[] buffer2 = new byte[receivePacket.getLength()];
				System.arraycopy(receivePacket.getData(), 0,
						buffer2, 0, receivePacket.getLength());
				System.out.println(new String(buffer2));
			}
			
			//删除组播地址
			socket.leaveGroup(group);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
