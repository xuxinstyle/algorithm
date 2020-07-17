import org.junit.Test;

import java.util.*;

public class QueueTest {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("1");
        deque.add("2");
        deque.add("3");

        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.poll());
        Stack stack = new Stack();

    }

    @Test
    public void testPriorityQueue() {

        Map<String, String> map = new HashMap<String, String>();

        //Queue是一个抽象的，LinkedList是一个具体的实现类
        Queue<Integer> q = new PriorityQueue<Integer>();
        q.add(10);
        q.add(8);
        System.out.println("添加一个元素之后" + q);
        q.add(9);
        System.out.println("添加两个元素之后" + q);
        //    q.add(1);
        System.out.println("添加三个元素之后" + q);


        while (!q.isEmpty()) {
            q.remove();
            System.out.println("移除元素之后" + q);
        }

        Queue<Integer> q1 = new LinkedList<Integer>();
        q1.add(10);
        q1.add(8);
        System.out.println("添加一个元素之后" + q1);
        q1.add(9);
        System.out.println("添加两个元素之后" + q1);
        //    q.add(1);
        System.out.println("添加三个元素之后" + q1);
        while (!q1.isEmpty()) {
            q1.remove();
            System.out.println("移除元素之后" + q1);
        }

    }
}
