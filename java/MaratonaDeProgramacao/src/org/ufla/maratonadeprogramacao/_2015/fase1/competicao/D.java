package org.ufla.maratonadeprogramacao._2015.fase1.competicao;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class D {
	
	static int l;
	static int c;
	static String[][] qc;
	static int resultLinha[];
	static int resultColuna[];
	static Set<String> strVariables;
	static Map<String, Integer> variables;
	
	private static boolean setOneVariableLine() {
		String onlyVariable;
		for (int i = 0; i < l; i++) {
			onlyVariable = null;
			for (int j = 0; j < c; j++) {
				if (strVariables.contains(qc[i][j])) {
					if (onlyVariable == null || onlyVariable.equals(qc[i][j])) {
						onlyVariable = qc[i][j];	
					} else {
						break;
					}
				}
				if (j == c-1 && onlyVariable != null) {
					int contVariable = 0;
					int somaVariables = 0;
					for (int k = 0; k < c; k++) {
						if (qc[i][k].equals(onlyVariable)) {
							contVariable++;
						} else {
							somaVariables += variables.get(qc[i][k]);
						}
					}
					//System.out.println(onlyVariable+";"+contVariable);
					variables.put(onlyVariable, 
							(resultLinha[i]-somaVariables)/contVariable);
					strVariables.remove(onlyVariable);
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean setOneVariableCol() {
		String onlyVariable;
		for (int i = 0; i < c; i++) {
			onlyVariable = null;
			for (int j = 0; j < l; j++) {
				if (strVariables.contains(qc[j][i])) {
					if (onlyVariable == null || onlyVariable.equals(qc[j][i])) {
						onlyVariable = qc[j][i];	
					} else {
						break;
					}
				}
				if (j == l-1  && onlyVariable != null) {
					int contVariable = 0;
					int somaVariables = 0;
					for (int k = 0; k < l; k++) {
						if (qc[k][i].equals(onlyVariable)) {
							contVariable++;
						} else {
							somaVariables += variables.get(qc[k][i]);
						}
					}
					//System.out.println(onlyVariable+";"+contVariable);
					variables.put(onlyVariable, 
							(resultColuna[i]-somaVariables)/contVariable);
					strVariables.remove(onlyVariable);
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		l = in.nextInt();
		c = in.nextInt();
		qc = new String[l][c];
		resultLinha = new int[l];
		resultColuna = new int[c];
		strVariables = new HashSet<>();
		variables = new TreeMap<>();
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < c; j++) {
				qc[i][j] = in.next();
				strVariables.add(qc[i][j]);
			}
			resultLinha[i] = in.nextInt();
		}
		for (int i = 0; i < c; i++) {
			resultColuna[i] = in.nextInt();
		}
		in.close();
		while (!strVariables.isEmpty()) {
			if (!setOneVariableLine()) {
				setOneVariableCol();
			}
		}
		
		for (Map.Entry<String, Integer> entry : variables.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
	
}
