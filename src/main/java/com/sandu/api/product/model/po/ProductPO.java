package com.sandu.api.product.model.po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Sandu
 */
@Data
public class ProductPO implements Serializable {

    /**
     * 产品编码
     */
    private String productCode;
    /**
     * 产品名称
     */
    private String productName;


    /**
     * 页数
     */
    private Integer page;
    /**
     * limit
     */
    private Integer limit;
    /**
     * 排序字段
     */
    private String orderField;
    /**
     * 排序方式
     */
    private String orderMethod;


    /**
     * 产品型号
     */
    private String modelNumber;
}
