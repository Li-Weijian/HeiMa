package com.liweijian.jd.controller;

import com.liweijian.jd.pojo.ProductModel;
import com.liweijian.jd.service.ProductService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "list.action")
    public String productList(String queryString, String catalog_name, String price, String sort, Model model) throws SolrServerException {

        List<ProductModel> productModelList = productService.getResultModelBySolr(queryString, catalog_name, price, sort);
        model.addAttribute("productModels",productModelList);
        model.addAttribute("queryString",queryString);
        model.addAttribute("catalog_name",catalog_name);
        model.addAttribute("price",price);
        model.addAttribute("sort",sort);

        return "product_list";
    }




}
