package cn.ximcloud.chatonline.chatonline.controller;

import cn.ximcloud.chatonline.chatonline.domain.User;
import cn.ximcloud.chatonline.chatonline.respository.UserRepository;
import cn.ximcloud.chatonline.chatonline.utils.EmailUtil;
import cn.ximcloud.chatonline.chatonline.utils.EncryptUtil;
import cn.ximcloud.chatonline.chatonline.utils.UserVralidUtil;
import cn.ximcloud.chatonline.chatonline.utils.UuidMakerUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: wzard
 * Date: 2018-03-29
 * Time: 15:04
 * ProjectName: chatonline
 * To change this template use File | Settings | File Templates.
 **/
@RestController
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/")
    public String maincontrollerTest() {
        return "hello! ChatOnlineTest!";
    }

    /**
     *
     *  页面:/regist
     *  新建一个用户
     *  request : userEmail,username,userPassword
     *
     * @param userEmail 用户邮箱
     * @param userName 用户名
     * @param userPassword 用户密码
     */
    @PostMapping(value = "/regist")
    public void userRegister(@RequestParam("useremail") String userEmail,@RequestParam("username") String userName,@RequestParam("userpassword") String userPassword) {
        //这里要判断下用户Email是否存在与数据库
        List<User> userList = userRepository.findAll();
        Boolean flag = false;
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getUserEmail().equals(userEmail)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            User user = new User();
            user.setUserEmail(userEmail);
            user.setUserName(userName);
//          user.setUserPassword(userPassword);
            //不使用明文来保存密码，加密方式的选择以后挖坑
            user.setUserPassword(EncryptUtil.md5PasswordMaker(userPassword));
            user.setUUID(UuidMakerUtil.make());
            userRepository.save(user);
        } else {
            // throw an new Exception
        }
    }

    /*
        用户从/登录
     */
    @PostMapping(value = "/")
    public void mainPageLogin(@RequestParam("useraccount") String userAccount, @RequestParam("userpassword") String password) throws Exception {
        UserVralidUtil.isOurUser(userAccount, password);
    }
    /*
        用户从/login登录
     */
    @PostMapping(value = "/login")
    public void loginPageLogin(@RequestParam("useraccount") String userAccount, @RequestParam("userpassword") String password) throws Exception {
        UserVralidUtil.isOurUser(userAccount, password);
    }


}
