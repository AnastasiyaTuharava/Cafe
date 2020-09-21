package by.softclub.service;

import by.softclub.dao.CafeProductDAO;
import by.softclub.model.CafeProduct;
import lombok.NoArgsConstructor;

import javax.ejb.Singleton;
import java.util.List;

@Singleton
@NoArgsConstructor
public class CafeProductService {

    private final CafeProductDAO dao = new CafeProductDAO();

    public CafeProduct findById(int id) {
        return dao.findById(id);
    }

    public List<CafeProduct> getProducts() {
        return dao.getProducts();
    }

    public void save(CafeProduct product) {
        dao.save(product);
    }

    public void update(CafeProduct product) {
        dao.update(product);
    }

    public void delete(CafeProduct product) {
        dao.delete(product);
    }

}
