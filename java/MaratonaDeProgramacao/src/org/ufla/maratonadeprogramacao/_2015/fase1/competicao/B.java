package org.ufla.maratonadeprogramacao._2015.fase1.competicao;

import java.util.Scanner;

public class B {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int n = in.nextInt();
		final int c = in.nextInt();
		final int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = in.nextInt();
		}
		in.close();
		boolean optVenda = false;
		int venda = 0;
		int compra = 0;
		int lucro = 0;
		compra = p[0];
		for (int i = 1; i < n; i++) {
			if (p[i] < compra) {
				if (optVenda) {
					lucro += venda-(compra+c);
					optVenda = false;
				}
				compra = p[i];
			} else {
				if (optVenda) {
					if (p[i] > venda) {
						venda = p[i];
					} else if (p[i]+c < venda) {
						lucro += venda-(compra+c);
						optVenda = false;
						compra = p[i];
					}
				} else {
					if (p[i] > compra+c) {
						optVenda = true;
						venda = p[i];
					}
				}
			}
		}
		if (optVenda) {
			lucro += venda-(compra+c);
		}
		System.out.println(lucro);
	}

}
