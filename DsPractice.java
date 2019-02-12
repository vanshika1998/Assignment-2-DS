/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dspractice;

import java.util.Scanner;

 

class Node
{
	int data;
	Node next;
	Node(int data)
	{
		this.data = data;
		this.next = null; 
	}
}

class LinkedList
{
    Node head = null;
	public Node add(int data)
	{
		if(head == null)
		{
			head = new Node(data);
		}
		else
		{
			Node temp = head;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = new Node(data);
		}
		return head;
	}
        
        public void Insert(Node a , int pos , int data)
        {
            Node new_node = new Node(data);
            if(a == null)
            {
                return;
            }
            else
            {
                Node temp = head;
                for(int i=1  ; i<pos-1 ; i++)
                {
                    temp = temp.next;
                }
                Node curr = temp.next;
                new_node.next = curr;
                temp.next = new_node;                
            }
        }
//        
//        public void deletebeg(Node a)
//        {
//            if(head == null)
//            {
//                return;
//            }
//            else
//            {
//                Node temp = head;
//                head = temp.next;
//                temp.next = null;
//            }            
//        }
//        
//        public void deleteend(Node a)
//        {
//            if(head == null)
//            {
//                return;
//            }
//            else
//            {
//                Node temp = head;
//                while(temp.next.next != null)
//                {
//                    temp = temp.next;
//                }
//                temp.next=null;
//            }            
//        }
        
        public void delete(Node a , int pos)
        {
            if(head == null)
            {
                return;
            }
            else
            {
                Node temp = head;
                for(int i=1 ; i<pos-1 ; i++)
                {
                    temp = temp.next;
                }
                Node curr = temp.next.next;
                temp.next = curr;
            }
        }

	public void display(Node a)
	{
		if(a == null)
		{
			return;
		}
		else
		{
			Node temp = head;
			while(temp != null)
			{
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
	}
}
public class DsPractice 
{
    public static void main(String[] args) 
    {
        LinkedList m = new LinkedList();
        Scanner sc = new Scanner(System.in);
		Node a = null;
		int data;
		System.out.println("Enter the size");
		int n = sc.nextInt();
		System.out.println("Enter the elements");
		for(int i=0 ; i<n ; i++)
		{
			data = sc.nextInt();
			a = m.add(data);
		} 
                System.out.println("Enter the position to add");
                int pos = sc.nextInt();
                System.out.println("Enter data");
                data = sc.nextInt();
                m.Insert(a, pos , data);
//                m.deletebeg(a);
//                m.deleteend(a);
                System.out.println("Enter the position to delete");
                int p = sc.nextInt();
                m.delete(a, p);
                System.out.println("LinkedList is: ");
                m.display(a);
    }
    
}
