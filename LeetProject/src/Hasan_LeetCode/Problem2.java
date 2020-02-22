package Hasan_LeetCode;
/*
 * You are given two non-empty linked lists representing two 
 * non-negative integers. The digits are stored in reverse order
 * and each of their nodes contain a single digit. Add the two 
 * numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, 
 * except the number 0 itself.
 * 
 * Example: 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 */

public class Problem2 {
	
	// To Understand LinkedList
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
		/*public int data(){
			return data;
		}*/
	}
	
	
	public static class LinkedList{
		Node head;
		
		//insert integer type data in to the linked list
		static LinkedList insert(LinkedList list, int data){ 
			Node new_node=new Node(data);
			new_node.next=null;
			if(list.head==null){
				list.head=new_node;
				//list.head.next=null;
			}
			else{
			    Node last=list.head;
			    while(last.next!=null){
			    	last=last.next;
			    }
				last.next=new_node;
			}
			
			return list;
		}
		
		// to search a specific data in the linked list
		
		static boolean search(LinkedList list, int data){
			
			Node curr_node=list.head;
			while(curr_node!=null){
				if(curr_node.data==data){
					return true;
				}
					curr_node=curr_node.next;
				
			}
			return false;
		}
		
		//to delete a specific data in the linked list
		
		public static LinkedList delete(LinkedList list, int data){
			Node curr_node=list.head, prev_node=null;
			
			return list;
		}
		
		public static void printList(LinkedList list){
			Node curr_node=list.head;
			System.out.print("Linkedlist: ");
			while(curr_node!=null){
				System.err.print(curr_node.data+" ");
				curr_node=curr_node.next;
			}
		}
	}
	
	public static void main(String[] args){
		LinkedList list= new LinkedList();
		list=list.insert(list,1);
		list=list.insert(list,2);
		list=list.insert(list,3);
		list=list.insert(list,4);
		list.printList(list);
		
		if(list.search(list, 3)==true){
			System.out.println("\nThis data exists in the linked list");
		}
		
	}

	

}
