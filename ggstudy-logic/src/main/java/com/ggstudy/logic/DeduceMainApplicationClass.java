package com.ggstudy.logic;

public class DeduceMainApplicationClass {
    private Class<?> deduceMainApplicationClass() {
        try {
            StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if ("main".equals(stackTraceElement.getMethodName())) {
                    return Class.forName(stackTraceElement.getClassName());
                }
            }
        }
        catch (ClassNotFoundException ex) {
            // Swallow and continue
        }
        return null;
    }
    private Class<?> a() {
      return this.deduceMainApplicationClass();
    }
    private Class<?> b() {
        return this.a();
    }

    public static void main(String[] args) {
        DeduceMainApplicationClass dm=new DeduceMainApplicationClass();
        System.out.println(dm.b());
    }

}
