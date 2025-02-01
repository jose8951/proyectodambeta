package utils;

import java.awt.Image;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import views.paneles1.Panel3;

public class Utilidades {

    /**
     * Muestra la fecha actual en formato 07 de ene de 2025
     *
     * @return
     */
    public static String mostrarFechaActual() {
        try {
            DateTimeFormatter formateo = DateTimeFormatter.ofPattern(" dd 'de' MMMM 'de' yyyy");
            String fechaformateada = LocalDate.now().format(formateo);
            return fechaformateada;
        } catch (Exception e) {
            // Manejo de errores
            JOptionPane.showMessageDialog(null, "Error al calcular la fecha actual: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return "Error de fecha"; // En caso de error
        }
    }

    /**
     * mostrar fecha y hora acutal para guardar en el archivo de pdf
     *
     * @return
     */
    public static String mostrarFechaHoraActual() {
        try {
            // Define el formato para la fecha y hora
            DateTimeFormatter formateo = DateTimeFormatter.ofPattern("ddMMMMyyyy_HH_mm");
            // Obtén la fecha y hora actuales
            String fechaHoraFormateada = LocalDateTime.now().format(formateo);
            return fechaHoraFormateada;
        } catch (Exception e) {
            // Manejo de errores
            JOptionPane.showMessageDialog(null, "Error al calcular la fecha y hora actual: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return "Error de fecha y hora"; // En caso de error
        }
    }

    /**
     * Calcular la edad de los alumnos
     *
     * @param mostrar
     * @return
     */
    public static int calcularEdad(Date mostrar) {
        try {
            Instant instant = mostrar.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();// Zona horaria del sistema
            LocalDate fechaNacimiento = instant.atZone(zoneId).toLocalDate();

            LocalDate fechaActual = LocalDate.now();
            return Period.between(fechaNacimiento, fechaActual).getYears();
        } catch (Exception e) {
            // Manejo de errores
            JOptionPane.showMessageDialog(null, "Error al calcular la edad: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1; // En caso de error
        }
    }

    /**
     * canculamos la edad pasando un string de la fecha
     *
     * @param fechaNacimiento
     * @return
     */
    public static int calcularEdad(String fechaNacimiento) {
        try {
            // Define el formato de la fecha (ajusta según el formato de entrada)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // Convierte la fecha de String a LocalDate
            LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formatter);
            // Obtén la fecha actual
            LocalDate fechaActual = LocalDate.now();
            // Calcula la edad
            return Period.between(fechaNac, fechaActual).getYears();
        } catch (DateTimeParseException e) {
            // Si el formato es incorrecto, lanza una excepción personalizada o devuelve -1
            System.err.println("Error: Formato de fecha inválido. Use 'dd/MM/yyyy'.");
            return -1;
        }
    }

    /**
     * calcula la edad pero no se esta utilizando
     *
     * @param mostrar
     * @return
     */
    public static int calcularEdad1(Date mostrar) {
        // Calcular la edad
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormato = sdf.format(mostrar);
        LocalDate fechaNacimento = LocalDate.parse(fechaFormato);
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(fechaNacimento, fechaActual).getYears();
        return edad;
    }

    public static boolean validarCorreo(String correo) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        //si es correcto devuelve true
        return correo.trim().matches(regex);
    }

    public static Date cambiarFecha(String fechaStr) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha = formato.parse(fechaStr);
            return fecha;
        } catch (ParseException ex) {
            Logger.getLogger(Panel3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    /**
     * le pasamos un string de fecha con un formato y devuelve otro formato de
     * fecha en string
     *
     * @param fechaStr
     * @return
     */
    public static String formatearFecha(String fechaStr) {
        if (fechaStr == null || fechaStr.isEmpty()) {
            return null;
        }
        try {
            // Define el formato de entrada (ajusta según cómo venga el String)
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd"); // Ejemplo: "2025-01-30"
            // Convierte el String a un objeto Date
            Date fecha = formatoEntrada.parse(fechaStr);
            // Define el formato de salida
            SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
            // Devuelve la fecha formateada como String
            return formatoSalida.format(fecha);
        } catch (Exception e) {
            System.err.println("Error al formatear la fecha: " + e.getMessage());
            return null;  // Retornar null o algún valor por defecto si hay un error
        }
    }

    //metodo para guardar en la base de datos
    public static Date formatearFechaDate(Date fecha) {
        if (fecha == null) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Manejo básico de errores.
            return sdf.parse(sdf.format(fecha));
        } catch (IllegalArgumentException e) {
            // Registrar el error
            JOptionPane.showMessageDialog(null, "Error en el formto de la fecha.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            System.err.println("Error al formatear la fecha: " + e.getMessage());
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Date cambiarFecha(Date fecha) {
        if (fecha == null) {
            return null; // Si la fecha es nula, no hacemos nada
        }
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            String fechaStr = formato.format(fecha);
            return formato.parse(fechaStr);
        } catch (ParseException ex) {
            Logger.getLogger(Panel3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String formatearFecha(Date fecha) {
        if (fecha == null) {
            return null;
        }
        try {
            // Formatear la fecha al formato 'dd-MM-yyyy'
            SimpleDateFormat formatoMostrar = new SimpleDateFormat("dd-MM-yyyy");
            return formatoMostrar.format(fecha);
        } catch (Exception e) {
            System.err.println("Error al formatear la fecha: " + e.getMessage());
            return null;  // Retornar null o algún valor por defecto si hay un error
        }
    }

    /**
     * Obtiene la fecha actual como un objeto java.util.Date.
     *
     * @return La fecha actual en formato java.util.Date.
     */
    public static Date obtenerFechaAcutal() {
        // Obtener la fecha actual como LocalDate
        LocalDate fechaActual = LocalDate.now();
        // Convertir LocalDate a java.util.Date
        return Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    
    /**
     * Devuelve un String de la fecha
     * @return 
     */
     public static String obtenerFechaActual() {
        // Obtener la fecha actual como LocalDate
        LocalDate fechaActual = LocalDate.now();
        // Formatear la fecha como String (ejemplo: "25/01/2025")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaActual.format(formatter);
    }

    /**
     * método reutilizable que extrae y valide el ID desde un JComboBox
     *
     * @param combo
     * @param tipo
     * @return
     */
    public static int obtenerIdDesdeCombo(JComboBox<String> combo, String tipo) {
        String seleccion = (String) combo.getSelectedItem();
        if (seleccion != null && !seleccion.equals("Seleccione un " + combo)) {
            try {
                String[] partes = seleccion.split(" - ");
                if (partes.length >= 1) {
                    return Integer.parseInt(partes[0].trim());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "El formato del ID del " + tipo + " no es válido.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "El formato del ID del " + tipo + " no es válido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Por favor, selecciona un " + tipo + " en el combo.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }

}
