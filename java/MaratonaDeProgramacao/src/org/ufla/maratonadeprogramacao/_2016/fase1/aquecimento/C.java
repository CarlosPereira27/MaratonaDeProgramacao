package org.ufla.maratonadeprogramacao._2016.fase1.aquecimento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = in.readLine().split(" ");
        in.close();
        double h = Double.parseDouble(strs[0]);
        int p = Integer.parseInt(strs[1]);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(String.format("%.2f", h/p));
        out.newLine();
        out.close();
	}

}
