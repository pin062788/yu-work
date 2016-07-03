package yuweixiang.first.test;

import org.junit.Test;
import yuweixiang.first.dal.daointerface.OrderDOMapper;
import yuweixiang.first.dal.dataobject.OrderDO;

import javax.annotation.Resource;

/**
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.test, v 0.1 16/5/14 下午11:54 yuweixiang Exp $
 */
public class DBTest extends BaseTest {

    @Resource
    OrderDOMapper orderDOMapper;

    @Test
    public void  testQueryOrder(){
        try {
            System.out.println("here");
            OrderDO orderDO = orderDOMapper.selectByOrderId("12344");
            System.out.println(orderDO.getOrderId());
        }catch (Exception e){
            System.out.println("here");
            System.out.println(e);;
        }
    }
}
