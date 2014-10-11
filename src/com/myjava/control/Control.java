package com.myjava.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Control implements Runnable {
	private int port;
	public Control(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		Socket socket = null;
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println("Telnet listen port " + port);
			while(true) {
				socket = server.accept();
				Thread t = new Thread(new ControlTask(socket));
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
