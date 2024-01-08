package client.models;

import javafx.beans.property.*;


/**
 * Класс Bond - облигации
 */
public class Bond {
    public SimpleStringProperty bondName;
    public SimpleIntegerProperty bondId;

    public SimpleLongProperty nominalCost;
    public SimpleLongProperty couponFrequency;
    public SimpleIntegerProperty repaymentPeriod;
    public SimpleIntegerProperty couponRate;
    public SimpleFloatProperty yieldToMaturity;
    public SimpleIntegerProperty ownerId;
    public SimpleStringProperty ownerName;



    /**
     * Конструктор Облигации
     */
    public Bond(String bondName, Integer bondId, int nominalCost,
                int couponFrequency, Integer repaymentPeriod,
                Integer couponRate, int yieldToMaturity, Integer ownerId,
                String ownerName) {
        this.bondName= new SimpleStringProperty(bondName);
        this.bondId = new SimpleIntegerProperty(bondId);
        this.nominalCost = new SimpleLongProperty(nominalCost);
        this.couponFrequency = new SimpleLongProperty(couponFrequency);
        this.couponRate = new SimpleIntegerProperty(couponRate);
        this.repaymentPeriod = new SimpleIntegerProperty(repaymentPeriod);
        this.yieldToMaturity = new SimpleFloatProperty(yieldToMaturity);
        this.ownerId = new SimpleIntegerProperty(ownerId);
        this.ownerName = new SimpleStringProperty(ownerName);
    }

    /**
     * Пустой конструктор Облигации
     */
    public Bond() {
        this(null,0,0,0,
                0, 0, 0, 0, null);
    }
}
