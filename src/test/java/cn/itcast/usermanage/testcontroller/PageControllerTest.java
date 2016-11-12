package cn.itcast.usermanage.testcontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cn.itcast.usermanage.controller.HomeController;
import cn.itcast.usermanage.controller.PageController;

public class PageControllerTest {

    @Test
    public void testPage()throws Exception{
        PageController controller = new PageController();
       MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();  //搭建MockMvc
       mockMvc.perform(get("/page/users")).andExpect(view().name("user"));
    }
    
    @Test
    public void testHome() throws Exception{
        HomeController homeController = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build(); //构建mockMvc
        mockMvc.perform(MockMvcRequestBuilders.get("/"))                //对 “/”执行get请求
                .andExpect(MockMvcResultMatchers.view().name("home"));  //预测得到home视图
        
    }
}
