package org.ufla.maratonadeprogramacao._2013.fase1.aquecimento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {
	
	static final int AGUAS_INTER = 12;

	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = in.readLine().trim().split(" ");
        in.close();
        int d = Integer.parseInt(strs[0]);
        int vf = Integer.parseInt(strs[1]);
        int vg = Integer.parseInt(strs[2]);
        double tf = (double)AGUAS_INTER/vf;
        double tg = Math.sqrt(d*d+AGUAS_INTER*AGUAS_INTER)/vg;
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        if (tg <= tf) {
        	out.write(String.valueOf('S'));
        } else {
        	out.write(String.valueOf('N'));
        }
        out.newLine();
        out.close();
	}

}
