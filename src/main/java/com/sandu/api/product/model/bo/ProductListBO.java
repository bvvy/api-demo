package com.sandu.api.product.model.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Sandu
 */
@Data
public class ProductListBO implements Serializable {
    private Integer id;
    /**
     * 产品编码
     */
    private String productCode;
    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品创建时间
     */
    private Date gmtCreate;
    /**
     * 产品公开状态：0不公开，1公开
     */
    private Integer secrecy;

    /**
     * 产品型号
     */
    private String modelNumber;



}
