/**
 * Solution class.
 *
 */
public class Solution {
	private String path;
	private State goal;
	private int numberOfNodesEvaluated;
	private int depthOrCost;
	/*
	 * The constructor
	 */
    public Solution(int numberOfEvaluated, int cost, State goalState) {
    	this.goal = goalState;
		this.numberOfNodesEvaluated = numberOfEvaluated;
		this.depthOrCost = cost;
		createThePath();
	}
	
    /*
     * This function create the path from the goalState to the initState,
     * and revrese it.(From Goal--->Init to Init--->Goal)
     */
	private void createThePath() {
		StringBuilder sb = new StringBuilder();
		State current = this.goal;
		while(current != null){
			sb.append(current.getOperator());
			current = current.getFatherState();
		}
		sb.setLength(sb.length() - 1);
		sb.reverse();
		this.path = sb.toString();
		
	}

	/*
	 * Get depth/cost
	 */
	public int getDepthOrCost() {
		return depthOrCost;
	}
	
	/*
	 * Get number of nodes that evaluated through the seraching.
	 */
	public int getNumberOfNodesEvaluated() {
		return numberOfNodesEvaluated;
	}
	
	/*
	 * Get the path from the initState to the goalState.
	 */
	public String getPath() {
		return path;
	}
}
