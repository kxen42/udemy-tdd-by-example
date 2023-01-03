package guru.springframework;

import java.util.Objects;

public class Money implements Expression {
    protected int amount;
    protected String currency;


    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // factory methods
    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Money times(int multiplier){
        return new Money(amount * multiplier, currency);
    }


    public String currency() {
        return currency;
    }

    public Expression plus(Money addend) {
        return new Money(amount + addend.amount, currency);

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
