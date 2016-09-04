package org.ufla.maratonadeprogramacao._2013.fase1.competicao;

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
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        int c = Integer.parseInt(strs[2]);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        if (a!=b && a!=c && b==c) {
        	out.write('A');
        } else if (b!=a && b!=c && a==c) {
        	out.write('B');
        } else if (c!=a && c!=b && a==b) {
        	out.write('C');
        } else {
        	out.write('*');
        }
        out.newLine();
        out.close();
	}

}
