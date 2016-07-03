package yuweixiang.first.test;

import yuweixiang.first.spider.DownTool;

/**
 * 解析页面测试类
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.test, v 0.1 16/5/13 下午10:31 yuweixiang Exp $
 */
public class TestExplainHtml {

    public static void main(String args[]){
        String str = " <title>苹果园-iPhone6 plus/iPhone5s/iPhone5游戏[软件]_iPad mini/iPad游戏[软件]苹果官网下载</title>\n" +
                "    <meta name=\"keywords\" content=\"iPhone6游戏,iPhone5s游戏,iPhone5游戏,iPad游戏下载,iPhone软件下载\" />";
        DownTool downTool = new DownTool();
//        System.out.println(downTool.buildKeyWords(downTool.buildContent(str,"keywords")));
    }
}
