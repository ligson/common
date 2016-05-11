package org.ca.common.utils;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;

import java.lang.reflect.Field;


/**
 * Created by ligson on 2016/5/11.
 */
public class X500NameUtils {

    /***
     * 将o=11,ou=test,cn=test转换为x500name对象
     *
     * @param subject 主题
     * @return x500name
     */
    public static X500Name subjectToX500Name(String subject) {
        String[] subjects = subject.split(",");

        X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);
        for (String nameUnit : subjects) {
            try {
                String name = nameUnit.split("=")[0].trim();
                String value = nameUnit.split("=")[1].trim();
                Field field = BCStyle.class.getDeclaredField(name.toUpperCase());
                ASN1ObjectIdentifier asn1ObjectIdentifier = (ASN1ObjectIdentifier) field.get(field);
                builder.addRDN(asn1ObjectIdentifier, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return builder.build();
    }

    public static void main(String[] args) {
        System.out.println(subjectToX500Name("o=lecxe,ou=dev,cn=ligson"));
    }
}
