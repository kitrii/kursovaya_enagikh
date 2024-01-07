package server.appserver.mapper;

import server.appserver.entities.BondEntity;
import server.appserver.models.Bond;

import java.util.ArrayList;
import java.util.List;

public class BondMapper {

    public static List<Bond> BondEntityToBondMapper(List<BondEntity> BondEntities){
        List<Bond> bonds = new ArrayList<>();
        for (BondEntity bond: BondEntities) {
            Bond vBond = new Bond();
            vBond.setValues(bond.bondname, bond.bondid, bond.nominalcost, bond.couponfrequency,
                    bond.repaymentperiod, bond.couponrate,
                    bond.yieldtomaturity, bond.ownerid, bond.owner);
            bonds.add(vBond);
        }
        return bonds;
    }
}
