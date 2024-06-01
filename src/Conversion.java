import java.time.LocalDateTime;

public class Conversion {
    private String coinBase;
    private String coinObjective;
    private Double changeOfQuantity;
    private Double changeOfQuantityObjective;
    private LocalDateTime time;

    public Conversion(String coinBase, String coinObjective,
                      Double changeOfQuantity, Double changeOfQuantityObjective) {
        setCoinBase(coinBase);
        setCoinObjective(coinObjective);
        setChangeOfQuantity(changeOfQuantity);
        setChangeOfQuantityObjective(changeOfQuantityObjective);
        setTime(LocalDateTime.now());
    }

    public String getCoinBase() {
        return coinBase;
    }

    public void setCoinBase(String coinBase) {
        this.coinBase = coinBase;
    }

    public String getCoinObjective() {
        return coinObjective;
    }

    public void setCoinObjective(String coinObjective) {
        this.coinObjective = coinObjective;
    }

    public Double getChangeOfQuantity() {
        return changeOfQuantity;
    }

    public void setChangeOfQuantity(Double changeOfQuantity) {
        this.changeOfQuantity = changeOfQuantity;
    }

    public Double getChangeOfQuantityObjective() {
        return changeOfQuantityObjective;
    }

    public void setChangeOfQuantityObjective(Double changeOfQuantityObjective) {
        this.changeOfQuantityObjective = changeOfQuantityObjective;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
