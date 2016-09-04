package org.ufla.maratonadeprogramacao._2014.fase1.competicao;

import java.io.IOException;

import org.junit.Test;
import org.ufla.maratonadeprogramacao.generictest.Configuration;
import org.ufla.maratonadeprogramacao.generictest.GenericTest;

public class CompeticaoTest {
	
	String year = "2014";
	String phase = "fase1";
	String step = "competicao";
	
	@Test
	public void testA() throws IOException, InterruptedException {
		GenericTest testGeneric = new GenericTest(new Configuration(year, 
				phase, step, "A"));
		testGeneric.test();
	}
	
	@Test
	public void testB() throws IOException, InterruptedException {
		GenericTest testGeneric = new GenericTest(new Configuration(year, 
				phase, step, "B"));
		testGeneric.test();
	}
	
	@Test
	public void testC() throws IOException, InterruptedException {
		GenericTest testGeneric = new GenericTest(new Configuration(year, 
				phase, step, "C"));
		testGeneric.test();
	}
	
	@Test
	public void testD() throws IOException, InterruptedException {
		GenericTest testGeneric = new GenericTest(new Configuration(year, 
				phase, step, "D"));
		testGeneric.test();
	}
	
	@Test
	public void testE() throws IOException, InterruptedException {
		GenericTest testGeneric = new GenericTest(new Configuration(year, 
				phase, step, "E"));
		testGeneric.test();
	}
	
	@Test
	public void testF() throws IOException, InterruptedException {
		GenericTest testGeneric = new GenericTest(new Configuration(year, 
				phase, step, "F"));
		testGeneric.test();
	}
	
	@Test
	public void testG() throws IOException, InterruptedException {
		GenericTest testGeneric = new GenericTest(new Configuration(year, 
				phase, step, "G"));
		testGeneric.test();
	}
	
	@Test
	public void testH() throws IOException, InterruptedException {
		GenericTest testGeneric = new GenericTest(new Configuration(year, 
				phase, step, "H"));
		testGeneric.test();
	}
	
	@Test
	public void testI() throws IOException, InterruptedException {
		GenericTest testGeneric = new GenericTest(new Configuration(year, 
				phase, step, "I"));
		testGeneric.test();
	}
	
	@Test
	public void testJ() throws IOException, InterruptedException {
		GenericTest testGeneric = new GenericTest(new Configuration(year, 
				phase, step, "J"));
		testGeneric.test();
	}
	
	@Test
	public void testK() throws IOException, InterruptedException {
		GenericTest testGeneric = new GenericTest(new Configuration(year, 
				phase, step, "K"));
		testGeneric.test();
	}
	
}