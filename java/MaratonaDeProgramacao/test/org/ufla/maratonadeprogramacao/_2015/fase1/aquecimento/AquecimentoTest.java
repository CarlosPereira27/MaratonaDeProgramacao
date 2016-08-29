package org.ufla.maratonadeprogramacao._2015.fase1.aquecimento;

import java.io.IOException;

import org.junit.Test;
import org.ufla.maratonadeprogramacao.generictest.Configuration;
import org.ufla.maratonadeprogramacao.generictest.GenericTest;

public class AquecimentoTest {

	String year = "2015";
	String phase = "fase1";
	String step = "aquecimento";
	
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
	
}