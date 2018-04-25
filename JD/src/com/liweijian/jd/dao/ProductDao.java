package com.liweijian.jd.dao;

import com.liweijian.jd.pojo.ProductModel;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
public class ProductDao {

    @Autowired
    private HttpSolrServer httpSolrServer;

    public List<ProductModel> getResultModelBySolr(String queryString, String catalog_name, String price, String sort) throws SolrServerException {

        SolrQuery query = new SolrQuery();
        //查询
        query.set("q",queryString);
        //过滤条件
        if (null != catalog_name && !"".equals(catalog_name)){
            query.set("fq","product_catalog_name:"+catalog_name);
        }
        if (null != price && !"".equals( price)){
            // 0-9  50 - *
            String[] split = price.split("-");
            query.set("fq","product_price:["+split[0]+" TO " + split[1]+"]");
        }
        //排序条件
        if ("1".equals(sort)){
            query.setSort("product_price",SolrQuery.ORDER.desc);
        }else {
            query.setSort("product_price",SolrQuery.ORDER.asc);
        }
        //分页处理
        query.setStart(0);
        query.setRows(16);
        //默认域
        query.set("df","product_keywords");
        //结果域列表
        query.setFields("id","product_price","product_picture","product_name");
        //高亮
        query.setHighlight(true);
        query.addHighlightField("product_name");
        query.setHighlightSimplePre("<span style = 'color:red'>");
        query.setHighlightSimplePost("</span>");
        //执行查询
        QueryResponse queryResponse = httpSolrServer.query(query);

        //商品总数量
        SolrDocumentList results = queryResponse.getResults();
        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();

        List<ProductModel> productModels = new ArrayList<>();
        for (SolrDocument document:results) {
            ProductModel productModel = new ProductModel();
            productModel.setPid((String) document.get("id"));
            productModel.setCatalog_name((String) document.get("product_catalog_name"));
            productModel.setPicture((String) document.get("product_picture"));
//            productModel.setName(highlighting.get(document.get("id")).get("product_name").get(0));

            Map<String, List<String>> map = highlighting.get((String) document.get("id"));
            List<String> list = map.get("product_name");

            productModel.setName(list.get(0));
//            productModel.setName((String) document.get("product_name"));
            productModels.add(productModel);
        }
        return productModels;

    }
}
