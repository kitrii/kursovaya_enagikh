package server.appserver.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import server.appserver.entities.BondEntity;

import java.util.List;

public class BondsTableOperations {
    public void saveBondInfo(BondEntity bond) {
        Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(BondEntity.class);

        StandardServiceRegistryBuilder sBuilder = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties());

        SessionFactory sf = conf.buildSessionFactory(sBuilder.build());
        Session sessionCreate = sf.openSession();
        Transaction transaction = sessionCreate.beginTransaction();
        sessionCreate.save(bond);
        transaction.commit();
        sessionCreate.close();
    }

    public List<BondEntity> getBondsByOwnerId(int ownerId) {
        Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(BondEntity.class);

        StandardServiceRegistryBuilder sBuilder = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties());

        SessionFactory sf = conf.buildSessionFactory(sBuilder.build());
        Session sessionRead = sf.openSession();
        Transaction transaction = sessionRead.beginTransaction();
        List<BondEntity> bonds = sessionRead.createQuery("from BondEntity where ownerid = " + ownerId).getResultList();
        transaction.commit();
        sessionRead.close();
        return bonds;
    }
    public List<BondEntity> getAllBonds() {
        Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(BondEntity.class);

        StandardServiceRegistryBuilder sBuilder = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties());
        SessionFactory sf = conf.buildSessionFactory(sBuilder.build());
        Session sessionRead = sf.openSession();
        Transaction transaction = sessionRead.beginTransaction();
        List<BondEntity> bonds = sessionRead.createQuery("from BondEntity").getResultList();
        transaction.commit();
        sessionRead.close();
        return bonds;
    }
    public List<BondEntity> deleteBondByBondIdOwnerId(int bondId, int ownerId) {
        Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(BondEntity.class);

        StandardServiceRegistryBuilder sBuilder = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties());
        SessionFactory sf = conf.buildSessionFactory(sBuilder.build());
        Session sessionRead = sf.openSession();
        Transaction transaction = sessionRead.beginTransaction();
        List<BondEntity> bonds = sessionRead.createQuery("from BondEntity").getResultList();
        transaction.commit();
        sessionRead.close();
        return bonds;
    }
}
