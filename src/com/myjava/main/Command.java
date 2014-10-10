package com.myjava.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Command {
	public static Options options = new Options();

	public boolean parseOption(String[] args) {
		List<String> argList = Arrays.asList(args);
		Iterator<String> it = argList.iterator();

		while (it.hasNext()) {
			String opt = it.next();

			if (opt.equals("-server")) {
				options.serverName = it.next();
			}
		}
		return true;
	}
}
