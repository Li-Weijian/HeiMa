package liweijian.jdbc.domain;

/**
 * @Author:Liweijian
 * @Description: java bean -- 配合DBUtils中的BeanHandler进行使用
 *               java bean 规范：属性必须private，必须提供getter和setter
 * @Date:Create in 21:56 2017/11/2 0002
 */
public class User  {

    private int uid;
    private String uname;
    private String upassword;

    @Override
    public String toString() {

        return  getUname() + " : " + getUpassword();
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public int getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public String getUpassword() {
        return upassword;
    }
}
