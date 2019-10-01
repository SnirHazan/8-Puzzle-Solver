import java.util.LinkedList;
import java.util.Queue;
/**
 * BFS algorithm class.
 */
public class BfsAlgo extends IAlgorithm {
	private Queue<State> queue;
	private int numberOfNodesEvaluated;
	private State goalState;

	/*
	 * The constructor.
	 */
	public BfsAlgo() {
		this.queue = new LinkedList<>();
		this.numberOfNodesEvaluated = 0;
	}

	@Override
	public Solution run(State initState) {
		Solution sol = null;
		this.goalState = this.getGoalState(initState);
		this.queue.add(initState);
		while(!this.queue.isEmpty()) {
			State currentState = this.queue.poll();
			this.numberOfNodesEvaluated++;
			if(currentState.equals(goalState)) 
				return sol = new Solution(numberOfNodesEvaluated, 0, currentState);

			for (State state : currentState.createSuccessors()) 
				this.queue.add(state);

		}
		return sol;
	}
}
