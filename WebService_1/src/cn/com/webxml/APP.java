package cn.com.webxml;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 13:01 2018/3/19 0019
 */
public class APP {

    public static void main(String[] args){

        //此处new 的是wsdl中的<wsdl:service name="TraditionalSimplifiedWebService">类
        TraditionalSimplifiedWebService ss = new TraditionalSimplifiedWebService();
        //获得代理对象
        TraditionalSimplifiedWebServiceSoap proxy = ss.getTraditionalSimplifiedWebServiceSoap();
        String s = proxy.toTraditionalChinese("中国");
        System.out.println("中国繁体字：" + s);

    }


}
