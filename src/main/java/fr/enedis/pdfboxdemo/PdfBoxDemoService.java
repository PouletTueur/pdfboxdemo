package fr.enedis.pdfboxdemo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.printing.PDFPageable;

import java.io.File;
import java.io.IOException;

public class PdfBoxDemoService {

    public void createTextPdf() throws IOException {


        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.beginText();
        contentStream.showText("TEST tagada tsoin tsoin");
        contentStream.endText();
        contentStream.close();

        document.save("testpdfbox.pdf");
        document.close();

    }

    public void editExistingPdfWithText() throws IOException {

        File file = new File("existingpdf.pdf");
        PDDocument document = PDDocument.load(file);
        PDPage page = document.getDocumentCatalog().getPages().get(0);

        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);
        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(100, 100);
        contentStream.showText("TEST tagada tsoin tsoin");
        contentStream.endText();
        contentStream.close();

        document.save("testpdfbox.pdf");
        document.close();

    }

}
