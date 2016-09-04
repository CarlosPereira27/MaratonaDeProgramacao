package org.ufla.maratonadeprogramacao._2014.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {

	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = in.readLine().trim().split(" ");
        in.close();
        int x = Integer.parseInt(strs[0]);
        int y = Integer.parseInt(strs[1]);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(String.valueOf(
        		(int) Math.ceil((double)x/(y-x)) +1
        		));
        out.newLine();
        out.close();
	}

}
