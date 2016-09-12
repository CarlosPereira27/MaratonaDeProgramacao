package org.ufla.maratonadeprogramacao._2016.fase1.aquecimento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = in.readLine().split(" ");
        //int n = Integer.parseInt(strs[0]);
        int l = Integer.parseInt(strs[1]);
        int c = Integer.parseInt(strs[2]);
        String conto = in.readLine();
        in.close();
        int lin=1, cLin=0, i=0, espI, palT;
        while ((espI = conto.indexOf(' ', i)) > -1) {
        	palT = espI-i;
        	cLin += palT;
        	if (cLin > c) {
        		cLin = palT;
        		lin++;
        	}
    		cLin++;
    		i = espI+1;
        }
        cLin += conto.length()-1-conto.lastIndexOf(' ');
        if (cLin > c) {
        	lin++;
        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(String.valueOf((int)Math.ceil((double)lin/l)));
        out.newLine();
        out.close();
	}

}
