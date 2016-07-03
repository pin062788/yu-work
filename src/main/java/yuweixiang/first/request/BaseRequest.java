package yuweixiang.first.request;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 请求参数基础类
 * @author yuweixiang
 * @version $ Id: yu-work, v 0.1 16/5/8 下午11:36 yuweixiang Exp $
 */
public class BaseRequest implements Serializable{

    /**
     * 序列号
     */
    private static final long serialVersionUID = 5595308256233434417L;

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
