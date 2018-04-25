package com.sandu.api.product.service;

import com.github.pagehelper.PageInfo;
import com.sandu.api.product.model.Product;
import com.sandu.api.product.model.bo.ProductListBO;
import com.sandu.api.product.model.po.ProductPO;

/**
 * @author Sandu
 * @date 2017/12/16
 */
public interface ProductService {

    /**
     * 删除产品
     *
     * @param id id
     */
    void deleteProductById(Long id);

    /**
     * 根据产品code删除产品
     *
     * @param productCode code
     */
    void deleteProductByCode(String productCode);

    /**
     * 更新产品
     *
     * @param product product
     * @return id
     */
    Long updateProduct(Product product);

    /**
     * 增加产品
     *
     * @param product product
     * @return id
     */
    Long saveProduct(Product product);

    /**
     * 根据ID获取产品详情
     *
     * @param id id
     * @return product
     */
    Product getProductInfoById(Long id);

    /**
     * 查询产品
     *
     * @param productPO product
     * @return product
     */
    PageInfo<ProductListBO> queryProducts(ProductPO productPO);
}


