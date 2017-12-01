package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

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

//        PlainText pt = cc.decipher();
//        System.out.println(pt);
long start = System.currentTimeMillis();
        PolyalphabeticCipher pc = new PolyalphabeticCipher();
        pc.enterCipherTextAndClean("CSPEUYWXSUEAFQDLCOISZKCZW QBWYPYJRVUCEDPSIPIHYPSNHW IRWHVAKGRHMRQNACSOCNOHRKX " +
                "VUEWYHSDFKJCSVZFRWFABVYOV UWGKKOVCXSWRBIQDSFUNIPARR ZKXCNOEGSKMPOJQKTNHSNHPMP OHJSYOCWPFXDMQNOVOKRBPVVH " +
                "VPKWBJLNSLPYERGMDOVVZKWBK WEJWSQPCWWRIRWZBLXKYJRJRS AMQZUHXXCNKYDDMUWBKHNXMOO PLWKMEBXWYLYRSKRQSMJOERDL " +
                "CNHYHBIUAFVSKVROWEWSQCPVR WSAYOHYLXOGJUKRWCQAZWWRER SVFDSQDEBROVCBKWEJKHYPSZG YRRGBFZRSUHCEJREQXSVQLYGH " +
                "RZQQYNPCKKSWZQHZZKWRDSIHG IQLCBHKFMQHYHBJYPVVUCWFQZ ZWRMLGHYDDMUWGKKOSLAAFVDP WWGBLXKRDSHXOWRECEVLYRIOP " +
                "EOWFAKRVCLWERFQDOLKKZIDLG OKRVRIPBWIVDHYPSRVGIJHWEW RIKERUOOACSSEWDSEAHWRYHQD SXRDENESTHYJQWZDRXELZWXRD " +
                "WSOVZLGMQDGYHQSRICIHLYRPV RWCAFWHJKOAYJHVGSLMLSZWNS COBKUOJJAQKSYSPHMFQWIDKFZ ZKWYXZVWYWNABUPYVCSSXRDML " +
                "PCTDWTSOHVDXIAGGKHBRMGOPD BSSJRNKSGFSOJRFIPPKFKYYPO CWWKOGJUNKSGFSSEWLCDWGKWR IWOHRUDIBPCTOYWCOCNHVIDPO");

        pc.decipher();

        long end = System.currentTimeMillis();
        long time = (end - start) / 1000;
        System.out.println("time: " + time);
        System.out.println("Done");

    }
}
