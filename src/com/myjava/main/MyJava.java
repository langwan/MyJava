package com.myjava.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myjava.control.Control;
import com.myjava.server.Server;

public class MyJava {
	
	Logger logger = LoggerFactory.getLogger(MyJava.class);
	
	public MyJava(String[] args) {
		new Command().parseOption(args);
	}

	public static void main(String[] args) {
		MyJava server = new MyJava(args);
		server.run();
	}

	private void run() {
		System.out.println("Welcome to MyJava Server!");
		
		logger.info("Welcome to MyJava Server!");
		
		Thread t = new Thread(new Control(Command.options.controlPort));
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t = new Thread(new Server(Command.options));
		t.start();
	}
	
}
