package javaserver;

import javaserver.entities.BondEntity;
import javaserver.models.Bond;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JavaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaServerApplication.class, args);
//        BondsTable bondDAO = new BondsTable();

        Bond bond = new Bond();
        bond.setValues("Сбербанк", 12, 6, 6, 18.0f);


        Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(Bond.class);

        StandardServiceRegistryBuilder sBuilder = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties());

        SessionFactory sf = conf.buildSessionFactory(sBuilder.build());
        Session sessionCreate = sf.openSession();
        Transaction transaction = sessionCreate.beginTransaction();
        sessionCreate.save(bond);



//// Создание облигации и сохранение в базе данных
//        BondEntity bond = new BondEntity();
//        bond.setBondName("Облигация А");
//        bond.setRepaymentPeriod(10);
//        bond.setCouponRate(5);
//        bond.setYieldToMaturity(6.5f);
//        bondDAO.saveBond(bond);

// Получение всех облигаций из базы данных
//        List<BondEntity> bonds = bondDAO.getAllBonds();
//        for (BondEntity b : bonds) {
//            System.out.println(b.getBondName() + ": " + b.getRepaymentPeriod() + " years");
//        }

    }

}
