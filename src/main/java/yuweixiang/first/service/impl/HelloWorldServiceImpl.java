package yuweixiang.first.service.impl;


import yuweixiang.first.result.QueryUserResult;
import yuweixiang.first.service.HelloWorldService;
import yuweixiang.first.template.HelloWorldServiceTemplate;

/**
 * 你好世界服务实现类
 *
 * @author wb-yuweixiang
 * @version $Id: HelloWorldServiceImpl.java, v 0.1 2014-8-21 下午01:52:25 wb-yuweixiang Exp $
 */
public class HelloWorldServiceImpl extends HelloWorldServiceTemplate implements HelloWorldService {

    /** 数据操作类 */
    //    public IbatisUserDAO ibatisUserDAO;

    /**
            * @see org.app.demo.spring.service.HelloWorldService#getNewName(String)
    */
    public QueryUserResult getNewName(final String userId) {

        // 1. 初始化结果集
        final QueryUserResult result = new QueryUserResult();

        // 2. 调用事务查询
        processWithNoTrasaction(result, new BusinessProcess() {

            public void doProcess() {
                // 2.1 查询用户
                //                UserDO userDO = ibatisUserDAO.queryByUserId(userId);
                // 2.2 赋值
                result.setUserName("here");
                // 2.3 构建成功结果
                buildSuccessResult(result);
            }
        });

        // 3. 返回结果
        return result;
    }

    /**
     * Setter method for property <tt>ibatisUserDAO</tt>.
     *
     * @param ibatisUserDAO value to be assigned to property ibatisUserDAO
     */
    //    public void setIbatisUserDAO(IbatisUserDAO ibatisUserDAO) {
    //        this.ibatisUserDAO = ibatisUserDAO;
    //    }
}