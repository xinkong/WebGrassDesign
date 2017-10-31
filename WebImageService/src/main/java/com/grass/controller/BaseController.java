package com.grass.controller;

import com.grass.utils.GsonQuick;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response ) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    public void returnBackData(Object o) throws IOException {
        request.setAttribute("data", o);
        response.setCharacterEncoding("UTF-8"); //设置编码格式
        response.setContentType("text/html");   //设置数据格式
        PrintWriter writer = response.getWriter();
        Map<String, Object> returnData = new HashMap<String, Object>();
        returnData.put("returnCode", "0");
        returnData.put("returnMessage", "执行成功");
        returnData.put("data", o);
        writer.print(GsonQuick.toJsonFromMap(returnData));
        writer.flush();

    }

}