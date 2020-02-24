package com.wxh.datastructure.stack;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.Op;
import scala.Char;

import java.util.Stack;

/**
 * @description: 逆波兰表达式
 *  (10+4)*(5+(5-3))-40/20 -> 10 4 + 5 5 3 -  + * 40 20 / -
 * @author: wuxinhong
 * @date: 2020/1/16
 * @time: 上午9:27
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        String middleExpression = "(10+4)*(5+(5-3))-40/20";
        String rpn = toRPN(middleExpression);
        System.out.println(rpn);
        System.out.println(cal(rpn));
//        String expression = "10 4 + 5 5 3 - + * 40 20 / -";
//        System.out.println(cal(expression));
    }

    /**
     * 中缀表达式转换与逆波兰表达式
     * 转换步骤：
     * 1. 初始化两个栈：操作符栈 s1 和中间过程数据栈 s2
     * 2. 从左至右遍历表达式：
     *  1）若为 ( ，直接压入 s1
     *  2）若为 ) ，依次弹出 s1 栈顶元素并压入 s2 中，直到 s1 弹出的元素为 ( 停止，说明：( 不需要压入 s2 中
     *  3）若为操作数，直接压入 s2 中
     *  4）若为操作符（+、-、*、、），则比较与 s1 栈顶元素的优化级，
     *      4.1) 若栈顶元素为 ( 或栈顶元素优化级低于当前操作符，直接将当前操作符压入 s1
     *      4.2) 若栈顶元素优化级高于或等于当前操作符，弹出 s1 栈顶元素，压入 s2，重复步骤 4），直至满足 4.1）
     * 3. 表达式遍历完成后，将 s1 中的操作符依次弹出，并压入 s2 中
     * 4. 将 s2 中的元素依次弹出，得到的即为逆波兰表达式的倒序结果
     * @param expression
     * @return
     */
    public static String toRPN(String expression){
        Stack<Character> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        for(int i=0; i<expression.length(); i++){
            if('(' == expression.charAt(i)){
                s1.push(expression.charAt(i));
            }else if(')' == expression.charAt(i)){
                while (true){
                    char temp = s1.pop();
                    if('(' == temp){
                        break;
                    }
                    s2.push(String.valueOf(temp));
                }
            }else if(!OperatorUtil.isOperator(expression.charAt(i))){
                StringBuilder sb = new StringBuilder().append(expression.charAt(i));
                while (true){
                    if(i == expression.length()-1 || OperatorUtil.isOperator(expression.charAt(i+1))){
                        break;
                    }
                    sb.append(expression.charAt(++i));
                }
                s2.push(sb.toString());
            }else {
                while (true){
                    if(s1.isEmpty() || '(' == s1.peek() || OperatorUtil.priority(s1.peek()) < OperatorUtil.priority(expression.charAt(i))){
                        break;
                    }
                    s2.push(String.valueOf(s1.pop()));
                }
                s1.push(expression.charAt(i));
            }
        }
        while (!s1.isEmpty()){
            s2.push(String.valueOf(s1.pop()));
        }

        Stack<String> temp = new Stack<>();
        while (!s2.isEmpty()){
            temp.push(s2.pop());
        }
        StringBuilder sb = new StringBuilder().append(temp.pop());
        while (!temp.isEmpty()){
            sb.append(" ").append(temp.pop());
        }
        return sb.toString();
    }

    /**
     * 逆波兰表达式计算
     * @param exp
     * @return
     */
    public static int cal(String exp){
        if(StringUtils.isEmpty(exp)){
            return 0;
        }
        Stack<Integer> numStack = new Stack<>();
        String[] subExp = exp.split(" ");
        for(String sub : subExp){
            if(sub.length()>1 || !OperatorUtil.isOperator(sub.charAt(0))){
                numStack.push(Integer.valueOf(sub));
            }else{
                Integer num2 = numStack.pop();
                Integer num1 = numStack.pop();
                numStack.push(OperatorUtil.operate(num1, num2, sub.charAt(0)));
            }
        }
        return numStack.pop();
    }
}
