import java.util.Comparator;
/**
 * StateComparator - used by the PriorityQueue of A* search.
 */
public class StateComparator implements Comparator<State> {

	/*
	 * This function responsible on comparing between two
	 * States by their cost.
	 */
	@Override
	public int compare(State o1, State o2) {
		if(o1.getCost() > o2.getCost())
			return 1;
		else if(o1.getCost() < o2.getCost())
			return -1;
		return 0;
	}

}
