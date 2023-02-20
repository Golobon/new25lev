package Lev_29_lec_8_1;

import java.lang.reflect.Proxy;

/*
Создание прокси-объекта
*/

public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
        SomeInterfaceWithMethods sIWMI = new SomeInterfaceWithMethodsImpl();
        ClassLoader loader = sIWMI.getClass().getClassLoader();
        Class[] interfaces = sIWMI.getClass().getInterfaces();
        CustomInvocationHandler cIH = new CustomInvocationHandler(sIWMI);
        return (SomeInterfaceWithMethods) Proxy.newProxyInstance(loader, interfaces, cIH); } }
