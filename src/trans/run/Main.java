package trans.run;

import java.util.List;

import trans.parse.PDFParser;

/**
 * 
 * @author gzq
 *
 */
public class Main {
	public static void main(String[] args) {
		// 解析PDF文件
		List<String> lines = PDFParser.parsePDF("article.pdf", "article.txt");
		for (String s : lines) {
			if (s.trim().equals("References")) {
				System.out.println(s);
			}
		}
		// Template template=new Template();
		// 根据模板生成XML文档
		// XMLHandler.generateXML(template, "article.xml");
	}
}
