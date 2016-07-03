package yuweixiang.first.modle.vo;

import java.io.Serializable;

/**
 * 用户收货地址展示对象
 *
 * @author yuweixiang
 * @version $ Id: UserAddressVO.java, v 0.1 16/5/16 下午6:38 yuweixiang Exp $
 */
public class UserAddressVO implements Serializable{

    /** 序列号 */
    private static final long serialVersionUID = -7388436301354567153L;

    private Long id;

    private String country;

    private String province;

    private String city;

    private String region;

    private String detail;

    private String name;

    private String zipCode;

    private String cellphone;

    private String telephone;

    private String certNo;

    private int isDefault;

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public UserAddressVO setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter method for property <tt>country</tt>.
     *
     * @return property value of country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter method for property <tt>country</tt>.
     *
     * @param country value to be assigned to property country
     */
    public UserAddressVO setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Getter method for property <tt>province</tt>.
     *
     * @return property value of province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Setter method for property <tt>province</tt>.
     *
     * @param province value to be assigned to property province
     */
    public UserAddressVO setProvince(String province) {
        this.province = province;
        return this;
    }

    /**
     * Getter method for property <tt>city</tt>.
     *
     * @return property value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter method for property <tt>city</tt>.
     *
     * @param city value to be assigned to property city
     */
    public UserAddressVO setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Getter method for property <tt>region</tt>.
     *
     * @return property value of region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Setter method for property <tt>region</tt>.
     *
     * @param region value to be assigned to property region
     */
    public UserAddressVO setRegion(String region) {
        this.region = region;
        return this;
    }

    /**
     * Getter method for property <tt>detail</tt>.
     *
     * @return property value of detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Setter method for property <tt>detail</tt>.
     *
     * @param detail value to be assigned to property detail
     */
    public UserAddressVO setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public UserAddressVO setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter method for property <tt>zipCode</tt>.
     *
     * @return property value of zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Setter method for property <tt>zipCode</tt>.
     *
     * @param zipCode value to be assigned to property zipCode
     */
    public UserAddressVO setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    /**
     * Getter method for property <tt>cellphone</tt>.
     *
     * @return property value of cellphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * Setter method for property <tt>cellphone</tt>.
     *
     * @param cellphone value to be assigned to property cellphone
     */
    public UserAddressVO setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    /**
     * Getter method for property <tt>telephone</tt>.
     *
     * @return property value of telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Setter method for property <tt>telephone</tt>.
     *
     * @param telephone value to be assigned to property telephone
     */
    public UserAddressVO setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    /**
     * Getter method for property <tt>certNo</tt>.
     *
     * @return property value of certNo
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * Setter method for property <tt>certNo</tt>.
     *
     * @param certNo value to be assigned to property certNo
     */
    public UserAddressVO setCertNo(String certNo) {
        this.certNo = certNo;
        return this;
    }

    /**
     * Getter method for property <tt>isDefault</tt>.
     *
     * @return property value of isDefault
     */
    public int getIsDefault() {
        return isDefault;
    }

    /**
     * Setter method for property <tt>isDefault</tt>.
     *
     * @param isDefault value to be assigned to property isDefault
     */
    public UserAddressVO setIsDefault(int isDefault) {
        this.isDefault = isDefault;
        return this;
    }
}
