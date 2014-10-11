package com.myjava.server;

import com.myjava.main.Options;

public class Server implements Runnable {
	private Options options = null;
	public Server(Options options) {
		this.options = options;
	}
	@Override
	public void run() {
		
		System.out.println("serverName is " + options.serverName);
		
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(".");
		}
	}
}
