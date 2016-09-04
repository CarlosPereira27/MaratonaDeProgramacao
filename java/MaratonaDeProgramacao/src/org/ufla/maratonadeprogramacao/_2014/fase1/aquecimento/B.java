package org.ufla.maratonadeprogramacao._2014.fase1.aquecimento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(in.readLine().trim());
        String str = in.readLine().trim();
        in.close();
        char dir = 'N';
        for (int i = 0; i < str.length(); i++) {
        	switch (dir) {
        	case 'N':
        		if (str.charAt(i) == 'E') {
        			dir = 'O';
        		} else {
        			dir = 'L';
        		}
        		break;
        	case 'L':
        		if (str.charAt(i) == 'E') {
        			dir = 'N';
        		} else {
        			dir = 'S';
        		}
        		break;
        	case 'O':
        		if (str.charAt(i) == 'E') {
        			dir = 'S';
        		} else {
        			dir = 'N';
        		}
        		break;
        	case 'S':
        		if (str.charAt(i) == 'E') {
        			dir = 'L';
        		} else {
        			dir = 'O';
        		}
        		break;
        	default: break;
        	}
        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(dir);
        out.newLine();
        out.close();
	}

}
