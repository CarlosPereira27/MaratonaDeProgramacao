package org.ufla.maratonadeprogramacao._2015.fase1.competicao;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long b = in.nextLong();
		in.close();
		long restB = n*n-b;
		long raiz = (long) Math.sqrt(restB) + 1;
		if (raiz > n) {
			raiz = n;
		}
		long difer = raiz*raiz-restB-1;
		long l, c;
		l = c = (n-raiz) / 2;
		if (raiz%2 == 0 && n%2 == 0 || 
				raiz%2 == 1 && n%2 == 1) {
			l += 1;
			c += 1;
			if (difer <= raiz-1) {
				c += difer;
			} else {
				c += raiz-1;
				l += difer-(raiz-1);
			}
		} else {
			l += raiz+1;
			c += raiz;
			if (difer <= raiz-1) {
				c -= difer;
			} else {
				c -= raiz-1;
				l -= difer-(raiz-1);
			}
		}
		
		System.out.println(l+" "+c);
	}

}
