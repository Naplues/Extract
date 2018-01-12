package trans.parse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;

public class Test {
	public static final String DEST = "czech.txt";
	public static final String SRC = "test.pdf";

	public static void main(String[] args) throws IOException {

		new Test().manipulatePdf();
	}

	public void manipulatePdf() throws IOException {
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
	}
	
	/*
	 public static final String SRC = "./src/test/resources/pdfs/nameddestinations.pdf";
	    public static final String EXPECTED_TEXT = "Country List\n" +
	            "Internet Movie Database";


	    public void manipulatePdf() throws IOException {
	        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC));
	        Rectangle rect = new Rectangle(36, 750, 523, 56);

	        FontFilter fontFilter = new FontFilter(rect);
	        FilteredEventListener listener = new FilteredEventListener();
	        LocationTextExtractionStrategy extractionStrategy = listener.attachEventListener(new LocationTextExtractionStrategy(), fontFilter);
	        new PdfCanvasProcessor(listener).processPageContent(pdfDoc.getFirstPage());

	        String actualText = extractionStrategy.getResultantText();
	        System.out.println(actualText);

	        pdfDoc.close();

	        Assert.assertEquals(EXPECTED_TEXT, actualText);
	    }


	    class FontFilter extends TextRegionEventFilter {
	        public FontFilter(Rectangle filterRect) {
	            super(filterRect);
	        }

	        @Override
	        public boolean accept(IEventData data, EventType type) {
	            if (type.equals(EventType.RENDER_TEXT)) {
	                TextRenderInfo renderInfo = (TextRenderInfo) data;

	                PdfFont font = renderInfo.getFont();
	                if (null != font) {
	                    String fontName = font.getFontProgram().getFontNames().getFontName();
	                    return fontName.endsWith("Bold") || fontName.endsWith("Oblique");
	                }
	            }
	            return false;
	        }
	    }
	*/
}