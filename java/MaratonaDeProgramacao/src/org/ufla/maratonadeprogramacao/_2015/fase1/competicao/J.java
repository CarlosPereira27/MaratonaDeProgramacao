package org.ufla.maratonadeprogramacao._2015.fase1.competicao;

import java.util.Scanner;

public class J {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int j = in.nextInt();
		int r = in.nextInt();
		int jogadas = j*r;
		
		long[] pontos = new long[j];
		for (int i = 0; i < jogadas; i++) {
			pontos[i%j] += in.nextInt();
		}
		in.close();
		long vp = pontos[0];
		int vi = 0;
		for (int i = 0; i < j; i++) {
			if (pontos[i] >= vp) {
				vp = pontos[i];
				vi = i;
			}
		}
		System.out.println(vi+1);
	}

}
