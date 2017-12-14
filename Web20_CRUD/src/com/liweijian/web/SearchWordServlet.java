package com.liweijian.web;

import com.google.gson.Gson;
import com.liweijian.service.SearchWordService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 16:11 2017/12/13 0013
 */
@WebServlet(name = "SearchWordServlet")
public class SearchWordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String word = request.getParameter("word");
        List<Object> productWord = null;

        SearchWordService service = new SearchWordService();
        try {
            productWord = service.findAllProductFroWord(word);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //使用jsonlib工具将List转换成json
        //JSONArray jsonArray = JSONArray.fromObject(productWord);
        //String string = jsonArray.toString();

        //使用Gson将List转换成json
        Gson gson = new Gson();
        String json = gson.toJson(productWord);
//        System.out.println(json);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(json);

    }
}
