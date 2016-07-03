package yuweixiang.first.drools;

/**
 * 第一个drools代码
 *
 * @author yuweixiang
 * @version $ Id: FirstDrools.java, v 0.1 16/6/23 上午10:18 yuweixiang Exp $
 */
public class FirstDrools {
    private String name = "";
    private Integer sumprice =0;
    private Integer DiscountPercent=0;;

    public Integer getSumprice() {
        return sumprice;
    }
    public void setSumprice(Integer sumprice) {
        this.sumprice = sumprice;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getDiscountPercent() {
        return DiscountPercent;
    }
    public void setDiscountPercent(Integer DiscountPercent) {
        this.DiscountPercent = DiscountPercent;
    }
}
