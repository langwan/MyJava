package org.chengxufan.myjava.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

	public String envName = null;

	private static Config instance = null;

	public Config(String configPath) throws FileNotFoundException,
			IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(configPath));
		envName = prop.getProperty("ENV_NAME");
	}

	public static Config init(String configPath)
			throws FileNotFoundException, IOException {
		if (instance == null) {
			instance = new Config(configPath);
		}
		return instance;
	}

	public static Config getInstance() {
		return instance;
	}
}
