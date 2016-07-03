package yuweixiang.first.service.impl;

import org.apache.commons.lang.StringUtils;
import yuweixiang.first.dal.daointerface.UserAddressDOMapper;
import yuweixiang.first.dal.daointerface.UserDOMapper;
import yuweixiang.first.dal.dataobject.UserAddressDO;
import yuweixiang.first.dal.dataobject.UserDO;
import yuweixiang.first.enums.ResultCodeEnum;
import yuweixiang.first.exception.SearchException;
import yuweixiang.first.request.user.AddAddressRequest;
import yuweixiang.first.request.user.RegisterRequest;
import yuweixiang.first.result.BaseResult;
import yuweixiang.first.result.user.LoginResult;
import yuweixiang.first.result.user.QueryUserAddressResult;
import yuweixiang.first.result.user.RegisterResult;
import yuweixiang.first.service.UserService;
import yuweixiang.first.template.HelloWorldServiceTemplate;
import yuweixiang.first.util.ConvertUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户服务实现类
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.service.impl, v 0.1 16/5/15 上午12:52 yuweixiang Exp $
 */
public class UserServiceImpl extends HelloWorldServiceTemplate implements UserService {

    /**
     * 用户domapper
     */
    @Resource
    private UserDOMapper userDOMapper;

    /**
     * 用户地址domapper
     */
    @Resource
    private UserAddressDOMapper userAddressDOMapper;

    @Override
    public RegisterResult registerUser(final RegisterRequest request) {
        final RegisterResult result = new RegisterResult();
        processWithNoTrasaction(result, new BusinessProcess() {
            @Override
            public void doProcess() {
                UserDO userDO = new UserDO();
                userDO.setCellphone(request.getCellphone());
                userDO.setEmail(request.getEmail());
                userDO.setNickname(request.getNickName());
                userDO.setPassword(request.getPassword());
                userDO.setGmtCreate(new Date());
                userDO.setGmtModified(new Date());
                userDO.setUserId(getRandomId());
                userDOMapper.insert(userDO);
                result.setUserId(userDO.getUserId());
                buildSuccessResult(result);
            }
        });
        return result;
    }

    @Override
    public LoginResult userLogin(final String cellphone, final String password) {
        final LoginResult result = new LoginResult();
        processWithNoTrasaction(result, new BusinessProcess() {
            @Override
            public void doProcess() {
                UserDO userDO = userDOMapper.selectByCellphone(cellphone);
                if (userDO == null) {
                    throw new SearchException(ResultCodeEnum.ILLEGAL_ARGUMENT, "不存在的用户!");
                }
                if (StringUtils.equals(userDO.getPassword(), password)) {
                    buildSuccessResult(result);
                    result.setUserId(userDO.getUserId());
                }
            }
        });
        return result;
    }

    @Override
    public BaseResult addAddress(final AddAddressRequest request) {
        final BaseResult result = new BaseResult();
        processWithNoTrasaction(result, new BusinessProcess() {
            @Override
            public void doProcess() {
                UserAddressDO userAddressDO = new UserAddressDO();
                userAddressDO.setUserId(request.getUserId());
                userAddressDO.setCellphone(request.getCellphone());
                userAddressDO.setCertNo(request.getCertNo());
                userAddressDO.setCity(request.getCity());
                userAddressDO.setCountry(request.getCountry());
                userAddressDO.setDetail(request.getDetail());
                userAddressDO.setIsDefault(request.getIsDefault());
                userAddressDO.setProvince(request.getProvince());
                userAddressDO.setGmtCreate(new Date());
                userAddressDO.setGmtModified(new Date());
                userAddressDOMapper.insert(userAddressDO);
                buildSuccessResult(result);
            }
        });
        return result;
    }

    @Override
    public QueryUserAddressResult queryUserAddress(final String userId) {
        final QueryUserAddressResult result = new QueryUserAddressResult();
        processWithNoTrasaction(result, new BusinessProcess() {
            @Override
            public void doProcess() {
                List<UserAddressDO> userAddressDOList = userAddressDOMapper.selectByUserId(userId);
                if(userAddressDOList==null || userAddressDOList.isEmpty()){
                    buildSuccessResult(result);
                    return;
                }
                result.setUserAddressVOList(ConvertUtil.convertToUserAddressVOList(userAddressDOList));
                buildSuccessResult(result);
            }
        });
        return result;
    }

    @Override
    public BaseResult setDefaultAddress(final long addressId) {
        final BaseResult result = new BaseResult();
        processWithNoTrasaction(result, new BusinessProcess() {
            @Override
            public void doProcess() {
                UserAddressDO userAddressDO = userAddressDOMapper.selectByPrimaryKey(addressId);
                userAddressDO.setIsDefault(1);
                userAddressDOMapper.updateByPrimaryKey(userAddressDO);
                buildSuccessResult(result);
            }
        });
        return result;
    }

    /**
     * 生成随机数
     *
     * @return 随机数
     */
    private String getRandomId() {
        return String.valueOf((int) (Math.random() * 10000));
    }
}
