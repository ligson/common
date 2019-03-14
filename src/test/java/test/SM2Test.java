package test;

import org.ca.ext.crypto.CipherAgent;
import org.ca.ext.security.sm.TopSMProvider;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Set;

/**
 * Created by ligso on 2016/6/5.
 */
public class SM2Test {
    public static void main(String[] args) throws Exception {
        TopSMProvider topSMProvider = new TopSMProvider();
        Security.addProvider(topSMProvider);
        KeyPair keyPair = KeyPairGenerator.getInstance("SM2").generateKeyPair();
        System.out.println(keyPair);
        System.out.println(keyPair.getPublic());
        System.out.println(keyPair.getPrivate());
        String plain = "123";

        CipherAgent cipher = CipherAgent.getInstance("SM2");
        // Cipher cipher = Cipher.getInstance("SM2",topSMProvider);
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        cipher.update(plain.getBytes());
        byte[] buffer = cipher.doFinal();
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        cipher.update(buffer);
        byte[] deBuffer = cipher.doFinal();
        System.out.println(new String(deBuffer));


        Signature sign = Signature.getInstance("SM3WithSM2", topSMProvider);
        sign.initSign(keyPair.getPrivate());
        sign.update(plain.getBytes());
        byte[] signData = sign.sign();
        sign.initVerify(keyPair.getPublic());
        sign.update(plain.getBytes());
        boolean check = sign.verify(signData);
        System.out.println(check);

        Set<Provider.Service> services = topSMProvider.getServices();
        for (Provider.Service service : services) {
            System.out.println(service);
        }
        //KeyPair keyPair2 = KeyPairGenerator.getInstance("SMS4", topSMProvider).generateKeyPair();
//        CipherAgent cipherAgent2 = CipherAgent.getInstance("SMS4");
//        cipherAgent2.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
//        cipherAgent2.update(plain.getBytes());
//        byte[] buffer2 = cipherAgent2.doFinal();
//        cipherAgent2.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
//        cipherAgent2.update(buffer2);
//        byte[] buffer3 = cipherAgent2.doFinal();
//        System.out.println(new String(buffer3));
        //@TODO SMS4不完善


    }
}
