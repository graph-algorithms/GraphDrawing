package graph.layout;

public interface PropertyEnums {
	
	
	//TODO ubaciti ovde tip
	//pa onda adjust for gravity za ovaj properties
	//da moze da bude check box
	//
	
	public enum KamadaKawaiProperties implements PropertyEnums{
		DISCONNECTED_DISTANCE_MULTIPLIER("Disconnected distance multiplier", false, Double.class), LENGTH_FACTOR ("Length factor", false, Double.class),
		MAXIMUM_ITERATIONS("Maximum itterations", false, Integer.class);
		
		private String name;
		private boolean hidden;
		private Class<?> type;
		
		KamadaKawaiProperties(String name, boolean hidden, Class<?> type){
			this.name = name;
			this.hidden = hidden;
			this.type = type;
		}
		
		public String getName(){
			return name;
		}
		
		public boolean isHidden(){
			return hidden;
		}
		
		public Class<?> getType(){
			return type;
		}
		
	}
	
	public enum SymmetricProperties implements PropertyEnums{
		DISTANCE("Distance", false, Double.class), PERMUTATION("Permutation", false, String.class), CENTER("Center", true, String.class);
		
		private String name;
		private boolean hidden;
		private Class<?> type;
		
		SymmetricProperties(String name, boolean hidden, Class<?> type){
			this.name = name;
			this.hidden = hidden;
			this.type = type;
		}
		
		public String getName(){
			return name;
		}
		
		public boolean isHidden(){
			return hidden;
		}
		
		public Class<?> getType(){
			return type;
		}
	}
	
	public enum TutteProperties implements PropertyEnums{
		DISTANCE("Distance", false, Double.class), FACE("Face", false, String.class),
		PERMUTATION("Permutation", false, String.class), CENTER("Center", true, String.class);
		
		private String name;
		private boolean hidden;
		private Class<?> type;
		
		TutteProperties(String name, boolean hidden, Class<?> type){
			this.name = name;
			this.hidden = hidden;
			this.type = type;
		}
		
		public String getName(){
			return name;
		}
		
		public boolean isHidden(){
			return hidden;
		}
		
		public Class<?> getType(){
			return type;
		}
	}
	

	
	public enum BoxProperties implements PropertyEnums{
		COLUMNS("Number of columns", false, Integer.class);
		
		private String name;
		private boolean hidden;
		private Class<?> type;
		
		BoxProperties (String name, boolean hidden, Class<?> type){
			this.name = name;
			this.hidden = hidden;
			this.type = type;
		}
		
		public String getName(){
			return name;
		}
		
		public boolean isHidden(){
			return hidden;
		}
		
		public Class<?> getType(){
			return type;
		}
	}
	
	public enum CircleProperties implements PropertyEnums{
		DISTANCE("Distance", false, Integer.class);
		
		private String name;
		private boolean hidden;
		private Class<?> type;
		
		CircleProperties (String name, boolean hidden, Class<?> type){
			this.name = name;
			this.hidden = hidden;
			this.type = type;
		}
		
		public String getName(){
			return name;
		}
		
		public boolean isHidden(){
			return hidden;
		}
		
		public Class<?> getType(){
			return type;
		}
	}
	
	
	public enum FruchtermanReingoldProperties implements PropertyEnums{
		ATTRACTION_MULTIPLIER("Attraction multiplier", false, Double.class), REPULSION_MULTIPLIER("Repulsion multiplier", false, Double.class),
		MAXIMUM_ITERATIONS("Maximum iterations", false, Integer.class);
		
		private String name;
		private boolean hidden;
		private Class<?> type;
		
		FruchtermanReingoldProperties (String name, boolean hidden, Class<?> type){
			this.name = name;
			this.hidden = hidden;
			this.type = type;
		}
		
		public String getName(){
			return name;
		}
		
		public boolean isHidden(){
			return hidden;
		}
		
		public Class<?> getType(){
			return type;
		}
	}
	
	public enum SpringProperties implements PropertyEnums{
		STRETCH("Stretch", false, Double.class), REPULSION_RANGE("Repulsion range", false, Integer.class),
		FORCE_MULTIPLIER("Force multiplier", false, Double.class);
		
		private String name;
		private boolean hidden;
		private Class<?> type;
		
