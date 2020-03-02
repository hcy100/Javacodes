import java.util.ArrayList;

public class CSVParser {	
	/**
	 * Method used to spit each line into values
	 * 
	 * @param line
	 * @return the array of values
	 */
	public static String[] lineParser(String line) {
		/** characters used as delimiters */
		char[] separators = {',', '\t'};
		
		/** when the delimiters appears in the text the value will be between two double quotas */
		char specialChars = '"';
		
		String[] result = null;
		
		/** Using ArrayList as the number of values are unknown at this stage */
		ArrayList<String> parsedLine = new ArrayList<String>();
		
		int len = line.length();
		int i = 0;
		
		/** iterate through all the chars in the line */
		while (i < len) {
			int nextSep = len;
			/** Get the next separator */
			for (int j = 0; j < separators.length; ++j) {
				int temp = line.indexOf(separators[j], i);
				if ((temp == -1) || (temp >= nextSep))
					continue;
				nextSep = temp;
			}
			
			/** Place the special separator at the end of the string */
			int nextSpecialSep = len;
			
			/** Check if there is any special separator */
			int temp = line.indexOf(specialChars, i);
			if ((temp == -1) || (temp >= nextSpecialSep))
				nextSpecialSep = len;
			else
				nextSpecialSep = temp;
			
			/** if we are at the special separator get the text until the next special separator */
			if (nextSpecialSep == i) {
				char c = line.charAt(i);
				/** check if there is any double quote chars in the text */
				int d = line.indexOf((c + "") + (c + ""), i + 1);
				
				/** if there are two double quota chars jump to the next one - are part of the text */
				int end = line.indexOf(c, d >= 0 ? d + 3 : i + 1);
				if (end == -1) {
					end = len;
				}
				String toAdd = line.substring(i + 1, end);
				/** Replace two double quota with one double quota */
				toAdd = toAdd.replaceAll((c + "") + (c + ""), c + "");
				
				parsedLine.add(toAdd);
				i = end + 1;
			}
			/** if we are at a normal separator, ignore the separator and jump to the next char */
			else if (nextSep == i) {
				++i;
			}
			/** Copy the value in the result string */
			else {
				parsedLine.add(line.substring(i, nextSep));
				i = nextSep;
			}
		}
		
		/** Convert the result to String[] */
		result = parsedLine.toArray(new String[parsedLine.size()]);
		return result;
	}
	
	
	/**
	 * main method for testing
	 * 
	 * @param args
	 */
	public static void main(String[] args)	{
		//String data="41247,96109,STANDARD,DOYLE,CA,PRIMARY,39.94,-120.06,-0.38,-0.66,0.64,NA,US,\"Doyle, CA\",NA-US-CA-DOYLE,FALSE,345,622,10601655,17044.5,";
		String data="\"41247\",96109,STANDARD,DOYLE,CA,PRIMARY,39.94,-120.06,-0.38,-0.66,0.64,NA,US,\"Doyle, CA\",NA-US-CA-DOYLE,FALSE,345,622,10601655,17044.5,";
		
		String[] tokens=lineParser(data);
		 
		for (int i = 0; i < tokens.length; i++) {
		   System.out.println("tokens["+i +"]"+ tokens[i]);
		}  	
	}
}
