import java.util.HashMap;
import java.util.Map;

class Purse {
    private Map<Denomination, Integer> cash = new HashMap<>();

    public void add(Denomination type, int num) {
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double getValue() {
        return cash.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().amt * entry.getValue())
                .sum();
    }

    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        cash.forEach((denom, count) -> sb.append(denom.name).append(": ").append(count).append("\n"));
        return sb.toString();
    }
}

