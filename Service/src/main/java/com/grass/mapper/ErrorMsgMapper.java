package com.grass.mapper;

import com.grass.entity.ErrorMsg;

/**
 * Created by huchao on 2017/10/27.
 */
public interface ErrorMsgMapper {

    /**
     * 根据code查找错误消息
     * @param code
     * @return
     */
    ErrorMsg findErrorMsgByCode(String code);

}
