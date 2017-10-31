package com.grass.exception;

import com.grass.entity.ErrorMsg;
import com.grass.service.ErrorMsgService;
import com.grass.utils.GsonQuick;
import com.grass.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huchao on 2017/1/12.
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {

    @Autowired
    private ErrorMsgService errorMsgService;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            response.setCharacterEncoding("UTF-8"); //设置编码格式
            response.setContentType("text/html");   //设置数据格式
            PrintWriter writer = response.getWriter();
            Map<String, Object> returnData = new HashMap<String, Object>();
            //判断错误类型
            if (ex instanceof BusinessException) {
                BusinessException businessException = (BusinessException) ex;
                String code = businessException.getCode();

                ErrorMsg errorMsg = errorMsgService.findErrorByCode(code);
                request.setAttribute("data", code+","+errorMsg.getErrorMessage());
                returnData.put("returnCode", code);
                if (!Tools.getStringIsNull(errorMsg.getErrorMessageClient())) {
                    returnData.put("returnMessage", errorMsg.getErrorMessageClient());
                } else {
                    returnData.put("returnMessage", errorMsg.getErrorMessage());
                }

            }else {
                String errorMsgData ;
                ErrorMsg errorMsg = errorMsgService.findErrorByCode("EG-S-999");
                StringWriter sw=new StringWriter();
                PrintWriter pw=new PrintWriter(sw);
                ex.printStackTrace(pw);
                errorMsgData = sw.toString();
                request.setAttribute("returnMessage", errorMsgData);
                pw.close();
                sw.close();
                returnData.put("returnCode", "EHG-S-999");
                if (!Tools.getStringIsNull(errorMsg.getErrorMessageClient())) {
                    returnData.put("returnMessage", errorMsg.getErrorMessageClient());
                } else {
                    returnData.put("returnMessage", errorMsg.getErrorMessage());
                }
            }
            writer.print(GsonQuick.toJsonFromMap(returnData));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
