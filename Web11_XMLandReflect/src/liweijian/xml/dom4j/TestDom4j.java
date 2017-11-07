package liweijian.xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description: 通过dom4j解析xml文件并获取相关节点信息
 *               需要导入dom4j包（lib下的jar）
 * @Date:Create in 14:47 2017/11/7 0007
 */
public class TestDom4j {

    @Test
    public void testReadWebXML(){

        try {
            //1.获取解析器
            SAXReader saxReader = new SAXReader();

            //2.读取xml文件
            Document doc = saxReader.read("D:\\java\\workspace\\Web11_XML\\src\\liweijian\\xml\\dom4j\\web.xml");

            //3.获取根节点
            Element rootElement = doc.getRootElement();

            //4.获取根节点下的所有节点
            List<Element> elements = rootElement.elements();

            //5.遍历所有节点
            for (Element element: elements) {
                //6.判断是否为“servlet”节点
                if (element.getName().equals("servlet")){
                    Element servlet_name = element.element("servlet-name");
                    Element servlet_class = element.element("servlet-class");
                    System.out.println(servlet_name.getText());
                    System.out.println(servlet_class.getText());

                }
            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }




}
