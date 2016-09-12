package org.ufla.maratonadeprogramacao._2016.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class L {
	
	static int h;
	static int l;
	static int[][] m;
	static boolean[][] mb;
	static int mt = Integer.MAX_VALUE;
	
	static int findTam(int i, int j, int t) {
		t++;
		mb[i][j] = true;
		if (i+1 < h && !mb[i+1][j] && m[i][j]==m[i+1][j]) {
			t = findTam(i+1, j, t);
		}
		if (i-1 > -1 && !mb[i-1][j] && m[i][j]==m[i-1][j]) {
			t = findTam(i-1, j, t);
		}
		if (j+1 < l && !mb[i][j+1] && m[i][j]==m[i][j+1]) {
			t = findTam(i, j+1, t);
		}
		if (j-1 > -1 && !mb[i][j-1] && m[i][j]==m[i][j-1]) {
			t = findTam(i, j-1, t);
		}
		return t;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = in.readLine().split(" ");
        h = Integer.parseInt(strs[0]);
        l = Integer.parseInt(strs[1]);
        m = new int[h][l];
        mb = new boolean[h][l];
        for (int i = 0; i < h; i++) {
        	strs = in.readLine().split(" ");
        	for (int j = 0; j < l; j++) {
        		m[i][j] = Integer.parseInt(strs[j]);
        	}
        }
        in.close();
        for (int i = 0; i < h; i++) {
        	for (int j = 0; j < l; j++) {
        		if (!mb[i][j]) {
        			int t = findTam(i, j, 0);
        			if (t < mt) {
        				mt = t;
        			}
        		}
        	}
        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(String.valueOf(mt));
        out.newLine();
        out.close();
	}

}
