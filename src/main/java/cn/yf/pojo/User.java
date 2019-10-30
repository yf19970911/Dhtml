package cn.yf.pojo;

//用户实体类
public class User {

    //用户代码
    private String yhdm;
    //用户姓名
    private String yhxm;
    //用户部门
    private String yhbm;
    //标识
    private String bs;
    //是否禁用
    private String sfjy;
    //排序号
    private Integer pxh;

    public User() {
    }

    public User(String yhdm, String yhxm, String yhbm, String bs, String sfjy, Integer pxh) {
        this.yhdm = yhdm;
        this.yhxm = yhxm;
        this.yhbm = yhbm;
        this.bs = bs;
        this.sfjy = sfjy;
        this.pxh = pxh;
    }

    public String getYhdm() {
        return yhdm;
    }

    public void setYhdm(String yhdm) {
        this.yhdm = yhdm;
    }

    public String getYhxm() {
        return yhxm;
    }

    public void setYhxm(String yhxm) {
        this.yhxm = yhxm;
    }

    public String getYhbm() {
        return yhbm;
    }

    public void setYhbm(String yhbm) {
        this.yhbm = yhbm;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getSfjy() {
        return sfjy;
    }

    public void setSfjy(String sfjy) {
        this.sfjy = sfjy;
    }

    public Integer getPxh() {
        return pxh;
    }

    public void setPxh(Integer pxh) {
        this.pxh = pxh;
    }

    @Override
    public String toString() {
        return "User{" +
                "yhdm='" + yhdm + '\'' +
                ", yhxm='" + yhxm + '\'' +
                ", yhbm='" + yhbm + '\'' +
                ", bs='" + bs + '\'' +
                ", sfjy='" + sfjy + '\'' +
                ", pxh=" + pxh +
                '}';
    }
}
