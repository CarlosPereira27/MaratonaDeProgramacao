package org.ufla.maratonadeprogramacao._2014.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class H {

	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = in.readLine().trim().split(" ");
        int n = Integer.parseInt(strs[0]);
        //int m = Integer.parseInt(strs[1]);
        String str;
        int jog = 0;
        for (int i = 0; i < n; i++) {
        	str = in.readLine().trim();
        	if ( !(str.matches("^0 .*") || str.matches(".* 0 .*") || 
        			str.matches(".* 0$")) ) {
        		jog++;
        	}
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(String.valueOf(jog));
        out.newLine();
        out.close();
	}

}
