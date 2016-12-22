package in.hocg.defaults.base.params;

import java.io.Serializable;
import java.util.HashMap;
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
	
	/**
	 * 分页属性
	 */
	private PagingParams pagingParams;
	
	/**
	 * 排序
	 */
	private Map<String, String> sort = new HashMap<>();
	
	public PagingParams getPaging() {
		return pagingParams;
	}
	
	public void setPaging(PagingParams pagingParams) {
		this.pagingParams = pagingParams;
	}
	
	public Map<String, String> getSort() {
		return sort;
	}
	
	public void setSort(Map<String, String> sort) {
		this.sort = sort;
	}
}
