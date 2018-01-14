package trans.parse;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;

import trans.file.FileHandle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
	public static List<String> parsePDF(String filePath, String outPath) {

		try {
			PdfDocument doc = new PdfDocument(new PdfReader(filePath));
			FileOutputStream fos = new FileOutputStream(outPath);
			LocationTextExtractionStrategy strategy = new LocationTextExtractionStrategy();
			PdfCanvasProcessor parser = new PdfCanvasProcessor(strategy);

			for (int i = 0; i < doc.getNumberOfPages(); i++) {
				parser.processPageContent(doc.getPage(i + 1));
				fos.write(strategy.getResultantText().getBytes("UTF-8"));
				if(i+1 == 17) {
					System.out.println(strategy.getResultantText());
				}
			}

			System.out.println("对象数： " + doc.getNumberOfPdfObjects());

			fos.flush();
			fos.close();
			doc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return FileHandle.readFileToLines(outPath);

	}
	
	
	/**
	 * 解析参考文献
	 * @param list
	 */
	public static void parseReferences(List<String> list) {
		
	}
}