package liweijian.reflect.servlet1;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 16:04 2017/11/7 0007
 */
public class MyServletImp implements MyServletInterface{
    @Override
    public void init() {
        System.out.println("哈哈哈哈初始化中....");
    }
    @Override
    public void service() {
        System.out.println("我来为你服务~");
    }

    @Override
    public void destory() {
        System.out.println("我走啦~");
    }
}
