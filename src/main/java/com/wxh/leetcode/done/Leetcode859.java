package com.wxh.leetcode.done;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuxinhong
 * @date 2021/11/23 9:11 上午
 */
public class Leetcode859 {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        int diffCount = 0;
        int[] indexes = new int[2];
        int j = 0;
        Set<Character> charSet = new HashSet<>();
        boolean existRepeat = false;
        for(int i=0; i<s.length(); i++){
            if(!existRepeat){
                if(!charSet.contains(s.charAt(i))){
                    charSet.add(s.charAt(i));
                }else {
                    existRepeat = true;
                }
            }
            if(s.charAt(i) == goal.charAt(i)){
                continue;
            }
            diffCount ++;
            if(diffCount > 2){
                return false;
            }
            indexes[j++] = i;
        }
        boolean result = false;
        switch (diffCount){
            case 1:
                result = false;
                break;
            case 2:
                if(s.charAt(indexes[0]) == goal.charAt(indexes[1]) && s.charAt(indexes[1]) == goal.charAt(indexes[0])){
                    result = true;
                }
                break;
            default:
                result = existRepeat;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode859 leetcode859 = new Leetcode859();
        System.out.println(leetcode859.buddyStrings("aaaaaaabc", "aaaaaaabc"));
    }
}
