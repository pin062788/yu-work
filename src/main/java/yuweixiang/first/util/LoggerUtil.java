package yuweixiang.first.util;

import org.slf4j.Logger;

import java.text.MessageFormat;

/**
 * <p>模版方式日志打印工具</p>
 * 
 * @author xiaochuan.zhang
 * @version $Id: LoggerUtil.java, v 0.1 2014-2-13 下午10:05:21 xiaochuan.zhang Exp $
 */
public final class LoggerUtil {

    /**
     * <p>生成调试级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成debug级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void debug(Logger logger, String template, Object... parameters) {
        if (logger.isDebugEnabled()) {
            logger.debug(MessageFormat.format(template, parameters));
        }
    }

    /**
     * <p>生成调试级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成debug级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * 
     * @param e             异常对象
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void debug(Throwable e, Logger logger, String template, Object... parameters) {
        if (logger.isDebugEnabled()) {
            logger.debug(MessageFormat.format(template, parameters), e);
        }
    }

    /**
     * <p>生成通知级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成info级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void info(Logger logger, String template, Object... parameters) {
        if (logger.isInfoEnabled()) {
            logger.info(MessageFormat.format(template, parameters));
        }
    }

    /**
     * <p>生成通知级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成info级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * 
     * @param e             异常对象
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void info(Throwable e, Logger logger, String template, Object... parameters) {
        if (logger.isInfoEnabled()) {
            logger.info(MessageFormat.format(template, parameters), e);
        }
    }

    /**
     * <p>生成警告级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成warn级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void warn(Logger logger, String template, Object... parameters) {
        logger.warn(MessageFormat.format(template, parameters));
    }

    /**
     * <p>生成警告级别日志.</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成warn级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void warning(Logger logger, String template, Object... parameters) {
        logger.warn(MessageFormat.format(template, parameters));
    }

    /**
     * <p>生成警告级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成warn级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * 
     * @param e             异常对象
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void warn(Throwable e, Logger logger, String template, Object... parameters) {
        logger.warn(MessageFormat.format(template, parameters), e);
    }

    /**
     * <p>生成错误级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成error级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void error(Logger logger, String template, Object... parameters) {
        logger.error(MessageFormat.format(template, parameters));
    }

    /**
     * <p>生成错误级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成error级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     * 
     * @param e             异常对象
     * @param logger        logger引用
     * @param template      带参数的日志模板
     * @param parameters    参数集合
     */
    public static void error(Throwable e, Logger logger, String template, Object... parameters) {
        logger.error(MessageFormat.format(template, parameters), e);
    }

    /**
     * 生成<font color="brown">警告</font>级别日志。<br>
     * <font color="brown">打印monitor日志专用方法，打印其他warn日志，请调用warning方法</font>。
     * 
     * <p>可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费。
     * <p>日志描述信息中不要出现英文的逗号","，避免在monitor分割中出现问题</p>
     *
     * @param logger  日志打印对象
     * @param desc    日志描述信息
     * @param bizNo 业务号
     * @param flag 是否需要报警标志
     * @param obj     任意个要输出到日志的参数[可空]
     */
    public static void warn(Logger logger, String desc, String bizNo, String flag, Object... obj) {

        logger.warn(getLogString(desc, bizNo, flag, obj));
    }

    /**
     * 生成输出到日志的字符串。
     *
     * @param desc    日志描述信息
     * @param bizNo 业务号
     * @param flag 是否需要报警标志
     * @param obj     任意个要输出到日志的参数[可空]
     * @return        输出到日志的字符串
     */
    private static String getLogString(String desc, String bizNo, String flag, Object... obj) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(desc).append("[");

        //如果传入交易号为空，则从上下文中获取
        if (bizNo == null || bizNo.equals("")) {
            stringBuilder.append("-");
        } else {
            stringBuilder.append(bizNo);
        }

        stringBuilder.append(",");
        if (flag == null || flag.equals("")) {
            stringBuilder.append("-");
        } else {
            stringBuilder.append(flag);
        }

        if (obj != null && obj.length > 0) {

            stringBuilder.append(",");
            stringBuilder.append("(");
            for (int i = 0; i < obj.length; i++) {

                stringBuilder.append(obj[i]);
                if (obj.length - 1 != i) {

                    stringBuilder.append(",");
                }
            }
            stringBuilder.append(")");
        }
        stringBuilder.append("].");

        return stringBuilder.toString();
    }
}
