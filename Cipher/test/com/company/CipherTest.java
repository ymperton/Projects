package com.company;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CipherTest {
//    Cipher cipher;
//
//    @Before
//    void onCreate() {
//        cipher = new Cipher();
//    }

    @Test
    void testCreateLetterFrequency() {
        Cipher c = new Cipher();
        c.enterCipherTextAndClean("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        double[] actual = c.createLetterFrequency();

        for (int i = 0; i < actual.length; i++) {
            assertEquals(1 / 26D, actual[i], 0.001);
        }
    }

    @Test
    void testCreateLetterHistogram() {
        Cipher c = new Cipher();
        c.enterCipherTextAndClean("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        int[] actual = c.createLetterHistogram();

        for (int i = 0; i < actual.length; i++) {
            assertEquals(1, actual[2]);
        }
    }


}