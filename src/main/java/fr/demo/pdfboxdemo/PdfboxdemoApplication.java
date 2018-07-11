package fr.demo.pdfboxdemo;

import fr.demo.pdfboxdemo.service.PdfBoxDemoService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PdfboxdemoApplication {

	public static void main(String[] args) {

		PdfBoxDemoService pdfBoxDemoService = new PdfBoxDemoService();
		try {
			pdfBoxDemoService.editPdfWithMyValues();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		SpringApplication.run(PdfboxdemoApplication.class, args);
	}
}
