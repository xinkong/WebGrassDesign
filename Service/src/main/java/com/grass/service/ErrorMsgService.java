package com.grass.service;

import com.grass.entity.ErrorMsg;

/**
 * Created by huchao on 2017/10/27.
 */
public interface ErrorMsgService {

    ErrorMsg findErrorByCode (String code);

}
