package com.keep.java.week9;


public class ReverseWords {



    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String st : s1) {
            char[] stCs = st.toCharArray();
            int l = 0, r = stCs.length - 1;
            while (l < r) {
                char tmp = stCs[l];
                stCs[l] = stCs[r];
                stCs[r] = tmp;
                l++;
                r--;
            }
            builder.append(stCs).append(" ");
        }
        return builder.substring(0, builder.length() - 1);
    }

    public String reverseWords2(String s) {
        char[] sc = s.toCharArray();

        int n = sc.length;
        for (int i = 0; i < n; i++) {
            if (sc[i] != ' ') {
                int l = i;
                while (++i < n && sc[i] != ' ') ;
                int r = i - 1;
                while (l < r) {
                    char tmp = sc[l];
                    sc[l] = sc[r];
                    sc[r] = tmp;
                    l++;
                    r--;
                }
            }

        }
        return new String(sc);
    }


    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("Let's take LeetCode contest"));
        System.out.println(new ReverseWords().reverseWords2("Let's take LeetCode contest"));
    }
}
