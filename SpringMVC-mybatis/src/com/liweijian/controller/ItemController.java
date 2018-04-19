package com.liweijian.controller;


import com.liweijian.controller.exception.MesException;
import com.liweijian.pojo.Items;
import com.liweijian.pojo.QueryVo;
import com.liweijian.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ItemController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/itemList.action")
    public ModelAndView selectItemList() throws MesException {

        List<Items> list = itemsService.selectItemsList();
//        Integer i = 1 / 0;
//        if (null == null){
//            产生已知异常
//            throw new MesException("已知错误！");
//        }

        /*// 创建页面需要显示的商品数据
        List<Items> list = new ArrayList<>();
        list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
        list.add(new Items(2, "2华为 荣耀8", 2399f, new Date(), "质量好！2"));
        list.add(new Items(3, "3华为 荣耀8", 2399f, new Date(), "质量好！3"));
        list.add(new Items(4, "4华为 荣耀8", 2399f, new Date(), "质量好！4"));
        list.add(new Items(5, "5华为 荣耀8", 2399f, new Date(), "质量好！5"));
        list.add(new Items(6, "6华为 荣耀8", 2399f, new Date(), "质量好！6"));*/

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("itemList");    //在springmvc.xml中已经配置了视图解析器的前缀和后缀，因此只需要这样写就行了
//        modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");
        modelAndView.addObject("itemList",list);
        return modelAndView;
    }

    @RequestMapping("/itemEdit.action")
    public ModelAndView itemEdit(Integer id, Model model){

        ModelAndView modelAndView = new ModelAndView();

        Items items = itemsService.selectItemsById(id);
        modelAndView.addObject("item",items);
        modelAndView.setViewName("editItem"); //转跳路径
        return modelAndView;
    }

    @RequestMapping("/updateitem.action")
//    public ModelAndView updateItem(Items items, Model model){
    public String updateItem(QueryVo vo, MultipartFile pictureFile) throws IOException {

        //生成文件名
        String picName = UUID.randomUUID().toString();
        //获取文件名
        String filename = pictureFile.getOriginalFilename();
        //后缀名
        String extName = filename.substring(filename.lastIndexOf("."));
        pictureFile.transferTo(new File("F:\\Code\\upload\\" + picName+ extName));
        vo.getItems().setPic(picName+extName);

        itemsService.updateItem(vo.getItems());
        return "forward:/itemEdit.action?id="+vo.getItems().getId();  //重定向
    }

    //测试绑定数组。可以直接写在包装类里，也可以写在形参上
    @RequestMapping("/deleteitem.action")
//    public ModelAndView updateItem(Items items, Model model){
    public ModelAndView deleteItem(QueryVo vo){

        ModelAndView modelAndView = new ModelAndView();
        System.out.println(vo.getIds());

        modelAndView.setViewName("itemList"); //转跳路径
        return modelAndView;
    }

    /**
     * 测试json数据交互
     * */
    @RequestMapping("/testJson.action")
    public @ResponseBody Items testJson(@RequestBody Items items){
        return items;
    }

    //去登陆的页面
    @RequestMapping(value = "/login.action",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    public String login(String username
            ,HttpSession httpSession){
        httpSession.setAttribute("username", username);
        return "redirect:/itemList.action";
    }

}
