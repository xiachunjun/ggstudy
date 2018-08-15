package com.ggstudy.logic;

import java.util.List;

public class NullTest {
    private List list;

   public NullTest(List list){
       this.list=list;
   }

    public static void main(String[] args) {
        NullTest ne=new NullTest((List) null);
    }
}
