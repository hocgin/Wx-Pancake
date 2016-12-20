package oo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by hocgin on 16-12-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
		"classpath:spring-*.xml"
})
@ComponentScan(basePackages ={"in.hocg"})
public class AppTest {
	MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	
//	@Resource
//	private DictateService dictateService;
	
	@Before
	public void before() {
		//可以对所有的controller来进行测试
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		
		//仅仅对单个Controller来进行测试
//		 mockMvc = MockMvcBuilders.standaloneSetup(new MainController()).build();
	}
	
	@Test
	public void addPerson() {
		try {
			ResultActions resultActions = this.mockMvc.perform(post("/JSON"));
			
			resultActions.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}
	
}
