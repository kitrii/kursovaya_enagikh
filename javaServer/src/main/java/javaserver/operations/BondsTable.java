//package javaserver.operations;
//
//import javaserver.entities.BondEntity;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import java.util.List;
//
//public class BondsTable {
//    public void saveBond(BondEntity bond) {
//        Session session = new Configuration().configure().buildSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(bond);
//        transaction.commit();
//        session.close();
//    }
//
//    public List<BondEntity> getAllBonds() {
//        Session session = new Configuration().configure().buildSessionFactory().openSession();
//        List<BondEntity> bonds = session.createQuery("SELECT * FROM Bonds").list();
//        session.close();
//        return bonds;
//    }
//}
