package in.hocg.defaults.utils;

/**
 * (๑`灬´๑)
 *
 * @author hocgin(admin@hocg.in)
 *         <p>
 *         <p>
 *         <p>
 *         --------------------
 *         Created 16-8-26.
 */
public class LangKit {
    public static <T> T ifNull(T t, T def) {
        return t == null ? def : t;
    }

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }
}
