package com.wxh.datastructure.stack;

/**
 * @description: 用栈实现计算器功能
 * @author: wuxinhong
 * @date: 2020/1/9
 * @time: 上午10:02
 */
public class Calculator {

    public static void main(String[] args) {
        System.out.println(cal("(10+4)*(5+(5-3))-40/20"));
    }

    public static int cal(String s){
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operatorStack = new ArrayStack(10);
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(OperatorUtil.isOperator(c)){
                if('(' == c){
                    operatorStack.push(c);
                    continue;
                }
                if(')' == c){
                    while (true){
                        if('(' == operatorStack.peek()){
                            operatorStack.pop();
                            break;
                        }
                        calculate(numStack, operatorStack);
                    }
                    continue;
                }
                if(!operatorStack.isEmpty() && OperatorUtil.priority((char) operatorStack.peek()) >= OperatorUtil.priority(c) && '(' != (char) operatorStack.peek()){
                    calculate(numStack, operatorStack);
                }
                operatorStack.push(c);
            }else {
                StringBuilder sb = new StringBuilder().append(c);
                while (true){
                    if(i == s.length() - 1 || OperatorUtil.isOperator(s.charAt(i+1))){
                        break;
                    }
                    sb.append(s.charAt(i+1));
                    i++;
                }
                numStack.push(Integer.valueOf(sb.toString()));
            }
        }

        while (true){
            if(operatorStack.isEmpty()){
                return numStack.pop();
            }
            calculate(numStack, operatorStack);
        }
    }

    public static void calculate(ArrayStack numStack, ArrayStack operatorStack){
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        char operator = (char) operatorStack.pop();
        int num = OperatorUtil.operate(num1, num2, operator);
        numStack.push(num);
    }
}
