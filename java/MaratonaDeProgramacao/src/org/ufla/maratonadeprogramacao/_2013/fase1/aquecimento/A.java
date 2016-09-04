package org.ufla.maratonadeprogramacao._2013.fase1.aquecimento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
	
	static final int TAMANHOS = 31;
	static final int MIN_TAM = 30;
	static final int MAX_TAM = 60;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());
        int[] bd = new int[TAMANHOS];
        int[] be = new int[TAMANHOS];
        String[] strs;
        for (int i = 0; i < n; i++) {
        	strs = in.readLine().trim().split(" ");
        	int num = Integer.parseInt(strs[0]);
        	if (strs[1].charAt(0) == 'D') {
        		bd[num-MIN_TAM]++;
        	} else {
        		be[num-MIN_TAM]++;
        	}
        }
        in.close();
        int pares = 0;
        for (int i = 0; i < TAMANHOS; i++) {
        	pares += Math.min(bd[i], be[i]);
        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(Integer.toString(pares));
        out.newLine();
        out.close();
	}

}
