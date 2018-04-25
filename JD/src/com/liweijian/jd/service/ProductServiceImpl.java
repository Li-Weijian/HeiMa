package com.liweijian.jd.service;

import com.liweijian.jd.dao.ProductDao;
import com.liweijian.jd.pojo.ProductModel;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductModel> getResultModelBySolr(String queryString, String catalog_name, String price, String sort) throws SolrServerException {

        List<ProductModel> productModelList = productDao.getResultModelBySolr(queryString, catalog_name, price, sort);

        return productModelList;
    }
}
