package day20.socket5;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import day20.socket4.Client;

public class ServerEx05 {
	public static void main(String[] args) {
	int port = 5001;
		List<ObjectOutputStream> list = new ArrayList<ObjectOutputStream>();
		try(ServerSocket serverSocket = new ServerSocket(port)){
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("[연결 성공]");
				Server server = new Server(list, socket);
				server.receive();
				Client client = new Client(socket);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
