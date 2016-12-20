package in.hocg.app.controller;

import in.hocg.test.SpringTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by hocgin on 16-12-20.
 * Junit 基础类,加载环境
 */
@ContextConfiguration(locations = {
		"classpath:spring-*.xml"
}
//, classes = {MenuConfig.class, Wx1Config.class, WebConfig.class}
)
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
//		System.out.println(dictateDao);
		client().perform((get("/index")
				.param("q", "admin")
				.param("password", "1")))
//				.andExpect(status().isOk())
				.andDo(print());
	}
}