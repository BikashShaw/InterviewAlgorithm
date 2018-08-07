package arrayandstring.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllWordsConcatenationSubstring {

    public static void main(String[] args) {
        AllWordsConcatenationSubstring allWordsConcatenationSubstring = new AllWordsConcatenationSubstring();
//        String s = "barfoothefoobarman";
//        String[] words = {"foo", "bar"};

//        String s = "wordgoodstudentgoodword";
//        String[] words = {"word", "student"};

//        String s = "barfoofoobarthefoobarman";
//        String[] words = {"bar", "foo", "the"};

        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String[] words = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};

        System.out.println(allWordsConcatenationSubstring.findSubstring(s, words));

    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> output = new ArrayList<>();
        char[] sChars = s.toCharArray();
        List<String> wordCombinations = permutations(words);
        for (String word : wordCombinations) {
            char[] wordChars = word.toCharArray();
            for (int i = 0; i < sChars.length; i++) {
                int k = i;
                boolean found = true;
                for (char wordChar : wordChars) {
                    if (k < sChars.length && sChars[k] == wordChar) {
                        k++;
                    } else {
                        found = false;
                    }
                }
                if (found) {
                    if(!output.contains(i)) {
                        output.add(i);
                    }
//                    break;
                }
            }
        }

        return output;
    }

    private List<String> permutations(String[] words) {
        ArrayList<String> permutationList = new ArrayList<>();
        permutations(words, permutationList, 0, words.length - 1);

        return permutationList;
    }

    private void permutations(String[] words, List<String> permutationList, int l, int r) {
        if (l == r) {
            StringBuilder builder = new StringBuilder();
            for (String word : words) {
                builder.append(word);
            }
            permutationList.add(builder.toString());
        } else {
            for (int i = l; i <= r; i++) {
                words = swap(words, l, i);
                permutations(words, permutationList, l + 1, r);
                words = swap(words, l, i);
            }
        }
    }


    private String[] swap(String[] words, int i, int j) {
        String temp;
        temp = words[i];
        words[i] = words[j];
        words[j] = temp;
        return words;
    }

}
