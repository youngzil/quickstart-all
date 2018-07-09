package org.quickstart.jvm.serializer.commons.utils.unittest;

import java.io.IOException;

import org.junit.Test;
import org.quickstart.jvm.serializer.commons.utils.CodecTest;
import org.quickstart.jvm.serializer.commons.utils.JsonCodec;
import org.quickstart.jvm.serializer.model.Message;
import org.quickstart.jvm.serializer.model.Son;

public class FastJsonCodecTest extends CodecTest {

    @Test
    public void jsonCodecSizeTest() throws Throwable {
        byte[] obj1 = JsonCodec.encode(msg1);
        System.out.println(obj1.length);
    }

    @Test
    public void jsonCodecTest() {
        // Father father = new Father();
        // byte[] obj1 = JsonCodec.encode(father);
        // Father fatherCopy = JsonCodec.decode(obj1, Father.class);

        // Timestamp type
        // System.out.println(fatherCopy.getLocation_time());
        // System.out.println(father.getLocation_time());

        // Locale
        // System.out.println(fatherCopy.getLocale());
        // System.out.println(father.getLocale());

        // EnumSet
        // bug
        // System.out.println(fatherCopy.getCertificates());
        // System.out.println(father.getCertificates());

        // BitSet
        // bug
        // System.out.println(fatherCopy.getqRCode());
        // System.out.println(father.getqRCode());

        Son son = new Son();
        byte[] obj2 = JsonCodec.encode(son);
        Son sonCopy = JsonCodec.decode(obj2, Son.class);

        // Enum
        // System.out.println(sonCopy.getCf());
        // System.out.println(son.getCf());

        // same name filed,parent first
        System.out.println(son.getAge());
        System.out.println(sonCopy.getAge());
        System.out.println(son.isCCP());
        System.out.println(sonCopy.isCCP());
        System.out.println(son.getSalary());
        System.out.println(sonCopy.getSalary());
    }

    protected void jsonEncodeAndDecode() throws IOException {
        byte[] obj1 = JsonCodec.encode(msg1);
        msg1 = JsonCodec.decode(obj1, Message.class);

        byte[] obj2 = JsonCodec.encode(msg2);
        msg2 = JsonCodec.decode(obj2, Message.class);

        byte[] obj3 = JsonCodec.encode(msg3);
        msg3 = JsonCodec.decode(obj3, Message.class);
    }
}
