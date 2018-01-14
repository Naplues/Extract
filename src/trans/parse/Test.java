package trans.parse;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;

public class Test {
	public static final String DEST = "test.txt";
	public static final String SRC = "article.pdf";

	public static void manipulatePdf() {
		try {
			PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC));
			FileOutputStream fos = new FileOutputStream(DEST);

			LocationTextExtractionStrategy strategy = new LocationTextExtractionStrategy();

			PdfCanvasProcessor parser = new PdfCanvasProcessor(strategy);
			parser.processPageContent(pdfDoc.getLastPage());
			byte[] array = strategy.getResultantText().getBytes("UTF-8");
			fos.write(array);

			fos.flush();
			fos.close();
			pdfDoc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Test.manipulatePdf();
	}
}