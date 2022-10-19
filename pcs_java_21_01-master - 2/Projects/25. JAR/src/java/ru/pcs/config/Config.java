package ru.pcs.config;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	private int threadsCount;

	public Config() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("resources/threads.properties"));
			this.threadsCount = Integer.parseInt(properties.getProperty("executor.threads.count"));
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public int getThreadsCount() {
		return threadsCount;
	}
}