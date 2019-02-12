/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublyList;

import java.util.Scanner;

class Node
{
    Node prev;
    Node next;
    int data;
    Node(int data)
    {
        this.next = null;
        this.prev = null;
        this.data = data;
    }
}
public class DoublyList 
{
    Node head = null;
    Node tail = null;
    
    public Node add(int data)
    {
        Node l = new Node(data);
        if(head == null)
        {
            head = l;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = l;
            l.prev = temp;
            tail = l;
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
                curr.prev = new_node;
                temp.next = new_node;  
                new_node.prev = temp;
            }
        }
    
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
                curr.prev = temp;
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
                        System.out.println("Forward: ");
			while(temp != null)
			{
				System.out.print(temp.data + " ");                             
				temp = temp.next;

			}
                        System.out.println("\n Backward: ");
                        Node temp2 = tail;
                        while(temp2 != null)
			{
				System.out.print(temp2.data + " ");                             
				temp2 = temp2.prev;

			}
		}
	}
}

class Double
{
    public static void main(String[] args)
    {
        DoublyList m = new DoublyList();
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
                System.out.println("LinkedList is: ");
                m.display(a);
                System.out.println("\n Enter the position");
                int pos = sc.nextInt();
                System.out.println("Enter data");
                data = sc.nextInt();
                m.Insert(a, pos , data);
                System.out.println("LinkedList after adding is: ");
                m.display(a);
                System.out.println("\n Enter the position to delete");
                int p = sc.nextInt();
                m.delete(a, p);
                System.out.println("LinkedList after deleting is: ");
                m.display(a);
    }
}
