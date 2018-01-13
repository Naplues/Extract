package trans.parse;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;

import trans.xml.Template;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 解析pdf文件
 * 
 * @author gzq
 *
 */
public class PDFParser {

	/**
	 * 操控pdf文件
	 * 
	 * @param filePath
	 */
	public static Template parsePDF(String filePath, String outPath) {
		Template template = new Template();
		try {
			PdfDocument doc = new PdfDocument(new PdfReader(filePath));
			FileOutputStream fos = new FileOutputStream(outPath);
			LocationTextExtractionStrategy strategy = new LocationTextExtractionStrategy();
			PdfCanvasProcessor parser = new PdfCanvasProcessor(strategy);

			for (int i = 0; i < doc.getNumberOfPages(); i++) {
				parser.processPageContent(doc.getPage(i + 1));
				fos.write(strategy.getResultantText().getBytes("UTF-8"));
			}

			System.out.println("对象数： " + doc.getNumberOfPdfObjects());
			
			template.setLastPage(doc.getNumberOfPages() + "");

			fos.flush();
			fos.close();
			doc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return template;
	}

}