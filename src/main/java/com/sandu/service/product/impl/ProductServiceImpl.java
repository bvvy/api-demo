package com.sandu.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sandu.api.product.model.Product;
import com.sandu.api.product.model.bo.ProductListBO;
import com.sandu.api.product.model.po.ProductPO;
import com.sandu.api.product.service.ProductService;
import com.sandu.service.product.dao.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CopyRight (c) 2017 Sandu Technology Inc.
 * <p>
 * sandu-wangwang
 *
 * @author Yoco (yocome@gmail.com)
 * @date 2017/12/15 10:02
 */
@Slf4j
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void deleteProductById(Long id) {
        productDao.deleteProductById(id);
    }

    @Override
    public void deleteProductByCode(String productCode) {
        productDao.deleteProductByCode(productCode);
    }

    @Override
    public Long updateProduct(Product product) {
        int flag = productDao.updateProduct(product);
        if (flag > 0) {
            return product.getId();
        } else {
            return 0L;
        }
    }

    @Override
    public Long saveProduct(Product product) {
        int flag = productDao.saveProduct(product);
        if (flag > 0) {
            return product.getId();
        } else {
            return 0L;
        }
    }


    @Override
    public Product getProductInfoById(Long id) {
        return productDao.getProductInfoById(id);
    }


    @Override
    public PageInfo<ProductListBO> queryProducts(ProductPO productPO) {
        return PageHelper.startPage(productPO.getPage(), productPO.getLimit()).doSelectPageInfo(() -> productDao.queryProduct(productPO));
    }


}
