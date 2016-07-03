/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package yuweixiang.first.template;

import org.springframework.transaction.annotation.Transactional;
import yuweixiang.first.enums.HelloWorldResultCodeEnum;
import yuweixiang.first.exception.SearchException;
import yuweixiang.first.result.BaseResult;


/**
 * 服务模板
 *
 * @author wb-yuweixiang
 * @version $Id: HelloWorldServiceTemplate.java, v 0.1 2014-9-12 下午05:25:40 wb-yuweixiang Exp $
 */
public class HelloWorldServiceTemplate {

    /** 事务模板 */
//    private TransactionTemplate helloWdTransactionTemplate;

    /**
     * 带事务的模板处理方法。
     *
     * @param result          结果集
     * @param processCallback 动作回调
     */
    @Transactional
    public void processWithNoTrasaction(BaseResult result, final BusinessProcess processCallback) {

        //        Profiler.enter("[" + actionType.getDesc() + "]-开始业务处理,request=" + request);

        try {


            // 设置上下文
            //                    OatpContextHolder.clear();
            //                    OatpContextHolder.set(new OatpContext(extraDAO.getSysdate(), actionType));

            // 业务处理
            processCallback.doProcess();

        } catch (SearchException e) {
            // 构建错误结果
            buildErrResult(result, e);
        } catch (Throwable e) {

            // 构建默认错误结果
            //            buildDefaultErrResult(result, e);
        } finally {
            //            Profiler.release();
            //            OatpContextHolder.clear();
        }
    }

    /**
     * 业务处理模板。
     *
     * @author anorld.zhangm
     * @version $Id: BusinessProcess.java, v 0.1 2014-5-26 下午3:20:50 老男人 Exp $
     */
    public interface BusinessProcess {

        /**
         * 执行业务处理
         */
        public void doProcess();
    }

    /**
     * 构建异常结果。
     *
     * @param result 返回结果
     * @param e      业务异常对象
     */
    protected void buildErrResult(BaseResult result, SearchException e) {
        result.setSuccess(false);
        result.setResultCode(e.getErrorCode());
        result.setResultMessage(e.getMessage());
    }

    /**
     * 构建正确结果。
     *
     * @param result 返回结果
     */
    protected void buildSuccessResult(BaseResult result) {
        result.setSuccess(true);
        result.setResultCode(HelloWorldResultCodeEnum.SUCCESS.getCode());
        result.setResultMessage(HelloWorldResultCodeEnum.SUCCESS.getDesc());
    }

    /**
     * Setter method for property <tt>helloWdTransactionTemplate</tt>.
     *
     * @param helloWdTransactionTemplate value to be assigned to property helloWdTransactionTemplate
     */
//    public void setHelloWdTransactionTemplate(TransactionTemplate helloWdTransactionTemplate) {
//        this.helloWdTransactionTemplate = helloWdTransactionTemplate;
//    }
}
