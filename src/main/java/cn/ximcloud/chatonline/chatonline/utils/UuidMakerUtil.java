package cn.ximcloud.chatonline.chatonline.utils;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: wzard
 * Date: 2018-03-29
 * Time: 17:20
 * ProjectName: chatonline
 * To change this template use File | Settings | File Templates.
 **/

public class UuidMakerUtil {
    private UuidMakerUtil() {

    }
    public static String make() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
