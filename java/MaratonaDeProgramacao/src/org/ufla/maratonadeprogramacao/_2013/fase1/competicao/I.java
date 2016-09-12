package org.ufla.maratonadeprogramacao._2013.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class I {
	
	static int t1;
	static int t2;
	static int[] cob;
	static int[] f;
	
	static int maiorJ(int i, int t) {
		int j = i;
		while (f[i]-f[j] <= t) {
			j--;
		}
		return j;
	}
	
	static int cobertura(int i) {
		int resp1, resp2;
		if (f[i]-f[0] <= t1) {
			resp1 = t1;
		} else {
			int j = maiorJ(i, t1);
			resp1 = cob[j]+t1;
		}
		if (f[i]-f[0] <= t2) {
			resp2 = t2;
		} else {
			int j = maiorJ(i, t2);
			resp2 = cob[j]+t2;
		}
		return Math.min(resp1, resp2);
	}

	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while (in.ready()) {
	        String[] strs = in.readLine().split(" ");
	        int n = Integer.parseInt(strs[0]);
	        t1 = Integer.parseInt(strs[2]);
	        t2 = Integer.parseInt(strs[3]);
	        f = new int[n];
	        cob = new int[n];
	        strs = in.readLine().split(" ");
	        for (int i = 0; i < f.length; i++) {
	        	f[i] = Integer.parseInt(strs[i]);
	        	cob[i] = cobertura(i);
	        }	        
	        out.write(Integer.toString(cob[n-1]));
	        out.newLine();
        }
        in.close();
        out.close();
	}

}
