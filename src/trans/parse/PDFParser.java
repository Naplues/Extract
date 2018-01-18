package trans.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解析pdf文件
 * 
 * @author gzq
 *
 */
public class PDFParser {

	/**
	 * 提取PDF文件内容
	 * 
	 * @param filePath
	 */
	/*
	 * public static String parsePDF(String filePath) { String string = null; try {
	 * PdfDocument doc = new PdfDocument(new PdfReader(filePath));
	 * LocationTextExtractionStrategy strategy = new
	 * LocationTextExtractionStrategy(); PdfCanvasProcessor parser = new
	 * PdfCanvasProcessor(strategy); parser.processPageContent(doc.getFirstPage());
	 * string = strategy.getResultantText(); doc.close(); } catch (IOException e) {
	 * e.printStackTrace(); } return string; }
	 */
	/**
	 * 正则表达式匹配:寻找字符串中的邮箱
	 * 
	 * @param str
	 * @return
	 */
	public static String findEmailNo(String str) {
		str = str.replace(" ", "");// 去掉空格
		Pattern p = Pattern.compile("\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}"); // 使用正则表达式匹配
		Matcher m = p.matcher(str);
		while (m.find()) {
			System.out.println(m.group());
			return m.group();
		}
		return "";
	}
}