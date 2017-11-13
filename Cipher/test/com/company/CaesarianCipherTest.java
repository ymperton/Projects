package com.company;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CaesarianCipherTest {
    @Test
    public void TestCalculateLetterShift() throws FileNotFoundException {
        CaesarianCipher cc = new CaesarianCipher();
        cc.enterCipherTextAndClean("YmnxnxfxyfsifwiHfjxfwnfsXmnkyhnumjwjshtijwfqxtpstbsfxfjshtijwfsinxfqxtfxydqjtkxzgxynyzynt" +
                "shnumjwYmnxbfddtzhfsfiitsjybttwfsdszrgjwzuytytdtzwxywnslfsixjjmtbnyhmfsljxYmnxnxfstkkxmttytkymjw" +
                "tyjshtijwtsymnxbjgxnyjYtujwktwrymnxxmnkygdmfsidtzhtzqiozxybwnyjymjfqumfgjytsybtxywnuxtkufujwQnsjy" +
                "mjrzuxtymjytuxywnuxFrfyhmjxymjgtyytrxywnuxItwxtrjymnslfsiymjsdtzhfsjshtijFxnruqjyjxyytxjjmtbymnxbt" +
                "wpxbtzqigjytnsxjwyymjfqumfgjynsytymjjshtijwfsiymjshmfsljymjafqzjxtk");

        double[] letterHistogram = cc.createLetterFrequency();
//        int actual = cc.calculateLetterShift(letterHistogram);

//        assertEquals(5, actual);

    }
}