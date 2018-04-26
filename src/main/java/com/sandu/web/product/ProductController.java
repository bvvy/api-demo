package com.sandu.web.product;

import com.github.pagehelper.PageInfo;
import com.sandu.api.product.input.ProductAdd;
import com.sandu.api.product.input.ProductQuery;
import com.sandu.api.product.input.ProductUpdate;
import com.sandu.api.product.model.bo.ProductBO;
import com.sandu.api.product.model.bo.ProductListBO;
import com.sandu.api.product.model.po.ProductPO;
import com.sandu.api.product.output.ProductListVO;
import com.sandu.api.product.output.ProductVO;
import com.sandu.api.product.service.biz.ProductBizService;
import com.sandu.common.BaseController;
import com.sandu.common.ReturnData;
import com.sandu.constant.ResponseEnum;
import com.sandu.util.Commoner;
import com.sandu.web.auth.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.sandu.util.ReturnDataUtil.pageReturner;
import static com.sandu.util.ReturnDataUtil.validReturner;

/**
 * CopyRight (c) 2018 Sandu Technology Inc.
 * <p>
 * sandu-api-demo
 *
 * @author sandu (yocome@gmail.com)
 * @datetime 2018/4/24 11:43
 */
@SuppressWarnings("unchecked")
@Api(description = "产品", tags = "product")
@RestController
@RequestMapping("/v1/product")
@Slf4j
public class ProductController extends BaseController {


    @Resource
    private ProductBizService productBizService;

    @GetMapping("/{productId}")
    @Permission("product:view")
    @ApiOperation(value = "获取单个产品", response = ProductVO.class)
    public ReturnData<ProductVO> getProductInfo(@PathVariable Long productId) {
        ProductBO product = productBizService.getProductInfoById(productId);
        if (Commoner.isEmpty(product)) {
            return ReturnData.builder().code(ResponseEnum.NOT_FOUND);
        }
        return ReturnData.builder().code(ResponseEnum.SUCCESS).data(product);
    }

    @ApiOperation(value = "获取查询结果", response = ProductListVO.class)
    @GetMapping("/list")
    @Permission("product:view")
    public ReturnData<ProductListVO> listProduct(@Valid ProductQuery productQuery, BindingResult br) {
        if (br.hasErrors()) {
            return processValidError(br, ReturnData.builder());
        }
        ProductPO productPO = new ProductPO();
        BeanUtils.copyProperties(productQuery, productPO);
        PageInfo<ProductListBO> bOPageInfo = productBizService.queryProducts(productPO);
        if (bOPageInfo.getList().size() == 0) {
            return ReturnData.builder().list(bOPageInfo.getList()).total(bOPageInfo.getTotal()).code(ResponseEnum.NOT_CONTENT);
        }
        List<ProductListVO> productListVOS = bOPageInfo.getList().stream()
                .map(it -> ProductListVO.builder()
                .code(it.getProductCode())
                .gtmCreate(it.getGmtCreate())
                .id(it.getId())
                .modelNumber(it.getModelNumber())
                .productName(it.getProductName())
                .secrecy(it.getSecrecy())
                .build()).collect(Collectors.toList());
        return ReturnData.builder().list(productListVOS).total(bOPageInfo.getTotal()).code(ResponseEnum.NOT_CONTENT);
    }

    @ApiOperation(value = "删除", response = ReturnData.class)
    @DeleteMapping
    @Permission("product:del")
    public ReturnData deleteProduct(@RequestParam String ids) {
        Arrays.stream(ids.split(",")).forEach(it -> productBizService.deleteProductById(Long.parseLong(it)));
        return ReturnData.builder().code(ResponseEnum.SUCCESS).message("success");
    }

    @ApiOperation(value = "添加", response = ReturnData.class)
    @PostMapping
    @Permission("product:add")
    public ReturnData addProduct(@Valid @RequestBody ProductAdd productAdd, BindingResult br) {
        if(br.hasErrors()) {
            return processValidError(br, ReturnData.builder());
        }
        productBizService.saveProduct(productAdd);
        return ReturnData.builder().code(ResponseEnum.SUCCESS);
    }

    @ApiOperation(value = "修改", response = ReturnData.class)
    @PutMapping
    @Permission("product:edit")
    public ReturnData updateProduct(@RequestBody @Valid ProductUpdate productUpdate, BindingResult br) {
        if(br.hasErrors()) {
            return processValidError(br, ReturnData.builder());
        }
        productBizService.updateProduct(productUpdate);
        return ReturnData.builder().code(ResponseEnum.SUCCESS);
    }

}
