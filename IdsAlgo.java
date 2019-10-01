import java.util.List;
import java.util.Stack;
/**
 * IDS algorithm class.
 */
public class IdsAlgo extends IAlgorithm {
	private State goalState;
	private int numberOfNodesEvaluated;
	private Stack<State> stack;

	/*
	 * The constructor.
	 */
	public IdsAlgo() {
		this.stack = new Stack<>();
		this.numberOfNodesEvaluated = 0;
	}

	@Override
	public Solution run(State initState) {
		this.goalState = this.getGoalState(initState);
		int maxDepth = 0;
		while(true) {
			this.stack.push(initState);
			while(!this.stack.isEmpty()) {
				State currentState = this.stack.pop();
				this.numberOfNodesEvaluated++;
				if(currentState.equals(goalState))
					return new Solution(this.numberOfNodesEvaluated, maxDepth, currentState);
				if(currentState.getDepth() < maxDepth){
					List<State> successors = currentState.createSuccessors();
					int size = successors.size();
					for(int i = size-1 ; i >= 0 ; i--) {
						this.stack.push(successors.get(i));
					}
				}
			}
			this.numberOfNodesEvaluated = 0;
			maxDepth++;
		}
	}
}
