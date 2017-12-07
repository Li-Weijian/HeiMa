package liweijian.jsp.domain;

/**
 * @Author:Liweijian
 * @Description: product java bean
 * @Date:Create in 21:43 2017/12/3 0003
 */
public class Product {

  /*   `pid` varchar(32) NOT NULL,
  `pname` varchar(50) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
            `shop_price` double DEFAULT NULL,
            `pimage` varchar(200) DEFAULT NULL,
  `pdate` date DEFAULT NULL,
            `is_hot` int(11) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `pflag` int(11) DEFAULT NULL,
  `cid` varchar(32) DEFAULT NULL,*/


  private String pid;
  private String pname;
  private double market_price;
  private double shop_price;
  private String pimage;
  private String pdate;
  private boolean is_hot;
  private String pdesc;
  private String pflag;
  private String cid;

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setMarket_price(double market_price) {
        this.market_price = market_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public void setIs_hot(boolean is_hot) {
        this.is_hot = is_hot;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public void setPflag(String pflag) {
        this.pflag = pflag;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public double getMarket_price() {
        return market_price;
    }

    public double getShop_price() {
        return shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public String getPdate() {
        return pdate;
    }

    public boolean isIs_hot() {
        return is_hot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public String getPflag() {
        return pflag;
    }

    public String getCid() {
        return cid;
    }
}
