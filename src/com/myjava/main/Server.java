package com.myjava.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {
	Logger logger = LoggerFactory.getLogger(Server.class);
	public Server(String[] args) {

	}

	public static void main(String[] args) {
		Server server = new Server(args);
		server.run();
	}

	private void run() {
		System.out.println("Welcome to MyJava Server!");
		logger.info("Welcome to MyJava Server!");
	}
}