		SpringProperties (String name, boolean hidden, Class<?> type){
			this.name = name;
			this.hidden = hidden;
			this.type = type;
		}
		
		public String getName(){
			return name;
		}
		
		public boolean isHidden(){
			return hidden;
		}
		
		public Class<?> getType(){
			return type;
		}
	}
	
	
	public enum RadialTreeProperties implements PropertyEnums{
		X_DISTANCE("X distance", false, Integer.class), Y_DISTANCE("Y distance", false, Integer.class);
		
		private String name;
		private boolean hidden;
		private Class<?> type;
		
		RadialTreeProperties (String name, boolean hidden, Class<?> type){
			this.name = name;
			this.hidden = hidden;
			this.type = type;
		}
		
		public String getName(){
			return name;
		}
		
		public boolean isHidden(){
			return hidden;
		}
		
		public Class<?> getType(){
			return type;
		}
	}
	
	public enum TreeProperties implements PropertyEnums{
		X_DISTANCE("X distance", false, Integer.class), Y_DISTANCE("Y distance", false, Integer.class);
		
		
		private String name;
		private boolean hidden;
		private Class<?> type;
		
		TreeProperties (String name, boolean hidden, Class<?> type){
			this.name = name;
			this.hidden = hidden;
			this.type = type;
		}
		
		public String getName(){
			return name;
		}
		
		public boolean isHidden(){
			return hidden;
		}
		
		public Class<?> getType(){
			return type;
		}
	}
	
	public enum CompactTreeProperties implements PropertyEnums{
		HORIZONTAL("Horizontal", false, Boolean.class), INVERT("Invert", false, Boolean.class),
		RESIZE_PARENTS("Resize parents", false, Boolean.class), LEVEL_DISTANCE("Level distance", false, Integer.class),
		NODE_DISTANCE("Node distance", false, Integer.class);
		
		
		private String name;
		private boolean hidden;
		private Class<?> type;
		
		CompactTreeProperties (String name, boolean hidden, Class<?> type){
			this.name = name;
			this.hidden = hidden;
			this.type = type;
		}
		
		public String getName(){
			return name;
		}
		
		public boolean isHidden(){
			return hidden;
		}
		
		public Class<?> getType(){
			return type;
		}
	}
	
	public enum  FastOrganicProperties implements PropertyEnums{
		FORCE_CONSTANT("Force constant", false, Double.class), MINIMAL_DISTANCE_LIMIT("Minimal distance limit", false, Double.class),
		INITIAL_TEMP("Initial temperature", false, Double.class), MAX_ITERATIONS("Iterations ", false, Double.class);
		
		private String name;
		private boolean hidden;
		private Class<?> type;
		
		FastOrganicProperties (String name, boolean hidden, Class<?> type){
			this.name = name;
			this.hidden = hidden;
			this.type = type;
		}
		
		public String getName(){
			return name;
		}
		
		public boolean isHidden(){
			return hidden;
		}
		
		public Class<?> getType(){
			return type;
		}
	}
	
	public enum  OrganicProperties implements PropertyEnums{
		
		IS_OPTIMIZE_EDGE_CORSSING("Should optimize edge crossing", false, Boolean.class),
		EDGE_CROSSING_FACTOR("Edge crossing facotr", false, Double.class),
		IS_OPTIMIZE_EDGE_DISTANCE("Should optimize edge distance", false, Boolean.class),
		EDGE_DISTANCE_FACTOR("Edge distance factor", false, Double.class),
		IS_FINE_TUNING("Should fine tune", false, Boolean.class),
		FINE_TUNING_RADIUS("Fine tuning radius", false, Double.class),
		IS_OPTIMIZE_BORDER_LINE("Should optimize border line", false, Boolean.class),
		BORDER_LINE_FACTOR("Border line factor", false, Double.class),
		AVERAGE_NODE_AREA("Average node area", false, Double.class);
		
		private String name;
		private boolean hidden;
		private Class<?> type;
		
		OrganicProperties (String name, boolean hidden, Class<?> type){
			this.name = name;
			this.hidden = hidden;
			this.type = type;
		}
		
		public String getName(){
			return name;
		}
		
		public boolean isHidden(){
			return hidden;
		}
		
		public Class<?> getType(){
			return type;
		}
	}
	

}
