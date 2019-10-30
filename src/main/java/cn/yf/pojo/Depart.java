package cn.yf.pojo;

//部门实体类
public class Depart {

    //部门代码
    private String bmdm;
    //部门名称
    private String bmmc;
    //单位代码
    private String dwdm;
    //父级部门代码
    private String fdm;
    //排序号
    private Integer pxh;

    public Depart() {
    }

    public Depart(String bmdm, String bmmc, String dwdm, String fdm, Integer pxh) {
        this.bmdm = bmdm;
        this.bmmc = bmmc;
        this.dwdm = dwdm;
        this.fdm = fdm;
        this.pxh = pxh;
    }

    public String getBmdm() {
        return bmdm;
    }

    public void setBmdm(String bmdm) {
        this.bmdm = bmdm;
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }

    public String getDwdm() {
        return dwdm;
    }

    public void setDwdm(String dwdm) {
        this.dwdm = dwdm;
    }

    public String getFdm() {
        return fdm;
    }

    public void setFdm(String fdm) {
        this.fdm = fdm;
    }

    public Integer getPxh() {
        return pxh;
    }

    public void setPxh(Integer pxh) {
        this.pxh = pxh;
    }

    @Override
    public String toString() {
        return "Depart{" +
                "bmdm='" + bmdm + '\'' +
                ", bmmc='" + bmmc + '\'' +
                ", dwdm='" + dwdm + '\'' +
                ", fdm='" + fdm + '\'' +
                ", pxh=" + pxh +
                '}';
    }
}
