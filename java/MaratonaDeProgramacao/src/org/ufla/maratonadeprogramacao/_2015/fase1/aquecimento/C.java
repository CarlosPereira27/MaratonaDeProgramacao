package org.ufla.maratonadeprogramacao._2015.fase1.aquecimento;

import java.util.Scanner;

public class C {
	
	public static void main(String[] args) {
		
		final int qtdReguas = 4;
		Scanner in = new Scanner(System.in);
		int maxTomadas = -(qtdReguas-1);
		for (int i = 0; i < qtdReguas; i++) {
			maxTomadas += in.nextInt();
		}
		in.close();
		System.out.println(maxTomadas);		
	}

}
