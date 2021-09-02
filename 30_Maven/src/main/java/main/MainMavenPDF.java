package main;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

//Como hemos añadido las librerías de PDF a nuestras dependencias maven, ahora podmos
//empezar a usar la biblioteca

//El objetivo de este ejemplo no es aprender a usar la libería, es ver que efectivamente
//gracias a maven, nos descarga automáticamente la libería y podemos empezar a usarla

//Para más información sobre la librería:
//https://zetcode.com/java/pdfbox/

//Si ejecutamos este main podemos ver como se nos crea un documento pdf en la carpeta
//src/main/resources

//Tambien podriamos usar la libreria de conexión de MySql sin problema ya que la tenemos
//en las dependencias
public class MainMavenPDF {
	public static void main(String[] args) {
		try (PDDocument doc = new PDDocument()) {

			PDPage myPage = new PDPage();
			doc.addPage(myPage);

			try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {

				cont.beginText();

				cont.setFont(PDType1Font.TIMES_ROMAN, 12);
				cont.setLeading(14.5f);

				cont.newLineAtOffset(25, 700);
				String line1 = "World War II (often abbreviated to WWII or WW2), "
						+ "also known as the Second World War,";
				cont.showText(line1);

				cont.newLine();

				String line2 = "was a global war that lasted from 1939 to 1945, "
						+ "although related conflicts began earlier.";
				cont.showText(line2);
				cont.newLine();

				String line3 = "It involved the vast majority of the world's "
						+ "countries—including all of the great powers—";
				cont.showText(line3);
				cont.newLine();

				String line4 = "eventually forming two opposing military " + "alliances: the Allies and the Axis.";
				cont.showText(line4);
				cont.newLine();

				cont.endText();				
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
			doc.save("src/main/resources/wwii.pdf");
			System.out.println("Fichero pdf creado en src/main/resources/wwii.pdf");
			System.out.println("Refresque el proyecto en caso de que no aparezca");
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
