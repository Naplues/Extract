package trans.parse;
/*
 
    This file is part of the iText (R) project.
    Copyright (c) 1998-2016 iText Group NV
 
*/

/**
 * Example written by Bruno Lowagie in answer to the following question:
 * http://stackoverflow.com/questions/30286601/extracting-an-embedded-object-from-a-pdf
 */

import com.itextpdf.kernel.PdfException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfObject;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PDFParser {

	public static final String DEST = "a.txt";

	public static void manipulatePdf(String filePath) {
		PdfDocument pdfDoc;
		try {
			pdfDoc = new PdfDocument(new PdfReader(filePath));

			PdfObject obj;
			List<Integer> streamLengths = new ArrayList<>();
			for (int i = 1; i <= pdfDoc.getNumberOfPdfObjects(); i++) {
				obj = pdfDoc.getPdfObject(i);
				if (obj != null && obj.isStream()) {
					byte[] b;
					try {
						b = ((PdfStream) obj).getBytes();
					} catch (PdfException exc) {
						b = ((PdfStream) obj).getBytes(false);
					}
					FileOutputStream fos = new FileOutputStream(String.format(DEST, i));
					fos.write(b);
					streamLengths.add(b.length);
					fos.close();
				}
			}

			System.out.println("页数: " + pdfDoc.getNumberOfPages());
			System.out.println("对象数： " + pdfDoc.getNumberOfPdfObjects());
			System.out.println(pdfDoc.getCatalog());
			System.out.println(pdfDoc.getDocumentInfo().getTitle());
			System.out.println(pdfDoc.getFirstPage());
			System.out.println(pdfDoc.getPdfObject(20));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}