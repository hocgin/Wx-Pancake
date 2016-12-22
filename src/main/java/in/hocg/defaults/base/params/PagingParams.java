package in.hocg.defaults.base.params;

import java.io.Serializable;

/**
 * Created by hocgin on 16-12-20.
 */
public class PagingParams implements Serializable {
	/**
	 * 请求页码, default: 1
	 */
	private Integer page = 1;
	/**
	 * 每页条数, default: 10
	 */
	private Integer size = 10;
	
	public int getPage() {
		return page == null || page < 1? 1: page;
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public int getSize() {
		return size == null || size < 1? 10: size;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}
	
	
}
