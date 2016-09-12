package org.ufla.maratonadeprogramacao._2016.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class I {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] m = new int[n];
		String[] strs = in.readLine().split(" ");
		in.close();
		m[0] = 1;
		int uI = n - 1;
		m[uI] = 1;
		for (int i = 1; i < uI; i++) {
			m[i] = Integer.parseInt(strs[i]);
		}
		
		for (int i = 0; i < uI; i++) {
			if (m[i] > m[i + 1]) {
				m[i] = m[i + 1] + 1;
				int j = i - 1;
				while (j > -1 && m[j] > m[j + 1]) {
					m[j] = m[j + 1] + 1;
					j--;
				}
			} else if (m[i] < m[i + 1]) {
				m[i + 1] = m[i] + 1;
			}
		}
		int maiorT = 1;
		for (int i = 0; i < n; i++) {
			if (m[i] > maiorT) {
				maiorT = m[i];
			}
		}
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		out.write(Integer.toString(maiorT));
		out.newLine();
		out.close();
	}

}
