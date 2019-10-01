/**
 * Converter Class - Responsible for all conversions during the search.
 */
public final class Converter {
	
	/*
	 * This function convert a string that represent a state to
	 * an appropriate matrix.
	 */
	public static int[][] convertStringToMatrix(String s) {
		String [] temp = s.split("-");
		int size = (int) Math.sqrt(temp.length);
		int[][] matrixState = new int[size][size];
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0 ; j < size ; j++) {
				matrixState[i][j] = Integer.parseInt(temp[i * size + j]);
			}
		}
		return matrixState;
	}
	
	/*
	 * This function convert an array of strings that represent a state to
	 * an appropriate string.
	 */
	public static String convertArrToString(String[]arr) {
		StringBuilder sb = new StringBuilder();
		for (String i : arr) {
			sb.append(i).append("-");
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
		
	}

}
