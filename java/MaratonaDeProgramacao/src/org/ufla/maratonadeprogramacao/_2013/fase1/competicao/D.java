package org.ufla.maratonadeprogramacao._2013.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D {
	
	static int max = 0;
	
	static boolean igual(int[] fa, int[] fs) {
		boolean igual = true;
		for (int i = 0; i < fa.length; i++) {
			if (fa[i] != fs[i]) {
				igual = false;
				break;
			}
		}
		if (igual) {
			return true;
		}
		for (int i = 0; i < fa.length; i++) {
			if (fa[i] != fs[fa.length-1-i]) {
				return false;
			}
		}
		return true;
	}
	
	static int[] dobraIntern(int[] fa, int pos) {
		int[] fd;
		if (pos < fa.length/2f) {
			fd = new int[fa.length-pos];
			int psd = fd.length-pos;
			int ultPosA = fa.length-1;
			for (int i = 0; i < psd; i++) {
				fd[i] = fa[ultPosA-i];
			}
			int posRel = pos*2-1+psd;
			for (int i = psd; i < fd.length; i++) {
				fd[i] = fa[i-psd]+fa[posRel-i];
				if (fd[i] > max) {
					return null;
				}
			}
		} else if (pos == fa.length/2f) {
			fd = new int[fa.length/2];
			int posRel = pos*2-1;
			for (int i = 0; i < fd.length; i++) {
				fd[i] = fa[i]+fa[posRel-i];
				if (fd[i] > max) {
					return null;
				}
			}
		} else {
			fd = new int[pos];
			int psd = fd.length-(fa.length-fd.length);
			for (int i = 0; i < psd; i++) {
				fd[i] = fa[i];
			}
			int posRel = (fa.length-pos)*2-1+psd+psd;
			for (int i = psd; i < fd.length; i++) {
				fd[i] = fa[i]+fa[posRel-i];
				if (fd[i] > max) {
					return null;
				}
			}
		}
		return fd;
	}
	
	static boolean dobrar(int[] fa, int[] fs) {
		if (fa.length < fs.length) {
			return false;
		}
		if (fa.length == fs.length) {
			return igual(fa, fs);
		}
		int[] newFa;
		for (int i = 1; i < fa.length; i++) {
			newFa = dobraIntern(fa, i);
			if (newFa == null) {
				continue;
			}
			if (dobrar(newFa, fs)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] fe = new int[n];
        String[] strs = in.readLine().split(" ");
        long somaFe = 0;
        for (int i = 0; i < n; i++) {
        	fe[i] = Integer.parseInt(strs[i]);
        	somaFe += fe[i];
        }
        int m = Integer.parseInt(in.readLine());;
        int[] fs = new int[m];
        strs = in.readLine().split(" ");
        long somaFs = 0;
        for (int i = 0; i < m; i++) {
        	fs[i] = Integer.parseInt(strs[i]);
        	somaFs += fs[i];
        	if (fs[i] > max) {
        		max = fs[i];
        	}
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        if (somaFe != somaFs) {
        	out.write('N');
        } else if (dobrar(fe, fs)) {
        	out.write('S');
        } else {
        	out.write('N');
        }
    	out.newLine();
        out.close();
	}

}
