import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
/**
 * ReadAndWrite class
 * This class take care on reading the input
 * from file and writing the output to another file.
 */
public class ReadAndWrite {

	private int kindOfSearch;
	private int sizePuzzle;
	private String strState;
	/*
	 * The constructor of the class.
	 */
	public ReadAndWrite(){
		
	}
	
	/*
	 * This function reads the input args from the "input" file.
	 * After reading the whole file - init the members:
	 * KindOfSearch, sizePuzzle and strState.
	 */
	public State readFromFileAndInitParam() {
		String name = "input.txt";
		List<String> temp = new ArrayList<String>() ;
		String line;
		try {
			FileReader fileReader = 
					new FileReader(name);

			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				temp.add(line);
			}   

			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + name + "'");
			return null;
		}
		catch(IOException ex) {
			System.out.println("Error reading file '" + name + "'");                  
		}
		this.kindOfSearch = Integer.parseInt(temp.get(0));
		this.sizePuzzle = Integer.parseInt(temp.get(1));
		this.strState = temp.get(2);
		return new State(null,this.strState,'I',0);
		
		
	}

	/*
	 * This function writes the output to "output.txt" file.
	 */
	public void writeOutputFile(Solution sol) throws IOException {

		File fout = new File("output.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fout);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		bw.write(sol.getPath() + " ");
		bw.write(sol.getNumberOfNodesEvaluated() + " ");
		bw.write(sol.getDepthOrCost() + " ");

		bw.close();

	}
	
	/*
	 * get StrState.
	 */
	public String getStrState() {
		return strState;
	}
	/*
	 * get kindOfSearch.
	 */
	public int getKindOfSearch() {
		return kindOfSearch;
	}
	/*
	 * get sizePuzzle.
	 */
	public int getSizePuzzle() {
		return sizePuzzle;
	}

}
