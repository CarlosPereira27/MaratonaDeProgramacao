package org.ufla.maratonadeprogramacao._2016.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
	
	static int T = 3;
	static int MAX = T-1;
	static int[] val = new int[T];
	
	static boolean naive() {
		if (val[0]+val[1]-val[2]==0 || val[0]-val[1]+val[2]==0 || 
				val[0]-val[1]-val[2]==0 || -val[0]+val[1]+val[2]==0 || 
				-val[0]+val[1]-val[2]==0 || -val[0]-val[1]+val[2]==0 || 
				val[0]==val[1] || val[0]==val[2] || val[1]==val[2]) {
			return true;
		}
		return false;
	}
	
	static boolean recGen() {
		for (int i = 0; i < MAX; i++) {
			if (recIn(i+1, val[i]) || recIn(i+1, -val[i])) {
				return true;
			}
		}
		return false;
	}
	
	static boolean recIn(int i, int t) {
		//Somente verificar
		if (t == 0 || (i < MAX && recIn(i+1, t))) {
			return true;
		}
		//Somar
		t += val[i];
		if (t == 0 || (i < MAX && recIn(i+1, t))) {
			return true;
		}
		//Subtrair
		t -= val[i]+val[i];
		if (t == 0 || (i < MAX && recIn(i+1, t))) {
			return true;
		}
		return false;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = in.readLine().split(" ");
        for (int i = 0; i < T; i++) {
        	val[i] = Integer.parseInt(strs[i]);
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        if (recGen()) {
        	out.write("S");
        } else {
        	out.write("N");
        }
        out.newLine();
        out.close();
	}

}
