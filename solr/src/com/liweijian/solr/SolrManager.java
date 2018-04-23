package com.liweijian.solr;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

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


}
