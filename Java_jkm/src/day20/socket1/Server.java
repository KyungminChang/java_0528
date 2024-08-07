package day20.socket1;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void server() {
		int port = 3000;
		ServerSocket server;
		try {
			server = new ServerSocket(port);
			while(true) {
				Socket client = server.accept();
			}
		}catch(Exception e){
			e.addSuppressed(e);
		}
	}

}
