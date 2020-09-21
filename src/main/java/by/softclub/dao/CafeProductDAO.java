package by.softclub.dao;

import by.softclub.model.CafeProduct;
import by.softclub.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CafeProductDAO {

    public CafeProduct findById(int id) {
        return HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .get(CafeProduct.class, id);
    }

    public List<CafeProduct> getProducts() {
        return HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("SELECT a FROM CafeProduct a", CafeProduct.class).getResultList();
    }

    public void save(CafeProduct product) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(product);
        tx1.commit();
        session.close();
    }

    public void update(CafeProduct product) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(product);
        tx1.commit();
        session.close();
    }

    public void delete(CafeProduct product) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(product);
        tx1.commit();
        session.close();
    }

}
