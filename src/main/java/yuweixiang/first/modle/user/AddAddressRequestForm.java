package yuweixiang.first.modle.user;

import org.springmodules.validation.bean.conf.loader.annotation.handler.MaxLength;
import yuweixiang.first.modle.BaseForm;
import yuweixiang.first.validation.annotation.Required;

/**
 * 新增收货地址请求表单
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.modle.user, v 0.1 16/5/15 下午11:46 yuweixiang Exp $
 */
public class AddAddressRequestForm extends BaseForm {

    /** 序列号 */
    private static final long serialVersionUID = 4195184360509363010L;

    @Required(errorCode = "USERID_IS_NULL", message = "uderId is empty!")
    @MaxLength(value = 32, errorCode = "USERID_ILLEGAL_LENGTH", message = "用户id长度错误")
    private String userId;

    @Required(errorCode = "COUNTRY_IS_NULL", message = "country is empty!")
    @MaxLength(value = 32, errorCode = "COUNTRY_ILLEGAL_LENGTH", message = "国家长度错误")
    private String country;

    @Required(errorCode = "PROVINCE_IS_NULL", message = "province is empty!")
    @MaxLength(value = 32, errorCode = "PROVINCE_ILLEGAL_LENGTH", message = "省长度错误")
    private String province;

    @Required(errorCode = "CITY_IS_NULL", message = "city is empty!")
    @MaxLength(value = 32, errorCode = "CITY_ILLEGAL_LENGTH", message = "市长度错误")
    private String city;

    @Required(errorCode = "REGION_IS_NULL", message = "region is empty!")
    @MaxLength(value = 32, errorCode = "REGION_ILLEGAL_LENGTH", message = "区长度错误")
    private String region;

    @Required(errorCode = "DETAIL_IS_NULL", message = "detail is empty!")
    @MaxLength(value = 512, errorCode = "DETAIL_ILLEGAL_LENGTH", message = "详细地址长度错误")
    private String detail;

    @Required(errorCode = "NAME_IS_NULL", message = "name is empty!")
    @MaxLength(value = 128, errorCode = "NAME_ILLEGAL_LENGTH", message = "收货人名字长度错误")
    private String name;

    private String zipCode;

    @Required(errorCode = "CELLPHONE_IS_NULL", message = "cellphone is empty!")
    @MaxLength(value = 32, errorCode = "CELLPHONE_ILLEGAL_LENGTH", message = "手机长度错误")
    private String cellphone;

    private String telephone;

    private String certNo;

    private String isDefault;

    /**
     * Getter method for property <tt>userId</tt>.
     *
     * @return property value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for property <tt>userId</tt>.
     *
     * @param userId value to be assigned to property userId
     */
    public AddAddressRequestForm setUserId(String userId) {
        this.userId = userId;
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
    public AddAddressRequestForm setCountry(String country) {
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
    public AddAddressRequestForm setProvince(String province) {
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
    public AddAddressRequestForm setCity(String city) {
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
    public AddAddressRequestForm setRegion(String region) {
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
    public AddAddressRequestForm setDetail(String detail) {
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
    public AddAddressRequestForm setName(String name) {
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
    public AddAddressRequestForm setZipCode(String zipCode) {
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
    public AddAddressRequestForm setCellphone(String cellphone) {
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
    public AddAddressRequestForm setTelephone(String telephone) {
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
    public AddAddressRequestForm setCertNo(String certNo) {
        this.certNo = certNo;
        return this;
    }

    /**
     * Getter method for property <tt>isDefault</tt>.
     *
     * @return property value of isDefault
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * Setter method for property <tt>isDefault</tt>.
     *
     * @param isDefault value to be assigned to property isDefault
     */
    public AddAddressRequestForm setIsDefault(String isDefault) {
        this.isDefault = isDefault;
        return this;
    }
}
