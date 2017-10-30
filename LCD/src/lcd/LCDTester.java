package lcd;

import lcd.ImpresorLCD;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class LCDTester {

    static final String CADENA_FINAL = "0";

    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        String comando;

        try {

            try (Scanner lector = new Scanner(System.in)) {

                do {
                    System.out.println("Entra Ejemplo. 123 0");
                    System.out.print("Entrada: \n");
                    comando = lector.next();

                    if (!comando.equalsIgnoreCase(CADENA_FINAL)) {
                        listaComando.add(comando);
                    }
                } while (!comando.equalsIgnoreCase(CADENA_FINAL));
            }

            ImpresorLCD impresorLCD = new ImpresorLCD();

            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext()) {
                try {
                    impresorLCD.procesar(iterator.next(), 1);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

}
