package server.appserver;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import server.appserver.entities.BondEntity;
import server.appserver.operations.BondsTableOperations;

import java.util.List;

@SpringBootApplication
public class AppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppServerApplication.class, args);
//        BondsTableOperations BTO = new BondsTableOperations();
//        //// Получить данные из запросы fxjava по api -> мапнуть и засунуть в бд
//
//        BondEntity bond = new BondEntity();
//        bond.setValues("Mimigo", 87, 2,
//                44, 22.0f, 32, "MihailovBoni");
//
//
//        BTO.saveBondInfo(bond);
//        List<BondEntity> result = BTO.getBondsByOwnerId(123);


    }

}
