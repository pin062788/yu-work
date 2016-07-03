package yuweixiang.first.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 领域模型父类
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.domain, v 0.1 16/5/13 下午10:29 yuweixiang Exp $
 */
public class Model {

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
