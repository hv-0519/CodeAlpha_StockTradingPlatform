import java.util.HashMap;

public class User {
    private String name;
    private HashMap<String, Integer> portfolio;

    public User(String name) {
        this.name = name;
        this.portfolio = new HashMap<>();
    }

    public void buyStock(String symbol, int quantity) {
        portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + quantity);
    }

    public void sellStock(String symbol, int quantity) {
        if (portfolio.containsKey(symbol)) {
            int current = portfolio.get(symbol);
            if (current >= quantity) {
                portfolio.put(symbol, current - quantity);
                if (portfolio.get(symbol) == 0) {
                    portfolio.remove(symbol);
                }
            } else {
                System.out.println("Not enough stock to sell.");
            }
        } else {
            System.out.println("No stock found in portfolio.");
        }
    }

    public void displayPortfolio() {
        System.out.println("Portfolio for " + name + ":");
        if (portfolio.isEmpty()) {
            System.out.println("  [Empty]");
        } else {
            portfolio.forEach((symbol, qty) -> System.out.println("  " + symbol + ": " + qty + " shares"));
        }
    }
}
