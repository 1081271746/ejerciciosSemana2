import java.util.InputMismatchException;
import java.util.Scanner;

public class GrapeProfitCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialPrice = 0;
        char grapeType;
        int grapeSize;
        double adjustedPrice = 0;
        double totalProfit = 0;
        int kilosSold = 0;

        // Solicitar precio inicial por kilo
        while (true) {
            try {
                System.out.print("Ingrese el precio inicial por kilo de uva: ");
                initialPrice = scanner.nextDouble();
                if (initialPrice > 0) break;
                System.out.println("Error: El precio debe ser mayor que cero.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next();
            }
        }

        // Solicitar tipo de uva
        while (true) {
            System.out.print("Ingrese el tipo de uva (A o B): ");
            grapeType = scanner.next().toUpperCase().charAt(0);
            if (grapeType == 'A' || grapeType == 'B') break;
            System.out.println("Error: Ingrese un tipo válido (A o B).");
        }

        // Solicitar tamaño de uva
        while (true) {
            try {
                System.out.print("Ingrese el tamaño de la uva (1 o 2): ");
                grapeSize = scanner.nextInt();
                if (grapeSize == 1 || grapeSize == 2) break;
                System.out.println("Error: Ingrese un tamaño válido (1 o 2).");
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next();
            }
        }

        // Aplicar ajustes de precio según el tipo y tamaño de uva
        if (grapeType == 'A') {
            adjustedPrice = initialPrice + (grapeSize == 1 ? 0.20 : 0.30);
        } else {
            adjustedPrice = initialPrice - (grapeSize == 1 ? 0.30 : 0.50);
        }

        // Solicitar cantidad de kilos vendidos
        while (true) {
            try {
                System.out.print("Ingrese la cantidad de kilos vendidos: ");
                kilosSold = scanner.nextInt();
                if (kilosSold > 0) break;
                System.out.println("Error: La cantidad debe ser mayor que cero.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next();
            }
        }

        // Calcular la ganancia total
        totalProfit = adjustedPrice * kilosSold;
        
        // Mostrar resultados
        System.out.printf("El precio ajustado por kilo es: $%.2f\n", adjustedPrice);
        System.out.printf("La ganancia total por la venta es: $%.2f\n", totalProfit);

        scanner.close();
    }
}
