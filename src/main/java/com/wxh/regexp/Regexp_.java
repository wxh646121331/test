package com.wxh.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wuxinhong
 * @date 2021/7/22 5:03 下午
 */
public class Regexp_ {
    public static void main(String[] args) {
        String content = "正则表达式，又称规则表达式。1（英语：Regular Expression，在代码中常简写为regex、regexp或RE" +
                "），计算机科学的一个概念。正则表达式通常被用来检索、替换那些符合某个模式(规则)的文本。\n" +
                "许多程序设计语言都支持利用正则表达式进行字符串操作3234。" +
                "例如，在Perl中就内建了一个功能强大的正则表达式引擎。正则表达式这个概念最初是由Unix中的工具软件666" +
                "（例如sed和grep）普及开的。正则表达式通常缩写成“regex”，单数有regexp、regex，复数有regexps、regexes、regexen。";

        // 提取所有的英文单词
//        Pattern pattern = Pattern.compile("[a-zA-Z]+");
//        Pattern pattern = Pattern.compile("[0-9]+");
        Pattern pattern = Pattern.compile("([0-9]+)|[a-zA-Z]+");

        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            // 匹配内容，文本放到m.group(0)
            System.out.println("找到：" + matcher.group(0));
        }

    }
}
