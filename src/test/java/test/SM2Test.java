package test;

import org.ca.ext.security.sm.TopSMProvider;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;

/**
 * Created by ligso on 2016/6/5.
 */
public class SM2Test {
    public static void main(String[] args) throws Exception{
        TopSMProvider topSMProvider = new TopSMProvider();
        Security.addProvider(topSMProvider);
        KeyPair keyPair = KeyPairGenerator.getInstance("SM2").generateKeyPair();
        System.out.println(keyPair);
        System.out.println(keyPair.getPublic());
        System.out.println(keyPair.getPrivate());
    }
}
