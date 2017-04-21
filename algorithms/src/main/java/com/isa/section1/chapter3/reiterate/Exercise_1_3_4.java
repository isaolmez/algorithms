package com.isa.section1.chapter3.reiterate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Exercise_1_3_4 {

    private static final Map<Character, Character> pairs = new HashMap<>();

    static {
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
    }

    public static void main(String[] args) {
        System.out.println(parantheses("[()]{}{[()()]()}"));
        System.out.println(parantheses("{{[((()))]}}"));
        System.out.println(parantheses("[(])"));

        System.out.println(paranthesesWithTwoStacks("[()]{}{[()()]()}"));
        System.out.println(paranthesesWithTwoStacks("{{[((()))]}}"));
        System.out.println(paranthesesWithTwoStacks("[(])"));
    }

    public static boolean parantheses(String input) {
        final char[] symbols = input.toCharArray();
        final LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < symbols.length; i++) {
            char symbol = symbols[i];
            if (pairs.containsKey(symbol)) {
                if (!stack.isEmpty()) {
                    if (stack.peek().equals(pairs.get(symbol))) {
                        stack.pop();
                    }else{
                        break;
                    }
                }
            } else {
                stack.push(symbol);
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    public static boolean paranthesesWithTwoStacks(String input) {
        final char[] symbols = input.toCharArray();
        final LinkedList<Character> active = new LinkedList<>();
        final LinkedList<Character> temp = new LinkedList<>();
        for (int i = 0; i < symbols.length; i++) {
            active.push(symbols[i]);
        }

        while (!active.isEmpty()) {
            Character top = active.pop();
            temp.push(top);
            if (pairs.containsKey(top)) {
                Character oneBelow = active.peek();
                if (oneBelow.equals(pairs.get(top))) {
                    active.pop();
                    temp.pop();
                    pick(active, temp);
                }
            } else {
                break;
            }
        }

        if (active.isEmpty() && temp.isEmpty()) {
            return true;
        }

        return false;
    }

    private static void pick(LinkedList<Character> active, LinkedList<Character> temp) {
        if(!temp.isEmpty()){
            active.push(temp.pop());
        }
    }
}
