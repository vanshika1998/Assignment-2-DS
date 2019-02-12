/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dspractice;

import java.util.Scanner;

class node
{
	int data;
	node next;
	node(int data)
	{
		this.data = data;
		this.next = null; 
	}
}

class Linked
{
    node head = null;
	public node add(int data)
	{
		if(head == null)
		{
			head = new node(data);
		}
		else
		{
			node temp = head;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = new node(data);
		}
		return head;
	}
        
        public void Insert(node a , int pos , int data)
        {
            node new_node = new node(data);
            if(a == null)
            {
                return;
            }
            else
            {
                node temp = head;
                for(int i=1  ; i<pos-1 ; i++)
                {
                    temp = temp.next;
                }
                node curr = temp.next;
                new_node.next = curr;
                temp.next = new_node;                
            }
        }
        
        public void ques(node a)
        {
            if(head == null)
            {
                return;
            }
            else
            {
                node temp = head;
                node temp2 = head;
                while(temp != null)
                {
                    while(temp2!=null)
                    {
                        if(temp.data + temp2.data == 0)
                        { 
                            delete(temp.data);
                            delete(temp2.data);
                        }
                        temp2 = temp2.next;
                    }
                    temp = temp.next;
                    temp2 = head;
                }
                
            }
        }
        
        public void delete(int data)
        {
            if(head.data == data )
            {
                node temp = head.next;
                head = temp;
            }
            else
            {
                node temp = head;
                node temp2 = null;
                while(temp != null && temp.data != data)
                {
                    temp2 = temp;
                    temp = temp.next;
                }
                temp2.next = temp.next;
            }
        }

	public void display(node a)
	{
		if(a == null)
		{
			System.out.println("List is empty");
		}
		else
		{
			node temp = head;
			while(temp != null)
			{
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
	}
}
public class LinkedQue 
{
   public static void main(String[] args)
   {
       Linked m = new Linked();
        Scanner sc = new Scanner(System.in);
	node a = null;
	int data;
	System.out.println("Enter the size");
	int n = sc.nextInt();
	System.out.println("Enter the elements");
	for(int i=0 ; i<n ; i++)
	{
            data = sc.nextInt();
	    a = m.add(data);
	} 
        System.out.println("List is:");
        m.display(a);
        m.ques(a);
        System.out.println("\nList after editing is:");
        m.display(a);
   }
}
