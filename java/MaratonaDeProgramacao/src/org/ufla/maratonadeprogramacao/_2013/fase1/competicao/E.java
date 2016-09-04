package org.ufla.maratonadeprogramacao._2013.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class E {

	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = in.readLine().trim().split(" ");
        int n = Integer.parseInt(strs[0]);
        int r = Integer.parseInt(strs[1]);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        if (n == r) {
        	out.write('*');
        } else {
            boolean[] v = new boolean[n];
            strs = in.readLine().trim().split(" ");
            for (int i = 0; i < r; i++) {
            	v[Integer.parseInt(strs[i])-1] = true;
            }
        	for (int i = 0; i < n; i++) {
        		if (!v[i]) {
        			out.write(String.valueOf(i+1));
        			out.write(' ');
        		}
        	}
        }
        in.close();
        out.newLine();
        out.close();
	}

}
