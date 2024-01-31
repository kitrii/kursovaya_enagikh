package server.appserver.services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.appserver.entities.BondEntity;
import server.appserver.operations.BondsTableOperations;

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
        BTO.deleteBondByBondIdOwnerId(bondId, ownerId);
    }
    @Transactional
    public void addBondInfo(BondEntity bond){
        BTO.addBond(bond);
    }
    @Transactional
    public void editBondInfo(BondEntity bond){
        int ownerId = bond.ownerid;
        int bondId = bond.bondid;
        BTO.editBondByBondIdOwnerId(bondId, ownerId, bond);
    }
}
