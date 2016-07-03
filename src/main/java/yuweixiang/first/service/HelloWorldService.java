package yuweixiang.first.service;


import yuweixiang.first.result.QueryUserResult;

/**
 * 你好世界服务接口
 * 
 * @author wb-yuweixiang
 * @version $Id: HelloWorldService.java, v 0.1 2014-8-21 下午01:52:48 wb-yuweixiang Exp $
 */
public interface HelloWorldService {

    /**
     * 获取姓名
     * 
     * @param userId
     * @return 返回查询结果集
     */
    public QueryUserResult getNewName(String userId);

}