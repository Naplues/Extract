package trans.run;

import trans.xml.Template;
import trans.xml.XMLHandler;

//import trans.parse.PDFParser;

/**
 * 
 * @author gzq
 *
 */
public class Main {

	public static void main(String[] args) {
		// PDFParser.manipulatePdf("test.pdf", "test.txt");
		
		XMLHandler.generateXML(new Template(), "article.xml"); // 生成XML文档
		XMLHandler.printXML("article.xml"); // 输出XMl内容
	}
}
