package org.ufla.maratonadeprogramacao._2016.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class C {

	static final int L = 2;
	static final int C = 4;
	static int[][] c = new int[L][C];
	static int[][] cf = new int[L][C];
	static int cus = Integer.MAX_VALUE;

	static int[][] copyArray(int[][] a, int l, int c) {
		int[][] cp = new int[l][c];
		for (int i = 0; i < l; i++) {
			cp[i] = Arrays.copyOf(a[i], c);
		}
		return cp;
	}

	static int[] nearTarget(int t, int x, int y, int[][] cp) {
		int[] xy = new int[2];
		xy[0] = 25;
		xy[1] = 25;
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < C; j++) {
				if (cf[i][j] == t && cp[x][y] != cp[i][j]
						&& Math.abs(x-i)+Math.abs(y-j) < Math.abs(x-xy[0])+Math.abs(y-xy[1])) {
					xy[0] = i;
					xy[1] = j;
				}
			}
		}
		return xy;
	}

	// static BufferedWriter out = new BufferedWriter(new
	// OutputStreamWriter(System.out));
	// static void printArray(int[][] a, int l, int c) throws IOException {
	//	 out.newLine();
	//	 //System.out.println();
	//	 for (int i = 0; i < l; i++) {
	//	 for (int j = 0; j < c; j++) {
	//	 out.write(Integer.toString(a[i][j])+" ");
	//	 //System.out.printf(a[i][j]+" ");
	//	 }
	//	 out.newLine();
	//	 //System.out.println();
	//	 }
	// }

	static void calcCus(int ib, int ib2, int is, int js, int it, 
			int jt, int[][] cp, int cusAux) throws IOException {
		if (cusAux > cus) {
			return;
		}
		if (is == it && js == jt) {
			boolean iguais = true;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < C; j++) {
					if (cp[i][j] != cf[i][j]) {
						int[] xy = nearTarget(cp[i][j], i, j, cp);
						calcCus(-1, -1, i, j, xy[0], xy[1], copyArray(cp, L, C), cusAux);
						iguais = false;
					}
				}
			}
			if (iguais && cusAux < cus) {
				cus = cusAux;
			}
		} else {
			int dif = Math.abs(is - it) + Math.abs(js - jt);
			int[][] cp2 = copyArray(cp, L, C);
			if (js > jt) {
				int aux = cp2[is][js];
				cp2[is][js] = cp2[is][js - 1];
				cp2[is][js - 1] = aux;
				calcCus(is, ib, is, js - 1, it, jt, cp2, cusAux + aux + cp2[is][js]);
			} else if (js < jt) {
				int aux = cp2[is][js];
				cp2[is][js] = cp2[is][js + 1];
				cp2[is][js + 1] = aux;
				calcCus(is, ib, is, js + 1, it, jt, cp2, cusAux + aux + cp2[is][js]);
			}
			if (ib2 != ((is + 1) % 2) && ib != ((is + 1) % 2) && (dif != 1 || is != it)) {
				int aux = cp[is][js];
				cp[is][js] = cp[(is + 1) % 2][js];
				cp[(is + 1) % 2][js] = aux;
				calcCus(is, ib, (is + 1) % 2, js, it, jt, cp, cusAux + aux + cp[is][js]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		for (int i = 0; i < L; i++) {
			strs = in.readLine().trim().split(" ");
			for (int j = 0; j < C; j++) {
				c[i][j] = Integer.parseInt(strs[j]);
			}
		}
		for (int i = 0; i < L; i++) {
			strs = in.readLine().trim().split(" ");
			for (int j = 0; j < C; j++) {
				cf[i][j] = Integer.parseInt(strs[j]);
			}
		}
		in.close();
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < C; j++) {
				if (c[i][j] != cf[i][j]) {
					int[] xy = nearTarget(c[i][j], i, j, c);
					calcCus(-1, -1, i, j, xy[0], xy[1], copyArray(c, L, C), 0);
				}
			}
		}
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		if (cus == Integer.MAX_VALUE) {
			cus = 0;
		}
		out.write(String.valueOf(cus));
		out.newLine();
		out.close();

	}

}
