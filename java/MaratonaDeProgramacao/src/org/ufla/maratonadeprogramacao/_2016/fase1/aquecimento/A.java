package org.ufla.maratonadeprogramacao._2016.fase1.aquecimento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
	
	static void hexToInt() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println(Integer.parseInt(in.readLine(), 16));
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long r = Long.parseLong(in.readLine(), 16);
		long g = Long.parseLong(in.readLine(), 16);
		long b = Long.parseLong(in.readLine(), 16);
		in.close();
		long max = 1;
		long maxG = r/g;
		maxG *= maxG;
		max += maxG;
		long maxB = g/b;
		maxB *= maxB*maxG;
		max += maxB;
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(Long.toString(max, 16));
        out.newLine();
        out.close();
	}

}
