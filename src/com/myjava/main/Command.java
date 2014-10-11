package com.myjava.main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Command {
	public static Options options = new Options();

	public boolean parseOption(String[] args) {
		List<String> argList = Arrays.asList(args);
		Iterator<String> it = argList.iterator();
		while (it.hasNext()) {
			String opt = it.next();
			if (opt.equals("-server")) {
				options.serverName = it.next();
			} else if(opt.equals("-config")) {
				options.configPath = it.next();
			} else if(opt.equals("-controlPort")) {
				options.controlPort = Integer.parseInt(it.next());
			}
		}
		return true;
	}
}
