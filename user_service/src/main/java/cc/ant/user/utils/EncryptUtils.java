package cc.ant.user.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import sun.security.provider.SecureRandom;

/**
 * @program: user_service
 * @description: MD5加密工具
 * @Author: XINGUOZ
 * @date: 2019-05-04 16:14
 */
public class EncryptUtils {
    /**
     * @Author XINGUOZ
     * @Description //TODO
     * @return 盐值和密文
     **/
    public static String[] EncryptPassword(String password){

        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();//生成盐值
        String Ciphertext = new Md5Hash(password, salt, 3).toString();//生成密文

        String[] strings = {salt, Ciphertext};
        return strings;
    }
    /**
     * @Author XINGUOZ
     * @Description //TODO
     * @Date
     * @Param
     * @return
     **/
    public static String getIpuPasswordCiph(String password,String salt){
        if(salt==null)password="";
        return new Md5Hash(password, salt, 3).toString();
    }
}
