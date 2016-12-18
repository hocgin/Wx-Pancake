package in.hocg.app.utils;

/**
 * Created by hocgin on 16-12-17.
 */
public class Return {
	private Integer code;
	private String message;
	private Object result;
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getResult() {
		return result;
	}
	
	public void setResult(Object result) {
		this.result = result;
	}
	
	/**
	 * 成功实体
	 * @param message
	 * @param result
	 * @return
	 */
	public static Return success(String message, Object result) {
		Return aReturn = new Return();
		aReturn.setCode(200);
		aReturn.setMessage(message);
		aReturn.setResult(result);
		return aReturn;
	}
	
	public static Return success(Object result) {
		return success("success", result);
	}
	
	
	/**
	 * 失败实体
	 * @param code
	 * @param message
	 * @param result
	 * @return
	 */
	public static Return fail(Integer code, String message, Object result) {
		Return aReturn = new Return();
		aReturn.setCode(code);
		aReturn.setMessage(message);
		aReturn.setResult(result);
		return aReturn;
	}
	
	public static Return fail(Integer code, String message) {
		return fail(code, message, null);
	}
}
