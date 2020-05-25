package com.oleg.test;

//import org.apache.commons.collections4.CollectionUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.omg.CORBA.Object;

//Как найти средний элемент в LinkedList за один проход?
public class MyLinkedListVer1<E> {

  LinkedList list = new LinkedList();

  MyNode  head = null;
  MyNode  tail = null;
  int size=0;

  public MyLinkedListVer1(){
  }

  public MyLinkedListVer1(E data){
    head = new MyNode(data);
    size++;
  }

  public void printReverse(MyNode node){
    if(node!=null){
      printReverse(node.next);
      System.out.print(" "+node.data);
    }
  }

  public void add(E data){
    MyNode l = tail;
    tail = new MyNode(data);
    if (l==null){
      head = tail;
    }else{
      l.next=tail;
    }
    size++;
  }

  @Override
  public String toString() {
    if (size==0){
      return "MyLinkedListUtil empty";
    }
    StringBuilder sb = new StringBuilder();
    MyNode ptr= head;
    while(ptr!=null){
      sb.append(ptr.data).append(",");
      ptr=ptr.next;
    }
    sb.deleteCharAt(sb.length()-1);
    return "MyLinkedListUtil{size=" + size + ",[" + sb.toString()+"]";
  }

  public void makeCycled(){
    tail.next=head;
  }
  public E getMiddle(){
        MyNode middleNode= head;
        MyNode fast= head;
        int count=0;

        while (fast.next!=null){
            fast= fast.next;
            count++;
            if(count%2==0){
              middleNode=middleNode.next;
            }
            if (fast==middleNode){
                throw new RuntimeException("List is Cycled");
            }
        }
        return (E) middleNode.data;
  }
  public boolean isCycled(){

    MyNode fast = head;
    MyNode slow = head;

    while(fast!=null){
      int count = 0;
      fast=fast.next;
      count++;
      if(count%2==0){
        slow=slow.next;
      }
      if(fast==slow){
        return true;
      }
    }
    return false;
  }
  public static class MyNode<E>{
    E data;
    MyNode next;

    MyNode(E data){
      this.data =data;
      next=null;
    }
  }

  //Как развернуть LinkedList, используя рекурсию


}
