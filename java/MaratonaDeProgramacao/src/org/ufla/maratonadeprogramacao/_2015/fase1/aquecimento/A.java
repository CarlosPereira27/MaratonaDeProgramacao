package org.ufla.maratonadeprogramacao._2015.fase1.aquecimento;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class A {
	
	public static void printMaps(Map<Integer, Set<Integer>> map) {
		for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int inAux, inAux2;
		Map<Integer, Set<Integer>> equalNodes = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (equalNodes.containsKey(inAux = in.nextInt())) {
				Set<Integer> set = equalNodes.get(inAux);
				set.add(i+1);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(i+1);
				equalNodes.put(inAux, set);
			}
		}
		Map<Integer, Set<Integer>> vertex = new HashMap<>();
		for (int i = 0; i < n-1; i++) {
			if (vertex.containsKey(inAux = in.nextInt())) {
				Set<Integer> set = vertex.get(inAux);
				set.add(inAux2 = in.nextInt());
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(inAux2 = in.nextInt());
				vertex.put(inAux, set);
			}
			
			if (vertex.containsKey(inAux2)) {
				Set<Integer> set = vertex.get(inAux2);
				set.add(inAux);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(inAux);
				vertex.put(inAux2, set);
				
			}
		}
		in.close();
		int pontos = 0;
		int caminhoAtual;
		for (Map.Entry<Integer, Set<Integer>> entry : equalNodes.entrySet()) {
			caminhoAtual = 0;
			Integer[] valores = new Integer[2];
			entry.getValue().toArray(valores);
			//Busca em largura
			Set<Integer> visited = new HashSet<>();
			Set<Integer> lastVisited = new HashSet<>();
			Set<Integer> actualVisited = new HashSet<>();
			lastVisited.add(valores[0]);
			visited.add(valores[0]);
			while (!visited.contains(valores[1])) {
				actualVisited = new HashSet<>();
				for (Integer lastI : lastVisited) {
					for (Integer i : vertex.get(lastI)) {
						if (!visited.contains(i)) {
							actualVisited.add(i);
						}
					}
				}
				lastVisited = actualVisited;
				visited.addAll(actualVisited);
				caminhoAtual++;
			}
			pontos += caminhoAtual;
		}
		System.out.println(pontos);
	}

}
