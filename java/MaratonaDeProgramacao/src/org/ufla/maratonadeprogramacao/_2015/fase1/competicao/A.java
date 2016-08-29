package org.ufla.maratonadeprogramacao._2015.fase1.competicao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A {
	
	
	
	class Edge {
		final Integer source;
		final Integer destination;
		
		public Edge(Integer source, Integer destination) {
			super();
			this.source = source;
			this.destination = destination;
		}
	
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int c = in.nextInt();
		final int v = in.nextInt();
		Map<Edge, Integer> edges = new HashMap<>();
//		Map<Integer, Set<Integer>> mapEdges = new HashMap<>();
//		for (int i = 0; i < v; i++) {
//			int source = in.nextInt();
//			int destination = in.nextInt();
//			edges.add(new Edge(source, destination, weigth))
//		}
	}

}
