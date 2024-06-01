import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final String supportedCurrencies = """
            ARS - Peso Argentino;
            BOB - Boliviano da bolívia
            BRL - Real Brasileiro
            CLP - Peso Chileno
            COP - Peso Colombiano
            USD - Dólar Americano
            CNY - Renminbi Chinês
            EUR - Euro
            GBP - Libra esterlina
            """;

    public void viewMainMenu() {
        System.out.println("Digite o número da opção que deseja realizar: ");
        var textMainMenu = """
                1) Realizar a conversão
                2) Histórico de conversão
                3) Sair
                """;
        System.out.println(textMainMenu);
    }

    public int readMainMenuOption() {
        Scanner read = new Scanner(System.in);
        System.out.println("Digite uma opção correspondente: ");
        return read.nextInt();
    }

    public void viewMenuCurrencies(String partText) {
        System.out.println("Digite o código monetário " + partText);
        System.out.println(supportedCurrencies);
    }

    public String readOptionCurrencies() {
        Scanner read = new Scanner(System.in);
        String option = read.nextLine().toUpperCase().replaceAll("\\s+","");
        while (!supportedCurrencies.contains(option)) {
            System.out.println("Opção digita invalida tente novamente!");
            System.out.println(supportedCurrencies);
            option = read.nextLine();
        }
        return option;
    }

    public Double readConversionValue() {
        System.out.println("Digite um valor que deseja para fazer a conversão: ");
        Scanner read = new Scanner(System.in);
        double value;
        while (!read.hasNextDouble()) {
            System.out.println("Valor digitado não é um número!!");
            System.out.println("Tente novamente");
            read.nextLine();
        }
        value = read.nextDouble();
        return value;

    }

    public Double gettingDataConversation(String coinBase, Double value, Double conversationRate, String coinEnd) {
        var result = value * conversationRate;
        System.out.println(value + " " + coinBase + " é equivalente: " + result + " " + coinEnd);
        return result;
    }

    public void printConversation(ArrayList<Conversion> historicConsult) {
        if (historicConsult.isEmpty()) {
            System.out.println("Não possuí nenhum histórico de conversão.....");
        } else {
            System.out.println("Histórico de conversão: ");
            for (int i = 0; i < historicConsult.size(); i++) {
                Conversion conversion = historicConsult.get(i);
                System.out.println("Moeda de origem: " + conversion.getCoinBase());
                System.out.println("Moeda final: " + conversion.getCoinObjective());
                System.out.println("Valor para a conversão: " + conversion.getChangeOfQuantity());
                System.out.println("Valor depois da conversão: " + conversion.getChangeOfQuantityObjective());
                System.out.println("Data: " + formatDateTime(conversion.getTime()));
                System.out.println();
            }
        }
    }

    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }
}

