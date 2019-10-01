import java.util.PriorityQueue;
/**
 * A* algorithm class.
 */
public class AstarAlgo extends IAlgorithm {
	private State goalState;
	private PriorityQueue<State> queue;
	private int numberOfNodesEvaluated;
	
	/*
	 * The constructor.
	 */
    public AstarAlgo() {
		this.queue = new PriorityQueue<>(new StateComparator());
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
				return sol = new Solution(this.numberOfNodesEvaluated, currentState.getDepth(), currentState);
			
			for (State state : currentState.createSuccessors())
				this.queue.add(state);
		}
		return sol;

	}
}
