package org.quickstart.jvm.serializer.commons.utils.unittest;

import java.io.IOException;

import org.junit.Test;
import org.quickstart.jvm.serializer.commons.utils.CodecTest;
import org.quickstart.jvm.serializer.commons.utils.MsgPackCodec;
import org.quickstart.jvm.serializer.model.Message;

/**
 * @author xinyuzhou.zxy
 */
public class MsgPackCodecTest extends CodecTest {

    @Test
    public void msgPackCodecSizeTest() {
        byte[] obj1 = MsgPackCodec.encode(msg1);
        System.out.println(obj1.length);
    }

    protected void msgPackEncodeAndDecode() throws IOException {
        byte[] obj1 = MsgPackCodec.encode(msg1);
        msg1 = MsgPackCodec.decode(obj1, Message.class);

        byte[] obj2 = MsgPackCodec.encode(msg2);
        msg2 = MsgPackCodec.decode(obj2, Message.class);

        byte[] obj3 = MsgPackCodec.encode(msg3);
        msg3 = MsgPackCodec.decode(obj3, Message.class);
    }
}
