package graph.traversal;

import graph.elements.Edge;
import graph.elements.EdgeDirection;
import graph.elements.Graph;
import graph.elements.Path;
import graph.elements.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Contains methods which implement certain graph traversal algorithms
 * @author xxx
 *
 * @param <V>
 * @param <E>
 */
public class GraphTraversal<V extends Vertex,E extends Edge<V>> {

	private Graph<V,E> graph;

	public GraphTraversal(Graph<V,E> graph){
		this.graph = graph;
	}


	/**
	 * Depth-First Search
	 * The depth-first-search algorithm is similar to the standard algorithm for traversing binary trees; 
	 * it first fully explores one subtree before returning to the current node and then exploring the other subtree.
	 * Another way to think of depth-first-search is by saying that it is similar to breadth-first search except that it uses a stack instead of a queue.
	 * @param first
	 * @param target
	 * @return
	 */
	public List<Path<V, E>> findAllPathsDFS(V first, V target){
		List<Path<V,E>> paths = new ArrayList<Path<V,E>>();
		findAllPathsDFS(new ArrayList<E>(), new ArrayList<EdgeDirection>(),  paths, first, first, target, null);
		return paths;
	}
	


	public List<Path<V, E>> findAllPathsDFS(V first, V target, List<V> excluding){
		List<Path<V,E>> paths = new ArrayList<Path<V,E>>();
		findAllPathsDFS(new ArrayList<E>(), new ArrayList<EdgeDirection>(),  paths, first, first, target, excluding);
		return paths;
	}
	



	private void findAllPathsDFS(List<E> visited, List<EdgeDirection> directions, List<Path<V, E>> paths, 
			V currentVertex, V start, V end, List<V> excluding) {        

		if (currentVertex.equals(end)) { 
			if (!(currentVertex.equals(start) && visited.size() == 0)){
				paths.add(new Path<V, E>(visited, directions));
				return;
			}
		}
		LinkedList<E> edges;
		if (graph.isDirected())
			edges = graph.outEdges(currentVertex);
		else
			edges = graph.allEdges(currentVertex);

		for (E e : edges) {
			if (visited.contains(e)) {
				continue;
			}
			if (excluding != null){
				if (excluding.contains(e.getOrigin()) || excluding.contains(e.getDestination()))
					continue;
			}
			List<E> temp = new ArrayList<E>();
			List<EdgeDirection> directionsTemp = new ArrayList<EdgeDirection>();
			temp.addAll(visited);
			temp.add(e);
			directionsTemp.addAll(directions);
			V nextVert;
			if (currentVertex == e.getOrigin()){
				nextVert = e.getDestination();
				directionsTemp.add(EdgeDirection.TO_DESTINATION);
			}
			else{
				nextVert = e.getOrigin();
				directionsTemp.add(EdgeDirection.TO_ORIGIN);
			}

			findAllPathsDFS(temp, directionsTemp, paths, nextVert, start, end, excluding);
		}
	}


	public List<Path<V,E>> nonrecursiveDFS(V start, V end){
		List<Path<V,E>> ret = new ArrayList<Path<V,E>>();

		List<E> visited;
		List<EdgeDirection> directions = new ArrayList<EdgeDirection>();
		Stack<E> stack = new Stack<E>();
		Stack<EdgeDirection> directionStack = new Stack<EdgeDirection>();
		Stack<List<E>> visitedStack = new Stack<List<E>>();
		Stack<List<EdgeDirection>> directionsStack = new Stack<List<EdgeDirection>>();


		LinkedList<E> edges;
		if (graph.isDirected())
			edges = graph.outEdges(start);
		else
			edges = graph.allEdges(start);

		for (E e : edges){
			EdgeDirection direction = e.getOrigin() == start ? EdgeDirection.TO_DESTINATION : EdgeDirection.TO_ORIGIN;
			stack.add(0, e);
			directionStack.add(0, direction);
			visitedStack.add(0, new ArrayList<E>());
			directionsStack.add(0, new ArrayList<EdgeDirection>());
		}



		E current;
		EdgeDirection currentDirection;
		while (!stack.empty()){

			current = stack.pop();
			currentDirection = directionStack.pop();
			visited = visitedStack.pop();
			directions = directionsStack.pop();
			
			
			if (visited.contains(current)){
				continue;
			}

			List<E> newVisited = new ArrayList<E>(visited);
			List<EdgeDirection> newDirections = new ArrayList<EdgeDirection>(directions);
			
			newVisited.add(current);
			newDirections.add(currentDirection);
			
		
			
			V nextVertex = currentDirection == EdgeDirection.TO_DESTINATION ? current.getDestination() : current.getOrigin();
			if (nextVertex == end){
				ret.add(new Path<V,E>(newVisited, newDirections));
			}

			if (graph.isDirected())
				edges = graph.outEdges(nextVertex);
			else
				edges = graph.allEdges(nextVertex);

			for (E e : edges){
				if (!visited.contains(e)){
					EdgeDirection direction = e.getOrigin() == nextVertex ? EdgeDirection.TO_DESTINATION : EdgeDirection.TO_ORIGIN;
					stack.add(0,e);
					directionStack.add(0,direction);
					visitedStack.add(0,newVisited);
					directionsStack.add(0,newDirections);
				}
			}

		}

		return ret;

	}

	public Path<V,E> getShortestPath(V source, V target){
		Path<V,E> ret = null;
		List<Path<V, E>> paths = new ArrayList<Path<V, E>>();
		paths = findAllPathsDFS(source, target);
		for (Path<V,E> path : paths)
			if (ret == null || path.size() < ret.size())
				ret = path;
		return ret;
	}

	public List<Path<V,E>> findAllCycles(){
		List<Path<V,E>> ret = new ArrayList<Path<V,E>>();
		for (V v : graph.getVertices()){
			ret.addAll(nonrecursiveDFS(v, v));
		}
		return ret;
	}

	
	public DFSTree<V,E> formDFSTree(V root){
		DFSTree<V, E> tree = new DFSTree<V,E>(root);
		formDFSTree(root, null,  tree, new ArrayList<V>(), new ArrayList<E>(), 1);
		tree.formBackEdges(graph.getEdges());
		return tree;
	}
	
	private void formDFSTree(V current, E currentEdge, DFSTree<V,E> tree, List<V> covered, List<E> visited, int index){

		if (covered.size() == graph.getVertices().size())
			return;
		if (covered.contains(current))
			return;
			
		covered.add(current);
		
		System.out.println("Stavlja " + current + " " + index);
		
		tree.getVerticesWithIndexes().put(current, index);
		
		if (currentEdge != null){
			System.out.println("Stavlja " + currentEdge);
			tree.getTreeEdges().add(currentEdge);
		}
		
		LinkedList<E> edges;
		if (graph.isDirected())
			edges = graph.outEdges(current);
		else
			edges = graph.allEdges(current);

		for (E e : edges) {
			if (visited.contains(e)) {
				continue;
			}
			
			List<E> temp = new ArrayList<E>();
			temp.addAll(visited);
			temp.add(e);
			
			
			V nextVert;
			if (current == e.getOrigin()){
				nextVert = e.getDestination();
			}
			else{
				nextVert = e.getOrigin();
			}

			formDFSTree(nextVert, e, tree, covered, temp, ++index);
		}
	}









}