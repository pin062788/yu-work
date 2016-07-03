package yuweixiang.first.modle;

import org.springmodules.validation.bean.conf.loader.annotation.handler.MaxLength;
import yuweixiang.first.validation.annotation.Required;
/**
 * 搜索请求参数请求表格
 *
 * Created by yuweixiang on 16/1/13.
 */
public class SearchRequestForm extends BaseForm{

    /** 序列号 */
    private static final long serialVersionUID = -1073504461591955753L;

    /** 关键字 */
    @Required(errorCode = "KEYWORD_IS_NULL", message = "keyWord is empty!")
    @MaxLength(value = 64, errorCode = "KEYWORD_ILLEGAL_LENGTH", message = "关键字长度错误")
    //    @Number(lessThanOrEqualTo = 9999999, greaterThanOrEqualTo = 0)
    private String            keyWord;

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getKeyWord() {
        return keyWord;
    }
}
