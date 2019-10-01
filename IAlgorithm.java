/**
 * IAlgorithm - an abstract class.
 *
 */
public abstract class IAlgorithm {

	/**
	 * This function start the Search from the initState.
	 * Return - the solution of the search.
	 */
	abstract Solution run(State initState);
	/*
	 * This function get the initState of the search and return
	 * the goalState of the serach.
	 */
	protected State getGoalState(State initState){
		int sizeOfstrState = initState.getStrState().split("-").length;
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i < sizeOfstrState ; i++){
			sb.append(i).append("-");
		}
		sb.append("0");
		return new State(null,sb.toString(),'G',0);	
	}

}
