package cn.ximcloud.chatonline.chatonline.controller;

import cn.ximcloud.chatonline.chatonline.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by IntelliJ IDEA.
 * User: wzard
 * Date: 2018-03-29
 * Time: 15:04
 * ProjectName: chatonline
 * To change this template use File | Settings | File Templates.
 **/
@Controller
@RequestMapping("/test")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/init")
    public ModelAndView init() {
        ModelAndView modelAndView = new ModelAndView("/index");
        String string = "Hello Templates!";
        modelAndView.addObject("Object", string);
        return modelAndView;
    }

}
