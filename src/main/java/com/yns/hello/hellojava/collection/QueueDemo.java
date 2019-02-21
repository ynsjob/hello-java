package com.yns.hello.hellojava.collection;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.Serializable;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Queue/Deque，则是 Java 提供的标准队列结构的实现，除了集合的基本功能，
 * 它还支持类似先入先出（FIFO， First-in-First-Out）或者后入先出（LIFO，Last-In-First-Out）等特定行为。
 * 这里不包括 BlockingQueue，因为通常是并发编程场合，所以被放置在并发包里。
 */
@Slf4j
public class QueueDemo {

    @Getter
    @Setter
    @ToString
    class Member implements Serializable,Comparable {
        private String name ;
        private int level;

        @Override
        public int compareTo(Object o) {
            Member member = (Member) o;
            if (member.getLevel() > this.level){
                return 1;
            }else if (member.getLevel() == this.level){
                return 0;
            }
            return -1;
        }
    }

    @Test
    public void queueTest(){

        /**
         * 这个是非线程安全的
         */
        Queue<String> queue = new PriorityQueue<>();
        queue.add("云纳胜");
        queue.add("曲俊宇");
        queue.add("侯沛");
        queue.add("黄勇");

//        priorityQueue.forEach(element->{
//            log.info("priorityQueue name={}",element);
//        });

        log.info("获取第一个元素:{},size={}",queue.peek(),queue.size());
        log.info("获取第一个元素并删除:{},size={}",queue.poll(),queue.size());
        log.info("添加元素:{},size={}",queue.offer("田旭"),queue.size());

        queue.forEach(
                q->{ log.info("priorityQueue name={}",q);
        });

    }

    /**
     * 比如你需要实现一个云计算任务调度系统，希望可以保证 VIP 客户的任务被优先处理，
     * 你可以利用哪些数据结构或者标准的集合类型呢？
     * 更进一步讲，类似场景大多是基于什么数据结构呢？
     */
    @Test
    public void queueSortTest(){
        PriorityQueue<Member> queue = new PriorityQueue();

        Member member = new Member();
        member.setName("云纳胜");
        member.setLevel(1);

        Member member2 = new Member();
        member2.setName("曲俊宇");
        member2.setLevel(2);

        Member member3 = new Member();
        member3.setName("侯沛");
        member3.setLevel(3);

        Member member4 = new Member();
        member4.setName("黄勇");
        member4.setLevel(4);

        queue.offer(member);
        queue.offer(member2);
        queue.offer(member3);
        queue.offer(member4);

        queue.forEach( m->{ log.info("name={},level={}",m.name,m.level); });

        log.info("-------排序前后分隔符-------------");

        while (!queue.isEmpty()){
            log.info("sort:{}",queue.poll().toString());
        }
    }

    @Test
    public void queueTest3(){

    }
}
