package com.sandu.api.product.model.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author by bvvy
 * @date 2018/4/24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductBO implements Serializable {

    /**
     * 产品编码
     */
    private String code;

    /**
     * 产品名称
     */

    private String name;

    /**
     * 建议售价
     */
    private Double advicePrice;
    /**
     * 售价
     */
    private Double price;
    /**
     * 产品描述
     */
    private String desc;
    /**
     * 产品型号
     */

    private String modelNumber;
    /**
     * 产品宽
     */
    private String width;
    /**
     * 产产品长品编码
     */
    private String length;
    /**
     * 产品高
     */
    private String height;
}
