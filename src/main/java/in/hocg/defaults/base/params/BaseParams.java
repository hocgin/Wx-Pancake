package in.hocg.defaults.base.params;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by hocgin on 16-12-20.
 */
public abstract class BaseParams implements Serializable {
	/**
	 * 升序
	 */
	public final static String ASC = "asc";
	/**
	 * 降序
	 */
	public final static String DESC = "desc";
	
	public Paging paging;
	
	/**
	 * 排序
	 */
	private Map<String, String> order = new LinkedHashMap<String, String>();
}
