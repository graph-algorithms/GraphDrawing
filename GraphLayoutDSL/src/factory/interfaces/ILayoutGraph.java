package factory.interfaces;

import java.util.List;
import java.util.Map;

public interface ILayoutGraph {

	public String getGraph();
	public String getType();
	public String getStyle();
	public List<Map<String, String>> getAestheticCriteria();
	public Map<String, String> getAlgorithm();
}
