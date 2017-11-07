package liweijian.reflect.servlet1;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;

/**
 * @Author:Liweijian
 * @Description: 测试反射
 * @Date:Create in 16:01 2017/11/7 0007
 */
public class TestServlet {


    //常规方式调用类方法
    @Test
    public void testNew(){
        MyServletImp myServletImp = new MyServletImp();
        myServletImp.init();
        myServletImp.service();
        myServletImp.destory();
    }

    //反射调用方法
    @Test
    public void testReflect(){

        String className = "liweijian.reflect.servlet1.MyServletImp";

        try {
            //1.通过类全名获取class字节码文件
            Class clazz = Class.forName(className);

            //2.通过字节码文件新建类实例
            MyServletImp myServletImp = (MyServletImp) clazz.newInstance();

            //3.调用类方法
            myServletImp.init();
            myServletImp.service();
            myServletImp.destory();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    //dom4j解析XML调用方法
    @Test
    public void testDom4j(){

        String className = "";

        try {
            //1.获取加载器
            SAXReader saxReader = new SAXReader();

            //2.读取文件
            Document read = saxReader.read(new File("D:\\java\\workspace\\Web11_XML\\src\\liweijian\\reflect\\servlet1\\web.xml"));

            //3.获取dom根节点
            Element rootElement = read.getRootElement();

            Element servleElement = rootElement.element("servlet");
            className = servleElement.element("servlet-class").getText();

           /* //4.获取根节点下的所有子节点
            List<Element> elements = rootElement.elements();

            //5.遍历所有子节点
            for (Element element : elements) {
                if (element.getName().equals("servlet")){
                    className = element.elementText("servlet-class");
                }
            }*/
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        try {
            //6.通过反射获取class文件字节码
            Class clazz = Class.forName(className);

            //7.通过字节码新建实例对象
            MyServletImp myServletImp = (MyServletImp) clazz.newInstance();

            //8.调用类方法
            myServletImp.init();
            myServletImp.service();
            myServletImp.destory();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }



}
