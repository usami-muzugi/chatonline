package cn.ximcloud.chatonline.chatonline.respository;

import cn.ximcloud.chatonline.chatonline.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: wzard
 * Date: 2018-03-29
 * Time: 15:10
 * ProjectName: chatonline
 * To change this template use File | Settings | File Templates.
 **/

public interface UserRepository extends JpaRepository<User, Object> {
    User findByUserEmail(String userEmail);
}
