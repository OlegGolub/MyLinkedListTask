package com.oleg.test;

//Как найти средний элемент в LinkedList за один проход?
public class MyLinkedListVer1<E> {

  MyNode  head = null;
  MyNode  tail = null;
  int size=0;

  public MyLinkedListVer1(){
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
    MyNode ptr = head;
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

  public E getIFromTheLast(int offset){
    MyNode  destNode=head;
    MyNode  fast= head;
    int count = 0;

    while(fast!=null){
      fast=fast.next;
      if(count>offset){
        destNode=destNode.next;
      }
      count ++;
    }
    return (E) destNode.data;
  }

  public void getNthFromTheLast( int offset){
    getNthFromTheLast(head, offset);
  }
  //напечатать рекурсией
  private int getNthFromTheLast(MyNode node, int offset){
     if(node==null)  return 0;
     int index = getNthFromTheLast(node.next, offset) + 1;
     if(offset==index){
       System.out.println(node.data);
     }
     return index;
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
}
