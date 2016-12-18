package in.hocg.defaults.utils;

import com.google.gson.Gson;

/**
 * (๑`灬´๑)
 * Author: hocgin(http://hocg.in)
 * GitHub: https://github.com/hocgin
 * --------------------
 * Created 16-7-9.
 * 生成器, 每个方法都拥有一个返回值
 */
public class Generate {

    private static Gson GSON;
    public static Gson gson() {
        if (GSON == null) {
            synchronized (Generate.class) {
                if (GSON == null) {
                    return GSON = new Gson();
                }
            }
        }
        return GSON;
    }
}
