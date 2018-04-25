package com.sandu.api.product.output;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Sandu
 */
@Data
@Builder
public class ProductListVO implements Serializable{

    @ApiModelProperty(value = "产品id")
    private Integer id;
    @ApiModelProperty(value = "产品编码")
    private String code;
    @ApiModelProperty(value = "产品名称")
    private String productName;



    @ApiModelProperty(value = "产品录入时间")
    private Date gtmCreate;
    @ApiModelProperty(value = "产品公开状态：0不公开，1公开")
    private Integer secrecy;
    @ApiModelProperty(value = "产品型号")
    private String modelNumber;

}
