package trans.run;

import trans.parse.PDFParser;

/**
 * 
 * @author gzq
 *
 */
public class Main {
	
	public static void main(String[] args) {
		PDFParser.manipulatePdf("test.pdf", "test.txt");
		
	}
}
