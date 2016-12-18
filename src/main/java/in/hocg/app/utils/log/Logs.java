package in.hocg.app.utils.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hocgin on 16-12-17.
 */
public final class Logs {
	/**
	 * 返回以调用者的类命名的Log,是获取Log对象最简单的方法!
	 */
	public static Logger get() {
		StackTraceElement[] sts = Thread.currentThread().getStackTrace();
		return LoggerFactory.getLogger(sts[2].getClassName());
	}
}
