package utils;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfFont;

import java.io.File;
import java.util.List;
import models.Profesor;
import views.paneles1.Panel10;

public class ImprimirPDF {

    private double costeModulo;
    private String[] datos;
    private String rutaArchivo;
    private List<Profesor> arrayEspecialidad;

    public ImprimirPDF(String[] datos, String rutaArchivo, List<Profesor> arrayEspecialidad) {
        this.datos=datos;
        this.rutaArchivo=rutaArchivo;
        this.arrayEspecialidad=arrayEspecialidad;
        // Crear una instancia de Panel10 para obtener el costeModulo
        Panel10 panel = new Panel10();
        costeModulo = panel.getCosteModulo();
        encabezado(datos, rutaArchivo, arrayEspecialidad);
    }

    private void encabezado(String[] datos, String rutaArchivo, List<Profesor> arrayEspecialidad) {

        try {
            // Crear la carpeta pdfs si no existe
            File directorio = new File("pdfs");
            if (!directorio.exists()) {
                directorio.mkdirs();  // Crea la carpeta pdfs si no existe
            }

            // Crear el archivo PDF
            String rutaCompleta = "pdfs/" + rutaArchivo;
            PdfWriter writer = new PdfWriter(rutaCompleta);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            // Usar las fuentes predeterminadas de iText
            PdfFont fontBold = PdfFontFactory.createFont("Helvetica-Bold");
            PdfFont fontRegular = PdfFontFactory.createFont("Helvetica");

            // Agregar el nombre de la academia
            document.add(new Paragraph("Academia de Vega")
                    .setFont(fontBold)
                    .setFontSize(22)
                    .setTextAlignment(TextAlignment.CENTER));

            // Agregar la dirección y teléfono
            document.add(new Paragraph("Calle Ficticia 123, Málaga, España")
                    .setFont(fontRegular)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("Tel: 900 234 567")
                    .setFont(fontRegular)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER));

            // Agregar un salto de línea
            document.add(new Paragraph("\n"));

            // Agregar el título de la factura
            document.add(new Paragraph("Factura")
                    .setFont(fontBold)
                    .setFontSize(20)
                    .setTextAlignment(TextAlignment.CENTER));

            // Agregar un número de factura
            document.add(new Paragraph("Número de matricula: " + datos[0])
                    .setFont(fontRegular)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT));

            // Agregar la fecha de emisión
            document.add(new Paragraph("Fecha de emisión: " + datos[3])
                    .setFont(fontRegular)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT));

            // Agregar una línea de separación
            document.add(new Paragraph("\n---------------------------------------------"));
            document.add(new Paragraph("\nDatos del alumno:")
                    .setFont(fontBold)
                    .setFontSize(14)
                    .setTextAlignment(TextAlignment.LEFT));
            document.add(new Paragraph("Nombre: " + datos[1] + " " + datos[2])
                    .setFont(fontRegular)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT));
            document.add(new Paragraph("Edad: " + datos[9] + " años")
                    .setFont(fontRegular)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT));
            document.add(new Paragraph("Estado: " + datos[5])
                    .setFont(fontRegular)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT));
            document.add(new Paragraph("Correo: " + datos[6])
                    .setFont(fontRegular)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT));
            document.add(new Paragraph("Fecha de matrícula: " + datos[7])
                    .setFont(fontRegular)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT));

            // Agregar una línea de separación
            document.add(new Paragraph("\n---------------------------------------------"));

            // Agregar la lista de profesores y especialidades
            if (arrayEspecialidad != null && !arrayEspecialidad.isEmpty()) {
                document.add(new Paragraph("\nProfesores y Modulos:")
                        .setFont(fontBold)
                        .setFontSize(14)
                        .setTextAlignment(TextAlignment.LEFT));

                for (Profesor dato : arrayEspecialidad) {
                    document.add(new Paragraph("- "
                            + dato.getNombre()
                            + dato.getNombre()
                            + ": " + dato.getEspecialidad()
                            + " - coste por modulo " + costeModulo + " €"
                    )
                            .setFont(fontRegular)
                            .setFontSize(12)
                            .setTextAlignment(TextAlignment.LEFT));
                }
            } else {
                document.add(new Paragraph("No hay profesores asociados.")
                        .setFont(fontRegular)
                        .setFontSize(12)
                        .setTextAlignment(TextAlignment.LEFT));
            }

            // Agregar un salto de línea y el importe total
            document.add(new Paragraph("\n"));
            try {
                // Convertir el valor del importe total a un tipo numérico (double)
                double importeTotal = Double.parseDouble(datos[10]);

                // Realizar el cálculo (importe total + IVA del 21%)
                double importeConIVA = importeTotal * 1.21;

                // Agregar el importe total con IVA al documento PDF
                document.add(new Paragraph("Importe total con IVA: " + String.format("%.2f €", importeConIVA)) // Formatear a 2 decimales
                        .setFont(fontBold)
                        .setFontSize(14)
                        .setTextAlignment(TextAlignment.RIGHT));

            } catch (NumberFormatException e) {
                // En caso de que el valor de datos[10] no sea un número válido
                document.add(new Paragraph("Error en el importe total.")
                        .setFont(fontBold)
                        .setFontSize(14)
                        .setTextAlignment(TextAlignment.RIGHT));
            }

            // Cerrar el documento PDF
            document.close();
            System.out.println("PDF generado correctamente en: " + rutaCompleta);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
