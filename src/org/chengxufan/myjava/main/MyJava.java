package org.chengxufan.myjava.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.chengxufan.myjava.control.Control;
import org.chengxufan.myjava.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJava {

	private static final Logger logger = LoggerFactory
			.getLogger(MyJava.class);

	public MyJava(String[] args) throws FileNotFoundException, IOException {
		PropertyConfigurator.configure(Command.options.configPath
				+ "log4j.properties");
		new Command().parseOption(args);
		Config.init(Command.options.configPath);
		logger.info("ENV_NAME is " + Config.getInstance().envName);
	}

	public static void main(String[] args) {
		MyJava server;
		try {
			server = new MyJava(args);
			server.run();
		} catch (IOException e) {
			logger.error("Invalid IO, exiting abnormally", e);
			System.exit(2);
		} catch (Exception e) {
			logger.error("Unexpected exception, exiting abnormally",
					e);
			System.exit(1);
		}
		logger.info("Exiting normally");
		System.exit(0);
	}

	private void run() throws IOException {

		logger.info("Welcome to MyJava Server!");

		Thread t = new Thread(new Control(Command.options.controlPort));
		t.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			logger.warn("Interrupted while sleeping. "
					+ "Ignoring exception", e);
		}

		t = new Thread(new Server(Command.options));
		t.start();
	}

}
