import java.util.ArrayList;
import java.util.List;
/**
 * InitSuccessors class.
 */
public class InitSuccessors {
	private int rowFreeLocation;
	private int colFreeLocation;

	public InitSuccessors(){
		this.rowFreeLocation = 0;
		this.colFreeLocation = 0;
	}

	/*
	 * This function gets a state and return a list of his successors.
	 */
	public List<State> createSuccessors(State s) {
		String currentStateStr = s.getStrState();
		List<State> mySuccessors = new ArrayList<State>();
		int[][] matrixState = Converter.convertStringToMatrix(s.getStrState());
		int size = matrixState[1].length;
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0 ; j < size ; j++) {
				if(matrixState[i][j] == 0){
					this.rowFreeLocation = i;
					this.colFreeLocation = j;
				}
			}
		}
		if((rowFreeLocation < size - 1)) {
			String newState = this.swapAndConvert(currentStateStr, size, 1, 0);	
			mySuccessors.add(new State(s,newState,'U',s.getDepth() + 1));
		}
		if((rowFreeLocation > 0)) {
			String newState = this.swapAndConvert(currentStateStr, size, -1, 0);	
			mySuccessors.add(new State(s,newState,'D',s.getDepth() + 1));
		}
		if((colFreeLocation < size - 1)) {
			String newState = this.swapAndConvert(currentStateStr, size, 0, 1);	
			mySuccessors.add(new State(s,newState,'L',s.getDepth() + 1));
		}
		if((colFreeLocation > 0)) {
			String newState = this.swapAndConvert(currentStateStr, size, 0, -1);
			mySuccessors.add(new State(s,newState,'R',s.getDepth() + 1));
		}
		return mySuccessors;
	}
	
	/*
	 * This function responsible to move the correct number to the free place
	 * in the puzzle.
	 */
	public String swapAndConvert(String currentState,int size, int x, int y) {
		String [] temp = currentState.split("-");
		temp[rowFreeLocation*size + colFreeLocation] = temp[(rowFreeLocation + x)*size + colFreeLocation + y];
		temp[(rowFreeLocation + x)*size + colFreeLocation + y] = "0";
		String newState = Converter.convertArrToString(temp);
		return newState;
	}

}
