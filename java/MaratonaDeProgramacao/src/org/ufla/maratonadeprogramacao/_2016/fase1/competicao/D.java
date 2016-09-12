package org.ufla.maratonadeprogramacao._2016.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class D {
	

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = in.readLine().split(" ");
        in.close();
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        int c = Integer.parseInt(strs[2]);
        int d = Integer.parseInt(strs[3]);
        int sqrt = (int) Math.sqrt(c);
        if (sqrt*sqrt < c) {
        	sqrt++;
        }
        ArrayList<Integer> divL = new ArrayList<>();
        int menor = -1;
        for (int i = 1; i < sqrt; i++) {
        	if (c%i==0) {
        		if (i%a==0 && i%b!=0 && d%i!=0) {
        			menor = i;
        			break;
        		}
        		divL.add(c/i);
        	}
        }
        if (menor==-1 && sqrt*sqrt==c && sqrt%a==0 && sqrt%b!=0 && d%sqrt!=0) {
        	menor = sqrt;
        }
        if (menor==-1) {
        	Integer[] div = new Integer[divL.size()]; 
        	div = divL.toArray(div);
        	divL.clear();
        	divL = null;
        	for (int i = div.length-1; i > -1; i--) {
        		if (div[i]%a==0 && div[i]%b!=0 && d%div[i]!=0) {
        			menor = div[i];
        			break;
        		}
        	}
        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(Integer.toString(menor));
        out.newLine();
        out.close();
	}

}
