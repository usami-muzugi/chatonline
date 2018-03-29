package cn.ximcloud.chatonline.chatonline.utils;

import cn.ximcloud.chatonline.chatonline.domain.User;
import cn.ximcloud.chatonline.chatonline.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * User: wzard
 * Date: 2018-03-29
 * Time: 20:35
 * ProjectName: chatonline
 * To change this template use File | Settings | File Templates.
 **/

public class UserVralidUtil {

    @Autowired
    private static UserRepository userRepository;
    private UserVralidUtil() {

    }

    /**
     *
     * @param userAccount 用户的账号 可以是 ID、邮箱
     * @param password 用户的密码
     * @throws Exception
     */
    public static boolean isOurUser(String userAccount,String password) throws Exception {
        boolean flag = false;
        User user;
        if (userAccount != null || !userAccount.equals("")) {
            //判断了下输入的账号是否为null或者为空
            //登录可以通过id、邮箱登录    (用户名不唯一，所以不能是用户名)
            //不是数字型 抛出NumberFormatException
            Integer userId = null;
            try {
                userId = Integer.valueOf(userAccount);
                flag = true;
            } catch (NumberFormatException e) {
                //识别下是否为邮箱,并且存在
                if (EmailUtil.isEmail(userAccount)) {
                    if (userRepository.findByUserEmail(userAccount) != null) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                //获取该用户
                if (userId == null) {
                    //通过Email
                    user = userRepository.findByUserEmail(userAccount);
                } else {
                    //通过ID
                    user = userRepository.findById(userId).get();
                }
                //判断密码是否正确
                if (EncryptUtil.md5PasswordMaker(password).equals(user.getUserPassword())) {
                    return true;
                } else {
                    //用户密码错误
                    throw new Exception();
                }
            }
            return false;
        } else {
            //用户账号为空
            throw new Exception();
        }
    }

}
