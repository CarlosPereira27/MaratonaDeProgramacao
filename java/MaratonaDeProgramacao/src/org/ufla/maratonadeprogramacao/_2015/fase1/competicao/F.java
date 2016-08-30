package org.ufla.maratonadeprogramacao._2015.fase1.competicao;

import java.util.Scanner;

public class F {
	
	static final int MAX_FAT = 8;
	static int[] fat = new int[MAX_FAT];
	
	static void preencheFatTable() {
		fat[0] = 1;
		for (int i = 1; i < MAX_FAT; i++) {
			fat[i] = fat[i-1]*(i+1);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		preencheFatTable();
		int contador = 0;
		for (int i = MAX_FAT-1; i > -1; i--) {
			while (n >= fat[i]) {
				n -= fat[i];
				contador++;
			}
		}
		System.out.println(contador);
	}

}
