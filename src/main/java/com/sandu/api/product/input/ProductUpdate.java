package com.sandu.api.product.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 产品添加数据
 * @author Sandu
 */
@Data
public class ProductUpdate implements Serializable {

    @ApiModelProperty(value = "产品编码",required = true)
    @NotEmpty(message = "产品编码不能为空")
    @Size(min = 1, max = 20, message = "产品名称长度应在{min}-{max}之间")
    private String code;

    @ApiModelProperty(value = "产品名称", required = true)
    @NotEmpty(message = "产品名称不能为空")
    @Size(min = 1, max = 20, message = "产品名称长度应在{min}-{max}之间")
    private String name;


    @ApiModelProperty(value = "建议售价")
    @Max(value = 100000, message = "建议售价数值超出限制,100000")
    private Double advicePrice;

    @ApiModelProperty(value = "售价")
    @Max(value = 100000, message = "售价数值超出限制,100000")
    private Double price;

    @ApiModelProperty(value = "产品描述")
    @Length(max = 5000, message = "产品描述长度超过{max}")
    private String desc;


    @ApiModelProperty(value = "产品型号", required = true)
    @NotEmpty(message = "产品型号不能为空")
    private String modelNumber;

    @ApiModelProperty(value = "产品宽")
    @Size(max = 10, message = "请输入正确的宽度")
    private String width;

    @ApiModelProperty(value = "产品长")
    @Size(max = 10, message = "请输入正确的长度")
    private String length;

    @ApiModelProperty(value = "产品高")
    @Size(max = 10, message = "请输入正确的高度")
    private String height;

}
