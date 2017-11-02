package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarianCipherTest {
    @Test
    public void TestCalculateLetterShift() {
        CaesarianCipher cc = new CaesarianCipher();
        cc.enterCipherText("YmnxnxfxyfsifwiHfjxfwnfsXmnkyhnumjwjshtijwfqxtpstbsfxfjshtijwfsinxfqxtfxydqjtkxzgxynyzynt" +
                "shnumjwYmnxbfddtzhfsfiitsjybttwfsdszrgjwzuytytdtzwxywnslfsixjjmtbnyhmfsljxYmnxnxfstkkxmttytkymjw" +
                "tyjshtijwtsymnxbjgxnyjYtujwktwrymnxxmnkygdmfsidtzhtzqiozxybwnyjymjfqumfgjytsybtxywnuxtkufujwQnsjy" +
                "mjrzuxtymjytuxywnuxFrfyhmjxymjgtyytrxywnuxItwxtrjymnslfsiymjsdtzhfsjshtijFxnruqjyjxyytxjjmtbymnxbt" +
                "wpxbtzqigjytnsxjwyymjfqumfgjynsytymjjshtijwfsiymjshmfsljymjafqzjxtk");

        double[] letterHistogram = cc.createLetterFrequency();
        int actual = cc.calculateLetterShift(letterHistogram);

        assertEquals(5, actual);

    }
}