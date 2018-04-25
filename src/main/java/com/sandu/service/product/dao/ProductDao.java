package com.sandu.service.product.dao;

import com.sandu.api.product.model.Product;
import com.sandu.api.product.model.po.ProductPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sandu
 * @date 2017/12/16
 */
@Repository
public interface ProductDao {
    /**
     * 通过id删除
     *
     * @param id id
     * @return 1, 0
     */
    Integer deleteProductById(@Param("id") Long id);

    /**
     * 通过product code 删除
     *
     * @param productCode product code
     * @return 1, 0
     */
    Integer deleteProductByCode(@Param("productCode") String productCode);

    /**
     * 修改product
     *
     * @param product product
     * @return 1, 0
     */
    Integer updateProduct(Product product);

    /**
     * 添加product
     *
     * @param product product
     * @return 1, 0
     */
    Integer saveProduct(Product product);

    /**
     * 获取产品信息
     *
     * @param id id
     * @return product信息
     */
    Product getProductInfoById(@Param("id") Long id);

    /**
     * 查询产品
     *
     * @param productPO 查询条件
     * @return 查询结果
     */
    List<Product> queryProduct(ProductPO productPO);


}
