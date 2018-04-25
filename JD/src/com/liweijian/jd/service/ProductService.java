package com.liweijian.jd.service;

import com.liweijian.jd.pojo.ProductModel;
import org.apache.solr.client.solrj.SolrServerException;

import java.util.List;

public interface ProductService {

    public List<ProductModel> getResultModelBySolr(String queryString, String catalog_name, String price, String sort) throws SolrServerException;



}
