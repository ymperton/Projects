package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
//        Cipher c = new Cipher();
//        try {
//            Cipher.createDictionary();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Cipher.placeSpacesInStringWithout("", "ILOVEYOUSOMUCHANDIDONOTKNOWWHATIWOULDDOWITHOUTYOU",
//                0, 0);

//        for (PlainText pT : Cipher.aryPossibleSentences) {
//            if (pT.getReadabilityScore() > 0)
//            System.out.println(pT.getPlainText()
//                    + "\t\tSc: " + pT.getReadabilityScore()
//                    + "\tEr" + pT.getReadabilityErrorRate());
//        }

//        CaesarianCipher cc = new CaesarianCipher();
//        cc.enterCipherTextAndClean("XtwnlmystbNrtsymjxzgbfdgfhpytqfsijwxfkyjwrdifyjbjrjyfyjcfhyqdfsibjbfqpjiytOjwzxfqjrhfkjbm" +
//                "nhmxmjsjajwbfxymjwjgjktwjxmjtwijwjifbfyjwfsiNltyfXsfuuqjBjknwxyxutpjfgtzyNxwfjqfsiymjJqqrfsxNitsypst" +
//                "bnkxmjbfxitnslrtxytkymjyfqpnslfsixtNbtzqijsyjwbmfyNbfsyjiytxfdNrltnslytmfajytlttsfstymjwYmjwjbjwjufw" +
//                "yxnsynrjymfyNbfxymnspnslytrdxjqkymfybmtfNrknsfqqditnslfifyjNitsypstbmtbqtslmfxgjjsgznqinslzuytymnxgz" +
//                "yNbfxymjwjBjxutpjfgtzymjwkfymjwxxmzqNymnspymfyNbfxymjtsjrtxyqdfxpnslymjvzjxyntsxgzyrfdgjxmjbfxxmdNit" +
//                "sypstbnkymnxbfxmjwknwxyifyjfxbjqqNsymjrniiqjbjbjsyytljykttixmjltyfunjhjtkxfqrtsfsiNltyxzxmnNbnxmxmjl" +
//                "tyrtwjgzyymfyxbmfyxmjbfsyjiNmtujnyitjxsywjkqjhyuttwqdtsrjktwNbfxfgqjytxujsirtwjBjltynsythfruzxYjfsjh" +
//                "pxyjwsTpfdfwtzsibmnhmbfxtajwybtmtzwxtkyfpnslbmnhmbjsygdkfxyymjdxyfwyjiythqtxjxtbjqjkyfsibfqpjigfhpyt" +
//                "tzwrjjynslutnsybmnhmbfxtzyxnijtkmjwitwrnytwdstbxmjinisybfsyrjytyfpjmjwfqqymjbfdzuytymjittwNlzjxxktwt" +
//                "gantzxwjfxtsxgzyxmjinisybfsyytltnswnlmyfbfdxtbjinifqttufwtzsifsiymjsbjinifstymjwqttufwtzsiynqqnybfxf" +
//                "siymjsbjxuqnyzuRdfsxbjwnxymfydjxNbtzqibfsyytxjjmjwflfnsGzyymjkjjqnslbfxhwfedbmjsNxfbmjwljyytymjhtwsj" +
//                "wfyymjgjlnssnsltkymjsnlmyfsiNbfxqnpjytrdxjqkymfybtfmymnxnxnyymnxnxmjwNwjhtlsnejmjwkwtrymjunhyzwjNits" +
//                "ypstbnkxmjlttlqjirjfsipsjbbmfyNqttpjiqnpjNbtzqixfduwtgfgqddjxktwtkhtzwxjdtzLttlqjymjujwxtsstygqnsiqd" +
//                "ktqqtbnslfwjxzrjXtrdufwjsyxbfsyrjythfqqymjrbmjsNljygfhpNxynqqitsypstbjajwdymnslfgtzymjwbmnhmrfpjxxhj" +
//                "sjFsiymjwjfwjhjwyfnsymnslxbmnhmNrltnslytmfajytktqqtbzutsnkymjwjbnqqgjfsjcyynrjqnpjymjinxxjhynsltkfkw" +
//                "tlbmnhmxmjnxltnslytitns2bjjpxgzybnqqrjjynyytrtwwtbUzwnrbnqqgjnsgjybjjsfsixmjbtzqimfajknlzwjitzymjwht" +
//                "xyzrjNyxjjrjiqnpjnybfxmfwiktwmjwytrfpjijhnxntsxbmjsnyhfrjytbmnhmbfdytbjjpbmnhmnxsyfgnlijfqNpstbxmjmf" +
//                "xrtwjytmjwymjsymjxzwkfhjgjhfzxjNiniymjwjxjfwhmtsmjwNrjsyntsjiTMJQGjnxJewffsiNbfxhfwjkzqytutnsytzyymfy" +
//                "NitsyijknsjnsinanizfqxgdymjnwinxfgnqnydxtNlzjxxymfyxfuqzxfsiNbfxsyqdnslytmjwymfyxbmfyNfrNozxymfiytrfp" +
//                "jxzwjymfyNxfninyhtwwjhyqdFsiNinisyrnsibfqpnslbnymmjwNbtzqimfajwfymjwhtsynszjibfqpnslqfyjwozxyymfyNsjj" +
//                "iytljygfhpytVzjjsxFqxtfstymjwymnslymfyNqnpjibfxymfyxmjitjxsylttzyfsijcuqtwjymjhnydstynsfgfibfdgzyymfy" +
//                "xmjnxsytsjythtsxyfsyqdsjjiytmfsltzybnymkwnjsixfsilttzyfsijfyNrtsqdfkwfniymfyxmjbfxsyfgqjytljyflttiwjfi" +
//                "tsrjtwrfdgjxmjinifsiitjxsyymnspymfyNrktwmjwfsinkxmjijhnijiymfyymjsTPnybfxsyrjfsyytgjgzyNhtzqixjjnybtwp" +
//                "nsltzygjybjjszxFyknwxynybfxfgnybjnwigjhfzxjxmjxutpjajwdqtbfsinybfxmfwiytmjfwmjwfyknwxygzyymfybjsyfbfdKtw" +
//                "xtrjwjfxtsNljyymfyxmjnxfsnsywtajwyXmjxajwdrzhmnsytQnrzijnPtijxmfxxmjbfxxfdnslymfyxmjkjqygfiymfyxmjbtsymf" +
//                "ajfqjfwsnslhqfxxnstsjtkymjsjcyxjrjxyjwxfsixmjbfxrjsyntsnslmtbnybnqqgjhtsxnijwjiqxmrf");
//
//        cc.decipher();

        Cipher c = new Cipher();
        c.enterCipherTextAndClean("thedog");
        System.out.println(c.calculateReadabilityScore(c.getCipherText()));

    }
}
