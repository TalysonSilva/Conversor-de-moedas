import java.util.Map;

public record Coin(
        String base_code,
        Map<String, Double> conversion_rates) {
    public Double getConversioRate(String coin) {
        return conversion_rates.get(coin);
    }
}
