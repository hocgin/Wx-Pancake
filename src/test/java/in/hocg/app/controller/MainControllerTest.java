package in.hocg.app.controller;

import org.junit.runner.RunWith;

/**
 * Created by hocgin on 16-12-20.
 * Junit 基础类,加载环境
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-*.xml"})
public class MainControllerTest {
	
	@org.junit.Test
	public void e() throws Exception {
		
	}
	
}