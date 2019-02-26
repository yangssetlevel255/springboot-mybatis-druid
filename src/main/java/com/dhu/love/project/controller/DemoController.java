package com.dhu.love.project.controller;

        import com.dhu.love.project.service.DemoService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.util.Map;

@Controller
@RequestMapping(value = "getLove")

public class DemoController {

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "dosomething",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void demo(HttpServletRequest request, HttpServletResponse response, @RequestParam("userId") String userId){
        Map map =demoService.searchLove(userId);
        System.out.print(map.toString());
    }

}
