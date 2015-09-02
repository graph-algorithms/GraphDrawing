package graph.properties;

import graph.elements.Edge;
import graph.elements.Graph;
import graph.elements.Vertex;
import graph.properties.components.BiconnectedComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Finds all biconnected components of a graph
 * efficiently, by using the depth-first search 
 *
 * @param <V>
 * @param <E>
 */
public class Biconnected<V extends Vertex, E extends Edge<V>> {

	private boolean[] visited;
	private int[] parent, d, low;
	private int count;
	private Stack<E> stack;
	private Graph<V,E> graph;
	private List<V> vertices;


	public Biconnected(Graph<V,E> graph){
		this.graph = graph;
	}

	public List<BiconnectedComponent<V,E>> findBiconnectedComponents(){

		//initialization
		vertices = graph.getVertices();
		int n = vertices.size();
		visited = new boolean[n];
		parent = new int[n];
		d = new int[n];
		low = new int[n];
		stack = new Stack<E>();
		count = 0;

		List<BiconnectedComponent<V,E>> components = new ArrayList<BiconnectedComponent<V,E>>();
		vertices = graph.getVertices();

		for (V u : vertices)
			if (!visited[vertices.indexOf(u)])
				dfsVisit(u, components);

		return components;
	}

	private void dfsVisit(V u, List<BiconnectedComponent<V,E>> components){
		int uIndex = vertices.indexOf(u);
		visited[uIndex] = true;
		count ++;
		d[uIndex] = count;
		low[uIndex] = d[uIndex];
		for (E e : graph.adjacentEdges(u)){
			V v = e.getOrigin() == u ? e.getDestination() : e.getOrigin();
			int vIndex = vertices.indexOf(v);

			if (!visited[vIndex]){
				System.out.println("pushing " + e);
				stack.push(e);
				parent[vIndex] = uIndex;
				dfsVisit(v, components);
				if (low[vIndex] >= d[uIndex])
					components.add(formComponent(e));
				low[uIndex] = Math.min(low[uIndex],low[vIndex]);
			}
			else if (parent[uIndex] != vIndex && d[vIndex] < d[uIndex]){
				//(u,v) is a back edge from u to its ancestor
				stack.push(e);
				low[uIndex] = Math.min(low[uIndex], d[vIndex]);
			}
		}
	}

	private BiconnectedComponent<V,E> formComponent(E e){
		List<E> edges = new ArrayList<E>();
		E pop = null;
		do {
			pop = stack.pop();
			edges.add(pop);
		}
		while (pop != e);

		return new BiconnectedComponent<V, E>(edges);
	}


}
