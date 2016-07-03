package yuweixiang.first.controller.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import yuweixiang.first.constants.SpringDemoConstants;
import yuweixiang.first.controller.BaseController;
import yuweixiang.first.controller.HelloWorldController;
import yuweixiang.first.enums.ResultCodeEnum;
import yuweixiang.first.exception.SearchException;
import yuweixiang.first.modle.SearchRequestForm;
import yuweixiang.first.result.search.SearchResult;
import yuweixiang.first.service.SearchService;
import yuweixiang.first.validation.ValidateResult;
import yuweixiang.first.validation.ValidateService;

/**
 * 搜索控制器
 *
 * Created by yuweixiang on 16/1/13.
 */
@Controller
public class SearchController extends BaseController {

    /** 日志 */
    Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    /** 你好世界服务 */
    @Autowired
    private SearchService searchService;

    @Autowired
    private ValidateService validateService;

    /**
     * 获取姓名
     * @param searchRequestForm 请求表单
     * @param model
     * @return 字符串
     */
    @RequestMapping(value = "/search.htm")
    public String doGet(SearchRequestForm searchRequestForm, ModelMap model) {
        LOGGER.info("requestForm:"+searchRequestForm);

        // 1. 参数校验
        ValidateResult validateResult = validateService.validate(searchRequestForm);
        if(!validateResult.isSuccess()){
            return SpringDemoConstants.INDEX_VM;
        }

        // 2. 获取用户名
        SearchResult result = searchService.search(searchRequestForm.getKeyWord());
        if (result == null || !result.isSuccess()) {
            throw new SearchException(ResultCodeEnum.SYSTEM_ERROR, result.getResultMessage());
        }

        // 3. 组装返回数据
        model.put("searchResult", result);
        model.put("keyWord",searchRequestForm.getKeyWord());

        LOGGER.info("result:"+result);

        // 4. 跳转
        return SpringDemoConstants.SEARCH;
    }

    /**
     * 获取惊喜
     *
     * @param model 模型
     * @return 返回跳转页面
     */
    @RequestMapping(value = "/seeSurprise.htm")
    public String getSurprise(ModelMap model) {
        model.put("supriceMessage", "surprise!!!!you got 10000000RMB,getIt!");
        return SpringDemoConstants.HELLO_WORLD;
    }
}
