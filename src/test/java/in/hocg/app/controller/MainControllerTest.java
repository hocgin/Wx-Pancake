package in.hocg.app.controller;

import in.hocg.app.ResourcesConfig;
import in.hocg.app.config.MenuConfig;
import in.hocg.app.config.Wx1Config;
import in.hocg.plugin.task.TaskConfig;
import in.hocg.test.SpringTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by hocgin on 16-12-20.
 * Junit 基础类,加载环境
 */
@ContextConfiguration(classes = {
		ResourcesConfig.class, TaskConfig.class, Wx1Config.class, MenuConfig.class
})
@ActiveProfiles("test")
public class MainControllerTest extends SpringTest {
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void e() throws Exception {
	}
	
	@Test
	public void paging() throws Exception {
		client().perform((get("/index")
				.param("q", "admin")
				.param("password", "1")))
//				.andExpect(status().isOk())
				.andDo(print());
	}
}