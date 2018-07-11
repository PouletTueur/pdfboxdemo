package fr.enedis.pdfboxdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PdfboxdemoApplication {

	public static void main(String[] args) {

		PdfBoxDemoService pdfBoxDemoService = new PdfBoxDemoService();
		try {
			pdfBoxDemoService.editExistingPdfWithText();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		SpringApplication.run(PdfboxdemoApplication.class, args);
	}
}
