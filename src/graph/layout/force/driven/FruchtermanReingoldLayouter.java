package graph.layout.force.driven;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import graph.elements.Edge;
import graph.elements.Graph;
import graph.elements.Vertex;

public class FruchtermanReingoldLayouter <V extends Vertex, E extends Edge<V>> extends AbstractForceDrivenLayouter<V,E> {


	public FruchtermanReingoldLayouter(Graph<V, E> graph) {
		super(graph);
	}

	@Override
	protected void initLayouter() {
		layouter = new FRLayout<V, E>(jungGraph);
		((FRLayout<V,E>)layouter).setRepulsionMultiplier(3);
		
	}

}