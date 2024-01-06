package javaserver.models;

public class Bond {
    private String bondName;
    private int bondId;
    private int repaymentPeriod;
    private int couponRate;
    private float yieldToMaturity;
    public void setBondName(String bondName){
        this.bondName = bondName;}
    public void setValues(String bondName, int bondId, int repaymentPeriod, int couponRate, float yieldToMaturity){
        this.bondName = bondName;
        this.bondId = bondId;
        this.repaymentPeriod = repaymentPeriod;
        this.couponRate = couponRate;
        this.yieldToMaturity = yieldToMaturity;
    }
}
