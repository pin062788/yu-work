package yuweixiang.first.exception.commonException;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import yuweixiang.first.constants.SpringDemoConstants;
import yuweixiang.first.enums.ResultCodeEnum;
import yuweixiang.first.exception.SearchException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 公共错误处理类
 * 
 * @author wb-yuweixiang
 * @version $Id: CommonExceptionResolver.java, v 0.1 2014-9-11 下午04:23:22 wb-yuweixiang Exp $
 */
public class CommonExceptionResolver implements HandlerExceptionResolver {

    /** 错误跳转 */
    private static final String FORWARD_ERROR = "redirect:/error.htm";

    /**
     * @see HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, Object, Exception)
     */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception e) {

        try {

            // 2. 获取上下文参数
            // 获取交易号，用于页面跳转链接的参数拼接
            //            String tradeNo = OatpexprodContextHolder.getTradeNo();
            //
            //            // 获取购物车链接
            //            String cartUrl = OatpexprodContextHolder.getCartUrl();

            ResultCodeEnum resultCode = null;

            if (e instanceof SearchException) {

                // 输出错误信息
                final SearchException myException = (SearchException) e;

                //将myException系统错误码，转换为给用户显示的错误码
                resultCode = ResultCodeEnum.getByCode(myException.getErrorCode());

            }

            // 7. 构建视图信息
            ModelAndView mv = new ModelAndView(FORWARD_ERROR);
            // 设置 错误信息
            mv.addObject(SpringDemoConstants.ERROR, resultCode.getDesc());

            // 8. 返回模型视图
            return mv;
        } finally {
        }
    }
}
