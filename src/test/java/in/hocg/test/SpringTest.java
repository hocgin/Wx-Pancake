package in.hocg.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by hocgin on 16-12-20.
 */
//@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class SpringTest extends BaseTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc client;
	
	// 模拟request,response
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	
	@Before
	public void setUp(){
		request = new MockHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		response = new MockHttpServletResponse();
		this.client = webAppContextSetup(this.wac).build();
	}
	
	public MockMvc client() {
		return client;
	}
	
	public MockHttpServletRequest request() {
		return request;
	}
	
	public MockHttpServletResponse getResponse() {
		return response;
	}
}
