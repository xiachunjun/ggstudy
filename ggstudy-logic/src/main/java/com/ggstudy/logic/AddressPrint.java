package com.ggstudy.logic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class AddressPrint {


    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String addressOf(Object o)
            throws Exception {
        Object[] array = new Object[]{o};

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;
        switch (addressSize) {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);
        }

        return (Long.toHexString(objectAddress));
    }


    public static void printBytes(long objectAddress, int num) {
        for (long i = 0; i < num; i++) {
            int cur = unsafe.getByte(objectAddress + i);
            System.out.print((char) cur);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        try {
            System.out.println(addressOf(Byte.valueOf("1")));
            System.out.println(addressOf(Byte.valueOf("1")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
