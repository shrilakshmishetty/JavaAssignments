//Q3: Write your own Linked List? Add and Remove method mainly?
package com.shri.java;

public class LinkedList1 {
	Node head;
	class Node{
		Node next;
		int value;
		Node(int value){
			this.value=value;
			this.next=null;
			
		}
	}
		Node addFirst(int value) {
			Node newNode=new Node(value);
			if(head==null) {
				head=newNode;
				return head;
			}
			
			newNode.next=head;
			head=newNode;
			return head;
		}
		Node removeFirst() {
			
			if(head==null) {
				System.out.println("no node to remove");
			}
			
			Node curr=head.next;
			head=curr;
			
			return head;
		}
		Node removeLast() {
			
			if(head==null) {
				System.out.println("no node to remove");
			}
			Node curr=head;
			Node prev=curr;
			while(curr.next!=null) {
				prev=curr;
				curr=curr.next;
			}
			prev.next=null;
			
			
			return head;
		}
		void addLast(int value) {
			Node newNode=new Node(value);
			if(head==null) {
				head=newNode;
				return ;
			}
			Node curr=head;
			while(curr.next!=null) {
				curr=curr.next;
			}
			
			curr.next=newNode;
			
		}
		void display() {
			Node node=head;
			while(node!=null) {
				System.out.print(node.value+" ");
				node=node.next;
			}
			System.out.println();
		}
		
	
	public static void main(String[] args) {
		LinkedList1 l=new LinkedList1();
		l.addFirst(2);
	
		l.addFirst(3);
		l.addFirst(4);
		l.addLast(5);
		l.display();
		l.removeFirst();
		l.display();
		l.removeLast();
		l.display();
		
		
	}
	

}
