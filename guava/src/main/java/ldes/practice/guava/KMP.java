package ldes.practice.guava;

public class KMP {

    public static int[] getNext(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        // next[i] 表示第i个数之前的 字符串最长回文子串
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            //  cn 代表的回文子串 的下一位和 i代表的回文子串 下一位相等 那么i的回文子串直接加一
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                // 如果 cn代表的回文子串 的下一位 和 i 代表的回文子串下一位不等 cn 回退
                cn = next[cn];
            } else {
                // cn 回退到 0
                next[i++] = 0;
            }
        }
        return next;
    }
    
    public static int getIndexOf(String s, String p) {
        if(s == null || p == null){
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = p.toCharArray();
        int i1 = 0, i2  = 0;
        int[] next = getNext(str2);
        while(i2 < str2.length && i1 < str1.length){
            if(str1[i1] == str2[i2]){
                i2++;
                i1++;
            } else if(next[i2] == -1){
                i1++;
            }else{
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }
    
    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "cabc";
        System.out.println(getIndexOf(str, match));
    }

}
