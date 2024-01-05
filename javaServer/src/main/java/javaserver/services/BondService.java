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
}
