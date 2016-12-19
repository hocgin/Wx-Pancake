package in.hocg.app.handler;

import com.google.gson.Gson;
import in.hocg.utils.Logs;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import org.slf4j.Logger;

/**
 * Created by hocgin on 16-12-17.
 */
public abstract class AbstractHandler implements WxMpMessageHandler {
	protected Logger logger = Logs.get();
	protected final Gson gson = new Gson();
}