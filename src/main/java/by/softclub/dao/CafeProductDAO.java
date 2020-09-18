package by.softclub.dao;

import by.softclub.model.CafeProduct;
import by.softclub.util.HibernateSessionFactory;

public class CafeProductDAO {
    public CafeProduct findById(int id) {
        return HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .get(CafeProduct.class, id);
    }

    public static void main(String[] args) {
        System.out.println(new CafeProductDAO().findById(1));
    }
}
