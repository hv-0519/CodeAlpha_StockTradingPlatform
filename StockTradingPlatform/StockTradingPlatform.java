import java.util.HashMap;
import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample market stocks
        HashMap<String, Stock> market = new HashMap<>();
        market.put("AAPL", new Stock("AAPL", 150.00));
        market.put("GOOG", new Stock("GOOG", 2800.00));
        market.put("MSFT", new Stock("MSFT", 300.00));

        System.out.print("Enter user name: ");
        String userName = sc.nextLine();
        User user = new User(userName);

        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: // Market
                    System.out.println("Market Stocks:");
                    market.forEach((sym, stock) ->
                        System.out.printf("%s - $%.2f%n", sym, stock.getPrice()));
                    break;
                case 2: // Buy
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = sc.nextLine().toUpperCase();
                    if (market.containsKey(buySymbol)) {
                        System.out.print("Enter quantity to buy: ");
                        int quantity = sc.nextInt();
                        sc.nextLine();
                        user.buyStock(buySymbol, quantity);
                        System.out.println("Bought " + quantity + " shares of " + buySymbol);
                    } else {
                        System.out.println("Invalid stock symbol.");
                    }
                    break;
                case 3: // Sell
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = sc.nextLine().toUpperCase();
                    System.out.print("Enter quantity to sell: ");
                    int sellQty = sc.nextInt();
                    sc.nextLine();
                    user.sellStock(sellSymbol, sellQty);
                    break;
                case 4: // Portfolio
                    user.displayPortfolio();
                    break;
                case 5: // Exit
                    running = false;
                    System.out.println("Exiting...");
                    break;~~
                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
