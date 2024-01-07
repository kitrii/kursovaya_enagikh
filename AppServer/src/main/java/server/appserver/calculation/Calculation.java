package server.appserver.calculation;

import server.appserver.entities.BondEntity;

import java.util.List;

public class Calculation {


    public static float calculateDuration(List<BondEntity> bonds){
        final int bondPart = 1;
        float portfolioDuration = 0;
        int bondCount = bonds.size();

        for (BondEntity bond: bonds){
            long N = bond.nominalcost;
            float c = bond.nominalcost / 100 * bond.couponrate;
            int n = bond.repaymentperiod;
            float r = bond.yieldtomaturity / 100;
            float num = 0;
            float denom = N;
            for (int j=1; j<=n; j++){
                float part = (float) ((j * c) / Math.pow((1 + r), j));
                num += part;
            }
            float bondDuration = (num/denom);
            float interimDuration = bondDuration * (bondPart/bondCount);
            portfolioDuration += interimDuration;
        }
        return portfolioDuration;
    }
}
