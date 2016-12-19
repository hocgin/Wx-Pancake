package in.hocg.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hocgin on 16-12-19.
 */
public class Logs {
	/**
	 * 返回以调用者的类命名的Log,是获取Log对象最简单的方法!
	 */
	public static Logger get() {
		StackTraceElement[] sts = Thread.currentThread().getStackTrace();
		return LoggerFactory.getLogger(sts[2].getClassName());
	}
}
