import java.util.ArrayList;

public class Execution {
    public static void main(String[] args) {
        int option = 0;
        ApiConect consult = new ApiConect();
        ArrayList<Conversion> historicConsult = new ArrayList<>();

        while (option != 3) {
            Menu menu = new Menu();
            menu.viewMainMenu();

            option = menu.readMainMenuOption();

            switch (option) {
                case 1:
                    menu.viewMenuCurrencies("primeira Parte: ");
                    String coinBase = menu.readOptionCurrencies();
                    menu.viewMenuCurrencies("segunda Parte: ");
                    String coinEnd = menu.readOptionCurrencies();
                    Double value = menu.readConversionValue();
                    Coin coin = consult.searchAddress(coinBase);
                    Double conversationRate  = coin.getConversioRate(coinEnd.toUpperCase());
                    Double gettingDataConversation = menu.gettingDataConversation(coinBase, value, conversationRate, coinEnd);
                    Conversion newConversation = new Conversion(coinBase, coinEnd, value, gettingDataConversation);
                    historicConsult.add(newConversation);
                    break;
                case 2:
                    menu.printConversation(historicConsult);
                    break;
                case 3:
                    System.out.println("Encerrando o Programa!!");
                    break;
                default:
                    System.out.println("Digite uma opção valida");
            }

        }
    }
}
