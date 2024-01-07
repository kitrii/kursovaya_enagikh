package server.appserver.models;

public class Bond {
    public String bondName;
    public int bondId;
    public int repaymentPeriod;
    public int couponRate;
    public float yieldToMaturity;

    public int ownerId;

    public String ownerName;
    public void setBondName(String bondName){
        this.bondName = bondName;}
    public void setValues(String bondName, int bondId, int repaymentPeriod,
                          int couponRate, float yieldToMaturity, int ownerId,
                          String owenrName){
        this.bondName = bondName;
        this.bondId = bondId;
        this.repaymentPeriod = repaymentPeriod;
        this.couponRate = couponRate;
        this.yieldToMaturity = yieldToMaturity;
        this.ownerId = ownerId;
        this.ownerName = owenrName;
    }
}
