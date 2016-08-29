package org.ufla.maratonadeprogramacao._2015.fase1.competicao;

import java.util.Scanner;

public class C {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int a = in.nextInt();
		final int b = in.nextInt();
		in.close();
		if (a > b) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}
	}

}
