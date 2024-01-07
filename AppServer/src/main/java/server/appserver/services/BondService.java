package server.appserver.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.appserver.entities.BondEntity;
import server.appserver.models.Bond;
import server.appserver.operations.BondsTableOperations;

import java.util.Date;
import java.util.List;

@Service
public class BondService {

    private final BondsTableOperations BTO = new BondsTableOperations();

    @Transactional(readOnly = true)
    public List<BondEntity> getAllBonds(){
        List<BondEntity> result = BTO.getAllBonds();
        return result;
    }
    @Transactional(readOnly = true)
    public List<BondEntity> getBondsByOwnerId(int ownerId){
        List<BondEntity> result = BTO.getBondsByOwnerId(ownerId);
        return result;
    }

    @Transactional
    public List<BondEntity> getBondsByOwnerName(String ownerName){
        List<BondEntity> results = BTO.getBondsByOwnerId(123);;
        return results;
    }

    @Transactional
    public void deleteBondByOwnerIdBondId(int bondId, int ownerId){
        List<BondEntity> result = BTO.deleteBondByBondIdOwnerId(bondId, ownerId);
    }

    @Transactional
    public void addBond(BondEntity bond){
        BTO.saveBondInfo(bond);
    }
}
