package org.chengxufan.myjava.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlTask implements Runnable {
	private static final Logger logger = LoggerFactory
			.getLogger(ControlTask.class);
	private Socket socket = null;

	public ControlTask(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		InputStream in;
		String info = null;
		try {
			in = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(in));

			OutputStream out = socket.getOutputStream();
			while ((info = br.readLine()) != null) {
				pw = new PrintWriter(out);
				pw.println(Thread.currentThread().getId()
						+ ": myjava control telnet.\n");
				pw.flush();

			}
		} catch (IOException e) {
			logger.error("Unable to reading admin command", e);
		}
	}

}
