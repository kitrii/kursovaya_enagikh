package javaserver.services;


import javaserver.models.Bond;
import org.springframework.stereotype.Service;

@Service
public class BondService {

    public Bond getBonds(String name){
        Bond bond = new Bond();
        bond.setBondName(name);
        return bond;
    }

    public Bond[] getBondsByUserName(String userName){
        Bond[] results = new Bond[]{};
        return results;
    }

    public void addBond(){}
}
