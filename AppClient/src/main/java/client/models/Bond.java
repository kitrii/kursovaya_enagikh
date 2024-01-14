package client.models;

import javafx.beans.property.*;

public class Bond {
    public StringProperty bondName;
    public SimpleIntegerProperty bondId;

    public SimpleIntegerProperty nominalCost;
    public SimpleIntegerProperty couponFrequency;
    public SimpleIntegerProperty repaymentPeriod;
    public SimpleIntegerProperty couponRate;
    public SimpleIntegerProperty yieldToMaturity;
    public SimpleIntegerProperty ownerId;
    public SimpleStringProperty ownerName;



    /**Конструктор Облигации*/
    public Bond(String bondName, Integer bondId, int nominalCost,
                int couponFrequency, Integer repaymentPeriod,
                Integer couponRate, int yieldToMaturity, Integer ownerId,
                String ownerName) {
        this.bondName= new SimpleStringProperty(bondName);
        this.bondId = new SimpleIntegerProperty(bondId);
        this.nominalCost = new SimpleIntegerProperty(nominalCost);
        this.couponFrequency = new SimpleIntegerProperty(couponFrequency);
        this.couponRate = new SimpleIntegerProperty(couponRate);
        this.repaymentPeriod = new SimpleIntegerProperty(repaymentPeriod);
        this.yieldToMaturity = new SimpleIntegerProperty(yieldToMaturity);
        this.ownerId = new SimpleIntegerProperty(ownerId);
        this.ownerName = new SimpleStringProperty(ownerName);
    }
}
