import java.util.List;

/**
 * State class.
 * This class save the data of the state.
 *
 */
public class State {
	private InitSuccessors init;
	private String strState;
	private State fatherState;
	private char operator;
	private int cost;
	private int depth;
	
	/*
	 * The constructor of the class.
	 */
	public State(State father,String strS, char op, int d){
		this.init = new InitSuccessors();
		this.fatherState = father;
		this.strState = strS;
		this.operator = op;
		this.depth = d;
		calculateCostByManhattanDistance();
	}
	/*
	 * This function check if otherState is equal to this state
	 * by comparing the strings of the states.
	 */
	public boolean equals(State otherState) {
		if(this.strState.equals(otherState.getStrState())){
			return true;
		}
		return false; 
	}
	/*
	 * Get the StrState - the string that describe the state.
	 */
	public String getStrState() {
		return strState;
	}
	
	/*
	 * Get the fatherState - the "father" of the state.
	 */
	public State getFatherState() {
		return fatherState;
	}
	
	/*
	 * Get the operator - the operator of the state:{U,D,L,R}.
	 */
	public char getOperator() {
		return operator;
	}
	
	/*
	 * Get the cost - the cost+depth of the state.
	 */
	public int getCost() {
		return cost + depth;
	}
	
	/*
	 * Get the depth - the depth of the state.
	 */
	public int getDepth() {
		return depth;
	}
	
	/*
	 * This function calculate the "Manhattan Distance" of the state.
	 * This is the heuristic function of A* Search.
	 */
	private void calculateCostByManhattanDistance() {
		int[][] matrixState = Converter.convertStringToMatrix(this.strState);
		int size = matrixState[1].length;
		int fixRowLocation = 0;
		int fixColLocation = 0;
		for(int k = 1 ; k < Math.pow(size,2) ; k++){
			for(int i = 0 ; i < size ;i++) {
				for(int j = 0 ; j < size ;j++) {
					if(matrixState[i][j] == k) {
						this.cost = this.cost + Math.abs(j - fixColLocation) + Math.abs(i - fixRowLocation);
						fixColLocation++;
						if(fixColLocation == size) {
							fixColLocation = 0;
							fixRowLocation++;
						}
					}
				}				
			}
		}
	}
	/*
	 * This function uses the InitSuccessors to create the successors of this state.
	 * return a List of state's successors.
	 */
	public List<State> createSuccessors() {
		return this.init.createSuccessors(this);
	}
}
