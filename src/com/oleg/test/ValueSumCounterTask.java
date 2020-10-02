package com.oleg.test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


interface Node {
    Node getChild();

    long getValue();
}

class NodeImpl implements Node {
    int value;
    Node child;

    NodeImpl(int value, Node child) {
        this.value = value;
        this.child = child;
    }

    @Override
    public Node getChild() {
        return child;
    }

    @Override
    public long getValue() {
        return value;
    }
}


public class ValueSumCounterTask extends RecursiveTask<Long> {
    private final Node node;

    public ValueSumCounterTask(Node node) {
        this.node = node;
    }

    @Override
    protected Long compute() {

        long sum = node.getValue();

        Node child = node.getChild();
        if(child!=null) {
            System.out.println("compute: Object is: " + this.node.getValue());

            ValueSumCounterTask taskChild = new ValueSumCounterTask(child);
            taskChild.fork(); // запустим асинхронно

            sum += taskChild.join(); // дождёмся выполнения задачи и прибавим результат;
        }
        return sum;
    }


    public static void main(String[] args) {
        Node root = new NodeImpl(1, new NodeImpl(2, new NodeImpl(3, new NodeImpl(4, null))));
        ForkJoinPool pool = new ForkJoinPool();
        Long sum = pool.invoke(new ValueSumCounterTask(root));
        System.out.println("sum=" + sum);
    }
}

