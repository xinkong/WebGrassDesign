package com.grass.service.impl;

import com.grass.entity.ErrorMsg;
import com.grass.mapper.ErrorMsgMapper;
import com.grass.service.ErrorMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huchao on 2017/10/27.
 */
@Service
public class ErrorMsgServiceImpl implements ErrorMsgService {

    @Autowired
    private ErrorMsgMapper errorMsgMapper;

    @Override
    public ErrorMsg findErrorByCode(String code) {
        ErrorMsg errorMsgByCode = errorMsgMapper.findErrorMsgByCode(code);
        if(errorMsgByCode == null){
            errorMsgByCode.setErrorCode("EG-0-000");
            errorMsgByCode.setErrorMessage("数据库中未找到对应的编码");
        }
        return errorMsgByCode;
    }
}
