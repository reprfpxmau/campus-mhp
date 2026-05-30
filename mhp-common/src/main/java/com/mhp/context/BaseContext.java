package com.mhp.context;

public class BaseContext {

    //用户ID
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    //角色
    private static ThreadLocal<String> threadLocalRole = new ThreadLocal<>();

    //设置用户ID
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }
    public static Long getCurrentId() {
        return threadLocal.get();
    }
    //移除用户ID
    public static void removeCurrentId() {
        threadLocal.remove();
    }

    //设置角色
    public static void setCurrentRole(String role) {
        threadLocalRole.set(role);
    }
    public static String getCurrentRole() {
        return threadLocalRole.get();
    }
    //移除角色
    public static void removeCurrentRole() {
        threadLocalRole.remove();
    }
}
