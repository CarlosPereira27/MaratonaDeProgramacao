package org.ufla.maratonadeprogramacao.generictest;

import java.io.File;

public class Configuration {
	
	String year;
	String phase;
	String step;
	String problem;
	String clazz;
	String testsAdress;
	String command;
	File binDirectory;
	
	public Configuration(String year, String phase, String step, 
			String problem) {
		this.year = year;
		this.phase = phase;
		this.step = step;
		this.problem = problem;
		this.clazz = "org.ufla.maratonadeprogramacao._"+year+"."+phase+"."+step+"."+problem;
		this.testsAdress = "problemas/_"+year+"/"+phase+"/"+step+"/"+problem+"/";
		this.command = "java -Xms512m -Xmx512m -Xss51m "+clazz;
		this.binDirectory = new File("bin");
	}

}
