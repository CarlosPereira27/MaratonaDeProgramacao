package org.ufla.maratonadeprogramacao._2014.fase1.competicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class C {
	
	static class Plano {
		int a;
		int b;
		int c;
		int d;
		
		public Plano(String[] strs) {
			super();
			this.a = Integer.parseInt(strs[0]);
			this.b = Integer.parseInt(strs[1]);
			this.c = Integer.parseInt(strs[2]);
			this.d = Integer.parseInt(strs[3]);
		}
		
		public char getLocalizacaoRelativa(Planeta p) {
			if ((a*p.x + b*p.y + c*p.z) > d) {
				return 'g';
			} else {
				return 'l';
			}
		}
	}
	
	static class Planeta {
		int x;
		int y;
		int z;
		
		public Planeta(String[] strs) {
			super();
			this.x = Integer.parseInt(strs[0]);
			this.y = Integer.parseInt(strs[1]);
			this.z = Integer.parseInt(strs[2]);
		}
	}

	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = in.readLine().trim().split(" ");
        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);
        Plano[] planos = new Plano[m];
        for (int i = 0; i < m; i++) {
        	strs = in.readLine().trim().split(" ");
        	planos[i] = new Plano(strs);
        }
        Map<String, Integer> regioes = new HashMap<>();
        Planeta planeta = null;
        StringBuilder regiao;
        int maxPlanetas = 1;
        for (int i = 0; i < n; i++) {
        	strs = in.readLine().trim().split(" ");
        	planeta = new Planeta(strs);
        	regiao = new StringBuilder();
        	for (int j = 0; j < m; j++) {
        		regiao.append(planos[j].getLocalizacaoRelativa(planeta));
        	}
        	if (regioes.containsKey(regiao.toString())) {
        		Integer ip = regioes.get(regiao.toString());
        		if (ip == maxPlanetas) {
        			maxPlanetas++;
        		}
        		regioes.put(regiao.toString(), ip+1);
        	} else {
        		regioes.put(regiao.toString(), 1);
        	}
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(String.valueOf(maxPlanetas));
        out.newLine();
        out.close();
	}

}
