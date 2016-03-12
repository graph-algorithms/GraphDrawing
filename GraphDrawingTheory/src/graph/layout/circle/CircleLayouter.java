package graph.layout.circle;

import graph.drawing.Drawing;
import graph.elements.Edge;
import graph.elements.Graph;
import graph.elements.Vertex;
import graph.layout.AbstractLayouter;
import graph.layout.GraphLayoutProperties;
import graph.layout.PropertyEnums.CircleProperties;
import graph.math.CircleLayoutCalc;
import graph.ordering.circular.Circular;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;

public class CircleLayouter<V extends Vertex, E extends Edge<V>> extends AbstractLayouter<V, E>
{
	
	
	public CircleLayouter() {
		oneGraph = false;
	}

	@Override
	public Drawing<V, E> layout(Graph<V, E> graph,GraphLayoutProperties layoutProperties) {
		
		
		Circular<V,E> circular = new Circular<V,E>(graph);
		List<V> ordering = circular.circularOrdering();
		
		Integer distance= 0;
		if (layoutProperties.getProperty(CircleProperties.DISTANCE) != null)
			distance =  (Integer) layoutProperties.getProperty(CircleProperties.DISTANCE);
		
		graph.setVertices(ordering);

		CircleLayoutCalc<V> calc = new CircleLayoutCalc<V>();
		
		double radius = calc.calculateRadius(graph.getVertices(), distance);

		Map<V, Point2D> vertexPositions = calc.calculatePosition(ordering, radius, new Point2D.Double(0,0));
		
		Drawing<V, E> drawing = new Drawing<>();
		drawing.setVertexMappings(vertexPositions);
		
		drawing.positionEdges(graph.getEdges());
		
		return drawing;
	}

}
