package com.liweijian.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import javax.management.Query;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SolrManager {

    //添加
    @Test
    public void testAdd() throws IOException, SolrServerException {
        //单机版
        SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");

        //集群版
        //SolrServer solrServerCould = new CloudSolrServer();

        SolrInputDocument doc = new SolrInputDocument();
        //添加的域名必须在schema.xml中定义，否则添加失败
        doc.addField("id","001");
        doc.addField("name","hahaha");
        solrServer.add(doc);
        solrServer.commit();
    }

    //删除
    @Test
    public void testDelete() throws IOException, SolrServerException {

        SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");
//        根据id删除
//        solrServer.deleteById("001");
//        根据查询删除
        solrServer.deleteByQuery("id:001");
        solrServer.commit();

    }

    //复杂查询
    @Test
    public void testQuery() throws SolrServerException {

        //连接
        SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");
        SolrQuery query = new SolrQuery();
        //查询
        query.set("q","product_name:台灯");
//        query.setQuery("product_name:台灯");
        //过滤条件
        query.set("fq","product_catalog_name:雅致灯饰");
        //排序条件
        query.setSort("product_price",SolrQuery.ORDER.desc);
        //分页处理
        query.setStart(0);
        query.setRows(10);
        //结果域列表
        query.setFields("product_catalog_name","id","product_price","product_picture","product_name");
        //高亮
        query.setHighlight(true);
        query.addHighlightField("product_name");
        query.setHighlightSimplePre("<em style = 'font-color:red'>");
        query.setHighlightSimplePost("</em>");
        //执行查询
        QueryResponse queryResponse = solrServer.query(query);

        //商品总数量
        SolrDocumentList results = queryResponse.getResults();
        System.out.println("总数量："+ results.getNumFound());
        for (SolrDocument document:results) {
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
            List<String> hightName = highlighting.get(document.get("id")).get("product_name");
            System.out.println(hightName);
            System.out.println(document.getFieldValue("id"));
            System.out.println(document.getFieldValue("product_name"));
            System.out.println(document.getFieldValue("product_catalog_name"));
            System.out.println(document.getFieldValue("product_price"));
        }

    }


}
