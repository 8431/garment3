package com.dlf.garment3.util;

import io.swagger.annotations.ApiModelProperty;

/**
* <p>Title: TokenModel</p>  

* <p>Description: Token的Model类，可以增加字段提高安全性，例如时间戳、url签名</p>  

* @author sff  

* @date 2018年2月27日
 */
public class TokenModel {

    //用户id
	 @ApiModelProperty(value = "id")
    private String userId;

    //随机生成的uuid
	 @ApiModelProperty(value = "token")
    private String token;

    public TokenModel(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
