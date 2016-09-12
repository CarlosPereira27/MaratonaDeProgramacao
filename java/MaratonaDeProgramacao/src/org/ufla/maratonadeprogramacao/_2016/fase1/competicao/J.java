package org.ufla.maratonadeprogramacao._2016.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class J {
	
	static int n;
	static int[] h;
	static int[] vh;
	static int[] c;
	static int[] vc;
	static int limInf;
	static int limSup;
	
	static boolean ouro(int j) {
		limInf = 0;
		limSup = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (i == j) {
				continue;
			}
			
			//Variação de h
			if (vh[j] > vh[i]) {
				if (h[j] < h[i]) {
					int lim = (h[i]-h[j])/(vh[j]-vh[i])+1;
					if (lim > limInf) {
						limInf = lim;
						if (limInf > limSup) {
							return false;
						}
					}
				} else if (h[j] == h[i] && limInf == 0) {
					limInf = 1;
					if (limSup == 0) {
						return false;
					}
				}
			} else if (vh[j] == vh[i]) {
				if (h[j] <= h[i]) {
					return false;
				}
			} else {
				if (h[j] <= h[i]) {
					return false;
				} else {
					int lim = (h[j]-h[i])/(vh[i]-vh[j]);
					if ((h[j]-h[i]) % (vh[i]-vh[j]) == 0) {
						lim--;
					}
					if (lim < limSup) {
						limSup = lim;
						if (limSup < limInf) {
							return false;
						}
					}
				}
			}
			
			//Variação de c
			if (vc[j] < vc[i]) {
				if (c[j] > c[i]) {
					int lim = (c[j]-c[i])/(vc[i]-vc[j])+1;
					if (lim > limInf) {
						limInf = lim;
						if (limInf > limSup) {
							return false;
						}
					}
				} else if (h[j] == h[i] && limInf == 0) {
					limInf = 1;
					if (limSup == 0) {
						return false;
					}
				}
			} else if (vc[j] == vc[i]) {
				if (c[j] >= c[i]) {
					return false;
				}
			} else {
				if (c[j] >= c[i]) {
					return false;
				} else {
					int lim = (c[i]-c[j])/(vc[j]-vc[i]);
					if ((c[i]-c[j]) % (vc[j]-vc[i]) == 0) {
						lim--;
					}
					if (lim < limSup) {
						limSup = lim;
						if (limSup < limInf) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        h = new int[n];
        vh = new int[n];
        c = new int[n];
        vc = new int[n];
        String[] strs;
        for (int i = 0; i < n; i++) {
        	strs = in.readLine().split(" ");
        	h[i] = Integer.parseInt(strs[0]);
        	vh[i] = Integer.parseInt(strs[1]);
        	c[i] = Integer.parseInt(strs[2]);
        	vc[i] = Integer.parseInt(strs[3]);
        }
        in.close();
        int jogO = 0;
        for (int i = 0; i < n; i++) {
        	if (ouro(i)) {
        		jogO++;
        	}
        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(Integer.toString(jogO));
        out.newLine();
        out.close();
	}

}
