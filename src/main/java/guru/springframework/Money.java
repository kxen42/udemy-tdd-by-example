package guru.springframework;

import java.util.Objects;

public class Money {
    protected int amount;
    protected String currency;


    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // factory methods
    public static Dollar dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Franc franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public Money times(int multiplier){
        return new Money(amount * multiplier, currency);
    }


    public String currency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        Money other = (Money) o;
        if (this == other) return true;
        if (other == null) return false;
        return amount == other.amount &&
            Objects.equals(currency, other.currency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return "Money{" +
            "amount=" + amount +
            ", currency='" + currency + '\'' +
            '}';
    }
}
