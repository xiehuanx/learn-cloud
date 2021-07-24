package com.icedevcloud.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/7/24
 * Describe:
 * 邀请码 工具类
 */
public class InvitationCodeUtil {

    private static final List<String> InvitationCodeList = new ArrayList<>(512);

    static {
        InvitationCodeList.add("8da6e2");
        InvitationCodeList.add("6f0ed9");
        InvitationCodeList.add("9b0f19");
        InvitationCodeList.add("836e0b");
        InvitationCodeList.add("2c5f4c");
        InvitationCodeList.add("c267fd");
        InvitationCodeList.add("8941d9");
        InvitationCodeList.add("49defe");
        InvitationCodeList.add("7d54ed");
        InvitationCodeList.add("e93a83");
        InvitationCodeList.add("c4b9a7");
        InvitationCodeList.add("9014c7");
        InvitationCodeList.add("39f94a");
        InvitationCodeList.add("1c379d");
        InvitationCodeList.add("7e533c");
        InvitationCodeList.add("fd5829");
        InvitationCodeList.add("ae2c9a");
        InvitationCodeList.add("28f39a");
        InvitationCodeList.add("a97c84");
        InvitationCodeList.add("c39f84");
        InvitationCodeList.add("8b1bbb");
        InvitationCodeList.add("e1da96");
        InvitationCodeList.add("0bd13e");
        InvitationCodeList.add("6be017");
        InvitationCodeList.add("c0b847");
        InvitationCodeList.add("aec7f1");
        InvitationCodeList.add("5f34d2");
        InvitationCodeList.add("6b58b9");
        InvitationCodeList.add("b2b55f");
        InvitationCodeList.add("8352b4");
        InvitationCodeList.add("599585");
        InvitationCodeList.add("703aa1");
        InvitationCodeList.add("4622b0");
        InvitationCodeList.add("a7ac67");
        InvitationCodeList.add("34b93a");
        InvitationCodeList.add("3ee54b");
        InvitationCodeList.add("e216dd");
        InvitationCodeList.add("090fb0");
        InvitationCodeList.add("25854e");
        InvitationCodeList.add("6d3db9");
        InvitationCodeList.add("dc988c");
        InvitationCodeList.add("20c2b3");
        InvitationCodeList.add("98b261");
        InvitationCodeList.add("31e8c8");
        InvitationCodeList.add("f1ee86");
        InvitationCodeList.add("f66a1d");
        InvitationCodeList.add("7a9369");
        InvitationCodeList.add("dc2aab");
        InvitationCodeList.add("9bc3a3");
        InvitationCodeList.add("4ace7e");
        InvitationCodeList.add("df420a");
        InvitationCodeList.add("0e1976");
        InvitationCodeList.add("e5c1d1");
        InvitationCodeList.add("31122c");
        InvitationCodeList.add("5bb6ff");
        InvitationCodeList.add("249292");
        InvitationCodeList.add("678eaf");
        InvitationCodeList.add("648335");
        InvitationCodeList.add("14a9b3");
        InvitationCodeList.add("204b7c");
        InvitationCodeList.add("079eba");
        InvitationCodeList.add("11dc94");
        InvitationCodeList.add("0add48");
        InvitationCodeList.add("2cead1");
        InvitationCodeList.add("0bc0c1");
        InvitationCodeList.add("8a03a2");
        InvitationCodeList.add("aedd95");
        InvitationCodeList.add("56f144");
        InvitationCodeList.add("9a6b74");
        InvitationCodeList.add("bb7b08");
        InvitationCodeList.add("2d74fe");
        InvitationCodeList.add("dc9b81");
        InvitationCodeList.add("47b538");
        InvitationCodeList.add("299783");
        InvitationCodeList.add("1c76ef");
        InvitationCodeList.add("27c421");
        InvitationCodeList.add("20454a");
        InvitationCodeList.add("83f907");
        InvitationCodeList.add("a9f99e");
        InvitationCodeList.add("18b29d");
        InvitationCodeList.add("937313");
        InvitationCodeList.add("68d82c");
        InvitationCodeList.add("1077f9");
        InvitationCodeList.add("97bd9a");
        InvitationCodeList.add("cabaaf");
        InvitationCodeList.add("79da28");
        InvitationCodeList.add("b0f2eb");
        InvitationCodeList.add("7af407");
        InvitationCodeList.add("d22fb7");
        InvitationCodeList.add("e20bf6");
        InvitationCodeList.add("fef98d");
        InvitationCodeList.add("e9a5ef");
        InvitationCodeList.add("0149b7");
        InvitationCodeList.add("34fb56");
        InvitationCodeList.add("2c3786");
        InvitationCodeList.add("2459e4");
        InvitationCodeList.add("5c0769");
        InvitationCodeList.add("e5c1db");
        InvitationCodeList.add("3b2249");
        InvitationCodeList.add("a87a07");
        InvitationCodeList.add("02ef44");
        InvitationCodeList.add("17b964");
        InvitationCodeList.add("3dacf4");
        InvitationCodeList.add("ab2da8");
        InvitationCodeList.add("9e2abf");
        InvitationCodeList.add("f5270d");
        InvitationCodeList.add("3b42d9");
        InvitationCodeList.add("580e91");
        InvitationCodeList.add("4fb309");
        InvitationCodeList.add("d0cb2c");
        InvitationCodeList.add("61f82a");
        InvitationCodeList.add("160a85");
        InvitationCodeList.add("120eee");
        InvitationCodeList.add("6510a9");
        InvitationCodeList.add("fc2e1f");
        InvitationCodeList.add("38413d");
        InvitationCodeList.add("f7a84f");
        InvitationCodeList.add("e5637a");
        InvitationCodeList.add("585314");
        InvitationCodeList.add("c4d74b");
        InvitationCodeList.add("e1ffed");
        InvitationCodeList.add("d4ff4c");
        InvitationCodeList.add("6967bf");
        InvitationCodeList.add("4fe4f7");
        InvitationCodeList.add("a9ebdb");
        InvitationCodeList.add("439f4d");
        InvitationCodeList.add("d0094a");
        InvitationCodeList.add("09580d");
        InvitationCodeList.add("f67d76");
        InvitationCodeList.add("ce02e0");
        InvitationCodeList.add("751b3d");
        InvitationCodeList.add("0600a4");
        InvitationCodeList.add("982ef2");
        InvitationCodeList.add("fb57f5");
        InvitationCodeList.add("b42e94");
        InvitationCodeList.add("8c0931");
        InvitationCodeList.add("c1044b");
        InvitationCodeList.add("f1d03e");
        InvitationCodeList.add("66a350");
        InvitationCodeList.add("934d97");
        InvitationCodeList.add("efd305");
        InvitationCodeList.add("424873");
        InvitationCodeList.add("936ed5");
        InvitationCodeList.add("b9d9d7");
        InvitationCodeList.add("846611");
        InvitationCodeList.add("aea8dd");
        InvitationCodeList.add("94461e");
        InvitationCodeList.add("756c24");
        InvitationCodeList.add("f5c1af");
        InvitationCodeList.add("f55e1f");
        InvitationCodeList.add("598c9c");
        InvitationCodeList.add("7e6823");
        InvitationCodeList.add("f56509");
        InvitationCodeList.add("cd74ba");
        InvitationCodeList.add("76c194");
        InvitationCodeList.add("05853d");
        InvitationCodeList.add("47a2c3");
        InvitationCodeList.add("f4d8bd");
        InvitationCodeList.add("e6bc58");
        InvitationCodeList.add("385155");
        InvitationCodeList.add("721fd4");
        InvitationCodeList.add("1a85c1");
        InvitationCodeList.add("015775");
        InvitationCodeList.add("9bd27f");
        InvitationCodeList.add("8ee119");
        InvitationCodeList.add("e8d598");
        InvitationCodeList.add("0c8000");
        InvitationCodeList.add("fea464");
        InvitationCodeList.add("5ac7bb");
        InvitationCodeList.add("936b26");
        InvitationCodeList.add("82d37e");
        InvitationCodeList.add("b66725");
        InvitationCodeList.add("aee719");
        InvitationCodeList.add("85f023");
        InvitationCodeList.add("b1d722");
        InvitationCodeList.add("9470a2");
        InvitationCodeList.add("d100e1");
        InvitationCodeList.add("c84bbe");
        InvitationCodeList.add("5e9fa1");
        InvitationCodeList.add("51badc");
        InvitationCodeList.add("48f322");
        InvitationCodeList.add("3ab1c8");
        InvitationCodeList.add("755e37");
        InvitationCodeList.add("a9d2b4");
        InvitationCodeList.add("30319f");
        InvitationCodeList.add("768481");
        InvitationCodeList.add("b56a62");
        InvitationCodeList.add("20e3c4");
        InvitationCodeList.add("c4a6da");
        InvitationCodeList.add("89c105");
        InvitationCodeList.add("538e46");
        InvitationCodeList.add("bd1820");
        InvitationCodeList.add("d2ff6f");
        InvitationCodeList.add("0ebdab");
        InvitationCodeList.add("062c0c");
        InvitationCodeList.add("5acea8");
        InvitationCodeList.add("df1800");
        InvitationCodeList.add("60c845");
        InvitationCodeList.add("7d8fbe");
        InvitationCodeList.add("4b94d2");
        InvitationCodeList.add("2075a1");
        InvitationCodeList.add("5f7b9a");
        InvitationCodeList.add("215f14");
        InvitationCodeList.add("57aa84");
        InvitationCodeList.add("fe0678");
        InvitationCodeList.add("77b7d4");
        InvitationCodeList.add("3ccfc0");
        InvitationCodeList.add("e56111");
        InvitationCodeList.add("415dcd");
        InvitationCodeList.add("bf3332");
        InvitationCodeList.add("b32b93");
        InvitationCodeList.add("c59136");
        InvitationCodeList.add("4b7dd8");
        InvitationCodeList.add("b2e7ce");
        InvitationCodeList.add("835e86");
        InvitationCodeList.add("5d8962");
        InvitationCodeList.add("41f6ce");
        InvitationCodeList.add("d3a756");
        InvitationCodeList.add("d32eaf");
        InvitationCodeList.add("6b8fea");
        InvitationCodeList.add("2d1fff");
        InvitationCodeList.add("29d4ba");
        InvitationCodeList.add("3fd969");
        InvitationCodeList.add("03b659");
        InvitationCodeList.add("a4f321");
        InvitationCodeList.add("c8d90e");
        InvitationCodeList.add("621100");
        InvitationCodeList.add("3e3083");
        InvitationCodeList.add("8508c6");
        InvitationCodeList.add("54420b");
        InvitationCodeList.add("b5f6f8");
        InvitationCodeList.add("ac3012");
        InvitationCodeList.add("640512");
        InvitationCodeList.add("f5950a");
        InvitationCodeList.add("3b2262");
        InvitationCodeList.add("7801d7");
        InvitationCodeList.add("8ac261");
        InvitationCodeList.add("85ba2a");
        InvitationCodeList.add("473497");
        InvitationCodeList.add("f92acc");
        InvitationCodeList.add("916197");
        InvitationCodeList.add("1c7b08");
        InvitationCodeList.add("56946d");
        InvitationCodeList.add("73faa1");
        InvitationCodeList.add("fc44de");
        InvitationCodeList.add("a4acfb");
        InvitationCodeList.add("ccd1c0");
        InvitationCodeList.add("a76cb0");
        InvitationCodeList.add("2d7c7d");
        InvitationCodeList.add("4cff46");
        InvitationCodeList.add("481e75");
        InvitationCodeList.add("b351c4");
        InvitationCodeList.add("d05b3e");
        InvitationCodeList.add("a4a586");
        InvitationCodeList.add("2cdabd");
        InvitationCodeList.add("92ebfa");
        InvitationCodeList.add("f7b605");
        InvitationCodeList.add("beca39");
        InvitationCodeList.add("10fc7a");
        InvitationCodeList.add("664f0d");
        InvitationCodeList.add("291127");
        InvitationCodeList.add("b6111d");
        InvitationCodeList.add("ddb28e");
        InvitationCodeList.add("e37009");
        InvitationCodeList.add("5540e4");
        InvitationCodeList.add("53b71e");
        InvitationCodeList.add("c1bdcb");
        InvitationCodeList.add("01d730");
        InvitationCodeList.add("cdbb56");
        InvitationCodeList.add("254dd1");
        InvitationCodeList.add("ad2063");
        InvitationCodeList.add("d36c93");
        InvitationCodeList.add("1b534f");
        InvitationCodeList.add("c03653");
        InvitationCodeList.add("77ade6");
        InvitationCodeList.add("a4673e");
        InvitationCodeList.add("55f87c");
        InvitationCodeList.add("2385b6");
        InvitationCodeList.add("52d377");
        InvitationCodeList.add("c89f52");
        InvitationCodeList.add("40aff6");
        InvitationCodeList.add("4ed5fe");
        InvitationCodeList.add("1ed639");
        InvitationCodeList.add("4f61d5");
        InvitationCodeList.add("3965fc");
        InvitationCodeList.add("1bcc0f");
        InvitationCodeList.add("7688cc");
        InvitationCodeList.add("67e514");
        InvitationCodeList.add("135d67");
        InvitationCodeList.add("c4f836");
        InvitationCodeList.add("3d4914");
        InvitationCodeList.add("101af1");
        InvitationCodeList.add("1500ef");
        InvitationCodeList.add("f26c6c");
        InvitationCodeList.add("caa414");
        InvitationCodeList.add("6da929");
        InvitationCodeList.add("e61f79");
        InvitationCodeList.add("07b062");
        InvitationCodeList.add("3e52ef");
        InvitationCodeList.add("c355e7");
    }

    /**
     * 验证码邀请码是否正确
     * @param invitationCode 邀请码
     * @return true 正常；false 不正常的邀请码
     */
    public static boolean VerificationCode(String invitationCode){
        return InvitationCodeList.contains(invitationCode);
    }

}