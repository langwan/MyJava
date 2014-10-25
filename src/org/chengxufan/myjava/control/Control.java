package org.chengxufan.myjava.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Control implements Runnable {
	private static final Logger logger = LoggerFactory
			.getLogger(Control.class);
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
			while (true) {
				socket = server.accept();
				Thread t = new Thread(new ControlTask(socket));
				t.start();
			}
		} catch (IOException e) {
			logger.error("Unable to listening server port", e);
		}
	}

}
