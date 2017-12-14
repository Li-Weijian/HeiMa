package com.liweijian.service;

import com.liweijian.dao.SearchWordDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 16:14 2017/12/13 0013
 */
public class SearchWordService {
    public List<Object> findAllProductFroWord(String word) throws SQLException {
        SearchWordDao dao = new SearchWordDao();
        return dao.findAllProductFroWord(word);
    }
}
