package ru.pcs.app;

import ru.pcs.config.Config;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.util.List;

@Parameters(separators = "=")
class Main {

	@Parameter(names = {"--files"})
	private List<String> files;

	public static void main(String args[]) {
		Config config = new Config();
		System.out.println(config.getThreadsCount());
		Main main = new Main();

		JCommander.newBuilder()
			.addObject(main)
			.build()
			.parse(args);

		System.out.println(main.files);
	}
}