# MulticastSocketClientAndServer

package com.tk.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 功能:组播客户端
 * 描述:
 * @author jinhuatao
 * @date 2015-3-5 上午10:11:50
 */
public class MultiClient {
	public static void main(String[] args) {
		try {
			//创建socket
			MulticastSocket socket = new MulticastSocket();
			InetAddress group = InetAddress.getByName("127.0.0.1");
			
			//创建发送数据包
			byte[] dummy = new byte[256];
			DatagramPacket sendPackage = 
					new DatagramPacket(dummy, 0,group,10000);
			
			//发送数据
			for(int i=0;i<5;i++){
				byte[] buffer = ("Data line"+i).getBytes();
				sendPackage.setData(buffer);
				sendPackage.setLength(buffer.length);
				socket.send(sendPackage);
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
