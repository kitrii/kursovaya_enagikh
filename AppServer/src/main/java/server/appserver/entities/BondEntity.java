package server.appserver.entities;



import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "bonds")
public class BondEntity {
    @Id
    @Column(nullable = false)
    public int bondid;
    @Column(nullable = false)
    public String bondname;
    @Column
    public int repaymentperiod;
    @Column
    public int couponrate;
    @Column
    public float yieldtomaturity;
    @Column(nullable = false)
    public int ownerid;
    @Column(nullable = false)
    public String owner;


    public void setValues(String bondName, int bondId, int repaymentPeriod, int couponRate,
                          float yieldToMaturity, int ownerId, String owner){
        this.bondname = bondName;
        this.bondid = bondId;
        this.repaymentperiod = repaymentPeriod;
        this.couponrate = couponRate;
        this.yieldtomaturity = yieldToMaturity;
        this.ownerid = ownerId;
        this.owner = owner;
    }
}
