package trans.run;

import trans.parse.PDFParser;
import trans.xml.Template;
import trans.xml.XMLHandler;

/**
 * 
 * @author gzq
 *
 */
public class Main {

	public static void main(String[] args) {
		// 解析PDF文件
		Template template = PDFParser.parsePDF("test.pdf", "test.txt");

		// 根据模板生成XML文档
		XMLHandler.generateXML(template, "article.xml");
	}
}
