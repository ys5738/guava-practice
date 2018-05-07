package ldes.practice.guava;

public class KMP {

    public int[] getNext(String str) {
        if(str == null || str.length() <= 0) {
            return null;
        }
        int i= 0;
        char[] chars  = str.toCharArray();
        int [] next = new int[str.length()];
        next[0] =  -1;
        while(i < str.length()){
            int k = next[i];
            if( -1 == k || chars[i] == chars[k]){
                // 这里还是有问题
                next[++i] = ++k;
            }else{
                k = next[k];
            }
        }
        return null;
    }
    
    public int KMP(String s, String p) {
        return -1;
    }
    
    public static void main(String[] args) {
        
    }
}
