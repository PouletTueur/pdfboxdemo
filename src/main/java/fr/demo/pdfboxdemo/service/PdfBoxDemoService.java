package fr.demo.pdfboxdemo.service;

import fr.demo.pdfboxdemo.pojo.Coordonnee;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PdfBoxDemoService {

    public void editPdfWithMyValues() throws IOException {

        File file = new File("existingpdf.pdf");

        // TODO : faire apparaitre les points aux endroits souhaités
        Map<String, Coordonnee> mesValeurs = new HashMap<>();
        mesValeurs.put("Champ 1", new Coordonnee(100, 200));
        mesValeurs.put("Champ 2", new Coordonnee(300, 400));
        mesValeurs.put("Champ 3", new Coordonnee(500, 600));
        mesValeurs.put("Champ 4", new Coordonnee(700, 800));
        mesValeurs.put("Champ 5", new Coordonnee(900, 1000));

        editExistingPdfWithMapOfValues(file, mesValeurs);


    }

    private void createTextPdf() throws IOException {

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

    private void editExistingPdfWithMapOfValues(File template, Map<String, Coordonnee> contenuTableau) throws IOException {

        PDDocument document = PDDocument.load(template);
        PDPage page = document.getDocumentCatalog().getPages().get(0);

        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);
        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.beginText();

        contenuTableau.forEach((texte, coordonnees) -> {

            try {
                contentStream.newLineAtOffset(coordonnees.getX(), coordonnees.getY());
                contentStream.showText(texte);

            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        contentStream.endText();
        contentStream.close();
        document.save("testpdfbox.pdf");
        document.close();


    }

}
