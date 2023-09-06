package com.zlennon.commonentity.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @description: 统一返回封装
 * @version: 1.0.0
 */
@Data
@Builder
public class ResultVO<T> {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("消息")
    private String msg;

    @ApiModelProperty("数据")
    private T data;

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
