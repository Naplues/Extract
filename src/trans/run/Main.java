package trans.run;

import trans.parse.HTMLParser;
import trans.xml.Template;
import trans.xml.XMLHandler;

/**
 * 
 * @author gzq
 *
 */
public class Main {
	public static void main(String[] args) {

		Template template = new Template(); //

		// 解析PDF文件
		// List<String> lines = PDFParser.parsePDF("article.pdf", "article.txt");
		// HTML
		String url = "http://www.macrolinguistics.com/index.php?c=msg&id=663&";
		String html = HTMLParser.pickData(url);
		HTMLParser.analyzeHTMLByString(template, url, html);

		// 根据模板生成XML文档
		XMLHandler.generateXML(template, "article.xml");

	}

	
}
