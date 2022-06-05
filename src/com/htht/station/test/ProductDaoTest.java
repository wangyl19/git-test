package com.htht.station.test;

import com.htht.station.dao.ProductDao;
import org.junit.Test;

/**
 * Created by WYL on 2022/6/4.
 */
public class ProductDaoTest {
    ProductDao productDao = new ProductDao();

    @Test
    public void testSave(){
        productDao.save("苹果手机", 888);
    }

    @Test
    public void testDelete(){
        productDao.delete(2);
    }

    @Test
    public void testUpdate(){
        productDao.update(1, "苹果手机", 888);
    }

    @Test
    public void testQuery(){
        String query = productDao.query();
        System.out.println("query = "+query);
    }
}