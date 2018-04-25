package com.sandu.api.product.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 产品查询参数
 * @author Sandu
 */
@Data
public class ProductQuery implements Serializable {


    /**
     * 产品编码
     */
    @ApiModelProperty(value = "产品编码")
    @Size(max = 20, message = "产品编码过长")
    private String productCode;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    @Size(max = 20, message = "产品名称过长")
    private String productName;

    @ApiModelProperty(value = "页码", required = true)
    @Min(value = 1, message = "请输入正确的数值")
    @NotNull(message = "页码不能为空")
    private Integer page;

    @ApiModelProperty(value = "条数", required = true)
    @Min(value = 1, message = "请输入正确的数值")
    @NotNull(message = "条数不能为空")
    private Integer limit;
    /**
     * 排序字段
     */
    @ApiModelProperty(value = "排序字段")
    private String orderField;
    /**
     * 排序方式
     */
    @ApiModelProperty(value = "排序方式")
    private String orderMethod;


    @ApiModelProperty(value = "产品型号")
    private String productModelNumber;

}
