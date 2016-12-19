package in.hocg.app.controller;

import in.hocg.app.bean.DictateBean;
import in.hocg.app.services.DictateService;
import in.hocg.defaults.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hocgin on 16-12-19.
 */
@RequestMapping("/dictate")
@Controller
public class DictateController extends BaseController {
	
	@Autowired
	DictateService dictateService;
	
	@RequestMapping(value = "/i", method = RequestMethod.GET)
	@ResponseBody
	public Object i() {
		DictateBean dictateBean = new DictateBean();
		dictateBean.setCmd("#文章");
		dictateBean.setContent("内容");
		dictateBean.setType("URL");
		dictateService.insert(dictateBean);
		return dictateBean;
	}
}
