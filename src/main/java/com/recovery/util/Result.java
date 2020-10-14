package com.recovery.util;

import com.recovery.util.enums.ErrorEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel("返回结果")
public class Result<T> {

    @ApiModelProperty("返回代码")
    @Getter
    @Setter
    private int code;
    @ApiModelProperty("返回信息")
    @Getter
    @Setter
    private String message;
    @ApiModelProperty("相关数据")
    @Getter
    @Setter
    private Object data;

    public Result (ErrorEnum error) {
        this.code = error.getErrorCode();
        this.message = error.getErrorMsg();
    }
    public Result (int code, String message) {
        this.code = code;
        this.message = message;
    }
    public Result () {
        this.code = 0;
        this.message = "success";
    }

    public Result(Object data) {
        this.code = 0;
        this.message = "success";
        this.data = data;
    }

}
