package com.sandu.util;

import com.github.pagehelper.PageInfo;
import com.sandu.common.ReturnData;
import com.sandu.constant.ResponseEnum;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.sandu.util.Commoner.isEmpty;

/**
 * @author by bvvy
 * @date 2018/4/25
 */
@SuppressWarnings("unchecked")
public class ReturnDataUtil {
    public static <T, R> ReturnData<R> objReturner(T source, Function<T, R> fun) {
        if (isEmpty(source)) {
            return ReturnData.builder().code(ResponseEnum.NOT_CONTENT);
        } else {
            return ReturnData.builder().data(fun.apply(source)).code(ResponseEnum.SUCCESS);
        }
    }

    public static <T, R> ReturnData<R> pageReturner(PageInfo<T> pageInfo, Function<T, R> fun) {
        if (isEmpty(pageInfo.getList())) {
            return ReturnData.builder().list(pageInfo.getList()).total(pageInfo.getTotal()).code(ResponseEnum.NOT_CONTENT);
        } else {
            List<R> vos = pageInfo.getList().
                    stream().map(fun).collect(Collectors.toList());
            return ReturnData.builder().list(vos).total(pageInfo.getTotal()).code(ResponseEnum.SUCCESS);
        }
    }

    public static  <T> ReturnData validReturner(BindingResult br, T obj, Consumer<T> consumer) {

        if (br.hasErrors()) {
            return processValidError(br);
        } else {
            consumer.accept(obj);
            return ReturnData.builder().code(ResponseEnum.SUCCESS);
        }
    }

    private static ReturnData processValidError(BindingResult br) {
        StringBuilder error = new StringBuilder();
        br.getAllErrors().forEach((e) -> {
            error.append(e.getDefaultMessage());
            error.append("; ");
        });
        return ReturnData.builder().success(false).code(ResponseEnum.PARAM_ERROR).message(error.toString());
    }

}
