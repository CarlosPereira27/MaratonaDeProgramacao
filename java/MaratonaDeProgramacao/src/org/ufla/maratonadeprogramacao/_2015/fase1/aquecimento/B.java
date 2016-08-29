package org.ufla.maratonadeprogramacao._2015.fase1.aquecimento;

import java.util.Arrays;
import java.util.Scanner;

public class B {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] varetas = new int[4];
		for (int i = 0; i < 4; i++) {
			varetas[i] = in.nextInt();
		}
		in.close();
		Arrays.sort(varetas);
		if (varetas[0]+varetas[1] > varetas[2]) {
			System.out.println('S');
		} else if (varetas[1]+varetas[2] > varetas[3]) {
			System.out.println('S');
		} else {
			System.out.println('N');
		}
	}

}
