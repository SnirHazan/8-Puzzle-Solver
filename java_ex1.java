import java.io.IOException;
/** 
 * @author SnirHazan
 * @version 1.1
 */
public class java_ex1 {
	/**
	 * @param args
	 * @throws IOException
	 * Main - the main class.
	 */
	public static void main(String[] args) {
		//Read from "Input.txt"
		ReadAndWrite readerWriter = new ReadAndWrite();
		State initState = readerWriter.readFromFileAndInitParam();
		IAlgorithm algo = null;
		
		switch (readerWriter.getKindOfSearch()) {
		case 1:
			algo = new IdsAlgo();
			break;
		case 2:
			algo = new BfsAlgo();
			break;
		case 3:
			algo = new AstarAlgo();
			break;
		}
		try {
			Solution solution = algo.run(initState); //Running the Search on the initState.
			readerWriter.writeOutputFile(solution); //Write to "Output.txt".
		} catch (Exception e) {
			System.out.println("Unknown Action");
		}
	}
}
