package com.sandu.api.product.service.biz;

import com.github.pagehelper.PageInfo;
import com.sandu.api.product.input.ProductAdd;
import com.sandu.api.product.input.ProductUpdate;
import com.sandu.api.product.model.bo.ProductBO;
import com.sandu.api.product.model.bo.ProductListBO;
import com.sandu.api.product.model.po.ProductPO;

/**
 *
 * 所有的controller 调biz 不直接调productService
 * biz 调productService 不直接调dao
 * @author by Sandu
 * @date 2018/4/24
 */
public interface ProductBizService {
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
     * @param productAdd product add
     * @return id
     */
    Long saveProduct(ProductAdd productAdd);

    /**
     * 增加产品
     *
     * @param productUpdate product update
     * @return id
     */
    Long updateProduct(ProductUpdate productUpdate);

    /**
     * 根据ID获取产品详情
     *
     * @param id id
     * @return product
     */
    ProductBO getProductInfoById(Long id);

    /**
     * 查询产品
     *
     * @param productPO product
     * @return product
     */
    PageInfo<ProductListBO> queryProducts(ProductPO productPO);

}
