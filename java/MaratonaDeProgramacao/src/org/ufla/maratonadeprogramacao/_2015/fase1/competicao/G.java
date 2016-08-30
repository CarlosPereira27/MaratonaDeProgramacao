package org.ufla.maratonadeprogramacao._2015.fase1.competicao;

import java.util.Scanner;

public class G {
	
	static long arranjo(int n, int k) {
		long result = n-k+1;
		for (int i = n-k+2; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		in.close();
		if (k == 1 && n == 1) {
			System.out.println("1");
		}
		if (k == 1 && n != 1) {
			System.out.println("0");
		}
		if (k == 1) {
			return;
		}
		long result = 0;
		for (int i = k; i > 1; i--) {
			result += arranjo(n, i);
		}
		System.out.println(result);
		

	}

}
