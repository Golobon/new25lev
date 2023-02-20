package Lev_29_lec_8_1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods sIWM;

    public CustomInvocationHandler(SomeInterfaceWithMethods sIWM) {
        this.sIWM = sIWM; }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object o = method.invoke(sIWM, args);
        System.out.println(method.getName() + " out");
        return o; } }
