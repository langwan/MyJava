package org.chengxufan.myjava.server;

import org.chengxufan.myjava.main.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server implements Runnable {
	private static final Logger logger = LoggerFactory
			.getLogger(Server.class);
	private Options options = null;

	public Server(Options options) {
		this.options = options;
	}

	@Override
	public void run() {

		logger.info("serverName is " + options.serverName);

		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				logger.debug("Unexpected interruption", e);
			}
			System.out.println(".");
		}
	}
}
