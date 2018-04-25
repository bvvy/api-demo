package com.sandu.service.product.impl.biz;

import com.github.pagehelper.PageInfo;
import com.sandu.api.product.input.ProductAdd;
import com.sandu.api.product.input.ProductUpdate;
import com.sandu.api.product.model.Product;
import com.sandu.api.product.model.bo.ProductBO;
import com.sandu.api.product.model.bo.ProductListBO;
import com.sandu.api.product.model.po.ProductPO;
import com.sandu.api.product.service.ProductService;
import com.sandu.api.product.service.biz.ProductBizService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 业务
 *
 * @author Sandu
 */
@Log4j
@Service("productBizService")
public class ProductBizServiceImpl implements ProductBizService {


    @Resource
    private ProductService productService;

    @Override
    public void deleteProductById(Long id) {
        productService.deleteProductById(id);
    }

    @Override
    public void deleteProductByCode(String productCode) {
        productService.deleteProductByCode(productCode);
    }

    @Override
    public Long saveProduct(ProductAdd productAdd) {
        Product product = Product.builder()
                .productCode(productAdd.getCode())
                .productName(productAdd.getName())
                .advicePrice(productAdd.getAdvicePrice())
                .salePrice(productAdd.getPrice())
                .productDesc(productAdd.getDesc())
                .productModelNumber(productAdd.getModelNumber())
                .productWidth(productAdd.getWidth())
                .productHeight(productAdd.getHeight())
                .productLength(productAdd.getLength()).build();
        return productService.updateProduct(product);
    }

    @Override
    public Long updateProduct(ProductUpdate productUpdate) {
        Product product = Product.builder()
                .productCode(productUpdate.getCode())
                .productName(productUpdate.getName())
                .advicePrice(productUpdate.getAdvicePrice())
                .salePrice(productUpdate.getPrice())
                .productDesc(productUpdate.getDesc())
                .productModelNumber(productUpdate.getModelNumber())
                .productWidth(productUpdate.getWidth())
                .productHeight(productUpdate.getHeight())
                .productLength(productUpdate.getLength()).build();
        return productService.saveProduct(product);
    }

    @Override
    public ProductBO getProductInfoById(Long id) {
        Product product = productService.getProductInfoById(id);
        return ProductBO.builder()
                .advicePrice(product.getAdvicePrice())
                .code(product.getProductCode())
                .desc(product.getProductDesc())
                .height(product.getProductHeight())
                .length(product.getProductLength())
                .modelNumber(product.getProductModelNumber())
                .name(product.getProductName())
                .price(product.getSalePrice())
                .width(product.getProductWidth())
                .build();
    }

    @Override
    public PageInfo<ProductListBO> queryProducts(ProductPO productPO) {
        return productService.queryProducts(productPO);
    }
}
