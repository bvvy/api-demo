package com.sandu.api.product.output;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author by bvvy
 * @date 2018/4/24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO implements Serializable {

    @ApiModelProperty(value = "产品id")
    private Long id;
    @ApiModelProperty(value = "产品编码")
    private String code;
    @ApiModelProperty(value = "产品名称")
    private String name;
    @ApiModelProperty(value = "产品型号")
    private String modelNumber;
    @ApiModelProperty(value = "建议售价")
    private Double advicePrice;
    @ApiModelProperty(value = "售价")
    private Double price;
    @ApiModelProperty(value = "产品描述")
    private String desc;
}
