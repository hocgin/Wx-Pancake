package in.hocg.defaults.base.body;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hocgin on 16-12-21.
 */
public class Page implements Serializable {
	// 每页显示数量
	private int size;
	// 总记录数
	private long total;
	// 当前页
	private int current;
	
	private List<?> result;
	
	public Page(int size, long total, int current, List<?> result) {
		this.size = size;
		this.total = total;
		this.current = current;
		this.result = result;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public long getTotal() {
		return total;
	}
	
	public void setTotal(long total) {
		this.total = total;
	}
	
	public int getCurrent() {
		return current;
	}
	
	public void setCurrent(int current) {
		this.current = current;
	}
	
	public List<?> getResult() {
		return result;
	}
	
	public void setResult(List<Object> result) {
		this.result = result;
	}
}
