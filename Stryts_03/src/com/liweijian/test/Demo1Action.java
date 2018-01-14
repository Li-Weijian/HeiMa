package com.liweijian.test;

import com.liwijian.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import ognl.Ognl;
import ognl.OgnlContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Liweijian
 * @Description: 1.测试ognl表达式的基本操作
 * @Date:Create in 23:13 2018/1/14 0014
 */
public class Demo1Action extends ActionSupport{

    @Override
    public String execute() throws Exception {

        //1.准备Root -- Root中可以放置任何对象
        User rootUser = new User("Tom",23);

        //2.准备Context  -- Context实际上是一个Map
        Map<String,User> context = new HashMap<String, User>();
        context.put("name1",new User("jery",22));
        context.put("name2",new User("jack",18));

        //3.将Root和Context放入OgnlContext
        OgnlContext oc = new OgnlContext();
        oc.setRoot(rootUser);
        oc.setValues(context);

        //4.从Root中取出对象
        User u = (User) oc.getRoot();      /*方式一*/
        System.out.println(u.toString());

        String name = (String) Ognl.getValue("name", oc, oc.getRoot());   /*方式二:直接取对象的属性名*/
        Integer age = (Integer) Ognl.getValue("age", oc, oc.getRoot());
        System.out.println(name +":"+age);

        //5.从Context中取出对象
        String n1 = (String) Ognl.getValue("#name1.name", oc, oc.getRoot());
        Integer a1 = (Integer) Ognl.getValue("#name1.age", oc, oc.getRoot());
        System.out.println(n1 +":"+ a1);


        //6.赋值
        String n2 = (String) Ognl.getValue("name='TomCat'", oc, oc.getRoot());
        Integer a2 = (Integer) Ognl.getValue("#name1.age=50", oc, oc.getRoot());
        System.out.println(n2 +":"+a2);

        //7.调用方法
        //String n2 = (String) Ognl.getValue("setName('aaa')", oc, oc.getRoot());

        //8.创建list和map对象
        //String n2 = (String) Ognl.getValue("{'java','c','c++'}", oc, oc.getRoot());
        //String n2 = (String) Ognl.getValue("#{'name': 'Python','age':20},", oc, oc.getRoot());







        return SUCCESS;
    }
}
