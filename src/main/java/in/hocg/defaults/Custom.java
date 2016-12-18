package in.hocg.defaults;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.getInt;

/**
 * (๑`灬´๑)
 *
 * @author hocgin(admin@hocg.in)
 *         --------------------
 *         Created 16-8-24.
 */
public class Custom {

    public interface RequestParams {
         String JUMP = "jump"; // 回跳参数
    }


    /**
     * 错误码翻译器
     * @param code
     * @return
     */
    public static String _message(Integer code) {
        switch (code) {
            case 200:
                return "成功";
            case 500:
                return "失败";
            case 403:
                return "文件格式/内容不符合规定";
            case 404:
                return "查找的数据不存在";
            case 999:
            default:
                return "未知错误";
        }
    }

    public static class Data extends HashMap<String, Object> implements Serializable {
        {
            put("code", 200);
            put("message", "成功");
            put("data", null);
        }

        public Data(Integer code) {
            setCode(code);
        }

        public Data(Map<String, Object> map) {
            super(map);
        }

        public Integer getCode() {
            return getInt("code");
        }

        public Data setCode(Integer code) {
            put("code", code);
            setMessage(_message(code));
            return this;
        }

        public String getMessage() {
            return (String) get("message");
        }

        public Data setMessage(String message) {
            if (message != null) {
                put("message", message);
            }
            return this;
        }

        public Object getData() {
            return get("data");
        }

        public Data setData(Object data) {
            put("data", data);
            return this;
        }

        public static Data NEW(Integer code) {
            return new Data(code);
        }

        public static Data SUCCESS() {
            return new Data(200);
        }
    }
}
