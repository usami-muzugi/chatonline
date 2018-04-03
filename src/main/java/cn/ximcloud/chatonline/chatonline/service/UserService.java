package cn.ximcloud.chatonline.chatonline.service;

import cn.ximcloud.chatonline.chatonline.domain.User;
import cn.ximcloud.chatonline.chatonline.respository.UserRepository;
import cn.ximcloud.chatonline.chatonline.utils.EncryptUtil;
import cn.ximcloud.chatonline.chatonline.utils.UuidMakerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: wzard
 * Date: 2018-03-29
 * Time: 20:48
 * ProjectName: chatonline
 * To change this template use File | Settings | File Templates.
 **/

@Service
public class UserService {
    @Autowired
    private static UserRepository userRepository;
    private UserService() {

    }

    public static boolean userRegister(@RequestParam("useremail") String userEmail, @RequestParam("username") String userName, @RequestParam("userpassword") String userPassword) {
        //这里要判断下用户Email是否存在与数据库
        List<User> userList = userRepository.findAll();
        Boolean flag = true;
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getUserEmail().equals(userEmail)) {
                //用户存在 flag = false
                flag = false;
                break;
            }
        }
        //用户不存在 flag = true
        if (flag) {
            User user = new User();
            user.setUserEmail(userEmail);
            user.setUserName(userName);
            //user.setUserPassword(userPassword);
            //不使用明文来保存密码，加密方式的选择以后挖坑
            user.setUserPassword(EncryptUtil.md5PasswordMaker(userPassword));
            user.setUUID(UuidMakerUtil.make());
            userRepository.save(user);
        }
        return flag;
    }
}
