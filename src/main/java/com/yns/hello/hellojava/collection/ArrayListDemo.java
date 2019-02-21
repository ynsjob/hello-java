package com.yns.hello.hellojava.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class ArrayListDemo {


    /**
     * java9的新特性
     */
    @Test
    public void listTest(){

        /**
         * java9 之前
         */
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("World");

        arrayList.forEach(
                e->{log.info("result={}",e);});


        /**
         * java9
         */
        List<String> list = List.of("Hello", "World");
        list.forEach(
                e->{log.info("result={}",e);});

    }


    /**
     * 要想实现线程安全，可使用Collections.synchronizedCollection()系列
     *
     * 它的实现，基本就是将每个基本方法，比如 get、set、add 之类，都通过 synchronizd 添加基本的同步支持，非常简单粗暴，但也非常实用。
     * 注意这些方法创建的线程安全集合，都符合迭代时 fail-fast 行为，当发生意外的并发修改时，尽早抛出 ConcurrentModificationException 异常，以避免不可预计的行为。
     */
    @Test
    public void arrayList(){

        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<String>());



    }

}
