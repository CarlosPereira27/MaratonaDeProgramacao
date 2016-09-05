package org.ufla.maratonadeprogramacao._2013.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class F {

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, soma[], i, resp, len, len2, j, k;
        String[] strs;
        while (in.ready()) {
        	n = Integer.parseInt(in.readLine());
	        soma = new int[n];
	        strs = in.readLine().split(" ");
	        soma[0] = Integer.parseInt(strs[0]);
	        for (i = 1; i < soma.length; i++) {
	        	soma[i] = soma[i-1]+Integer.parseInt(strs[i]);
	        }
	        resp = 0;
	        len = soma[n-1]/3;
	        len2 = len*2;
	        j = 0;
	        k = 0;
	        for (i = 0; soma[i] <= len; i++) {
	        	while (soma[j] < soma[i]+len) {
	        		j++;
	        	}
	        	while (soma[k] < soma[i]+len2) {
	        		k++;
	        	}
	        	if (soma[j] == soma[i]+len && soma[k] == soma[i]+len2) {
	        		resp++;
	        	}
	        }
	        out.write(Integer.toString(resp));
	        out.newLine();
        }
        in.close();
	    out.close();
	}

}
