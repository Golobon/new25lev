package Lev_29_lec_8_2;

import Lev_29_lec_8_1.CustomInvocationHandler;
import Lev_29_lec_8_1.SomeInterfaceWithMethods;
import Lev_29_lec_8_1.SomeInterfaceWithMethodsImpl;

import java.lang.reflect.Proxy;

/*
Дженерики для создания прокси-объекта
*/

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
    public Item getProxy(Class cl, Class ... interf) {
        Class[] interfaces = new Class[interf.length + 1];
        interfaces[0] = cl;
        for (int i = 0; i < interf.length; i++) { interfaces[i + 1] = interf[i]; }
        return (Item) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                interfaces,
                new ItemInvocationHandler()); } }
