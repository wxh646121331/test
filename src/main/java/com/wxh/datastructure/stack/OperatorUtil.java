package com.wxh.datastructure.stack;

/**
 * @description: 操作符辅助类
 * @author: wuxinhong
 * @date: 2020/1/19
 * @time: 上午9:34
 */
public class OperatorUtil {
    public static int operate(int num1, int num2, char operator){
        switch (operator){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                throw new RuntimeException("操作符不合法");
        }
    }

    /**
     * 是否为操作符
     * @param c
     * @return
     */
    public static boolean isOperator(char c){
        switch (c){
            case '+':
            case '-':
            case '*':
            case '/':
            case '(':
            case ')':
                return true;
            default:
                return false;
        }
    }

    /**
     * 操作符优先级
     * @param c
     * @return
     */
    public static int priority(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
}
