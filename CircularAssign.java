/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CircularList;

import java.util.Scanner;

class Node2
{
    Node2 next;
    int data;
    Node2 prev;
    Node2(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Circular2
{
    Node2 head = null;
    Node2 tail = null;
    
    public Node2 add(int data)
    {
        Node2 l = new Node2(data);
        if(head == null)
        {
            head = l;
            head.next = head;
            head.prev = head;
        }
        else
        {
            Node2 temp = head;
            while(temp.next != head)
            {
                temp = temp.next;
            }
            temp.next = l;
            l.prev = temp;
            l.next = head;
            tail = l;
            head.prev = tail;
        }
        return head;
    }
    
    public void insertpos(int data , int pos)
    {
        Node2 new_node = new Node2(data);
        if(head == null)
        {
            return;
        }
        else
        {
            Node2 temp = head;
            for(int i=1 ; i<pos-1 ; i++)
            {
                temp = temp.next;
            }
            Node2 curr = temp.next;
            new_node.next = curr;
            curr.prev = new_node;
            temp.next = new_node;
            new_node.prev = temp;
        }
    }
    
    public void deletepos(int pos)
    {
        if(head == null)
        {
            return;
        }
        else
        {
            Node2 temp = head;
            for(int i=1 ; i<pos-1 ; i++)
            {
                temp = temp.next;
            }
            Node2 curr = temp.next.next;
            temp.next = curr;
            curr.prev = temp;
        }
    }
    
    public void display(Node2 a)
    {
        if(a == null)
        {
            return;
        }
        else
        {
            System.out.print("Forward: ");
            Node2 temp = head;
            do
            {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }while(temp != head);
            
            System.out.print("\nBackward: ");
            Node2 temp2 = tail;
            do
            {
                System.out.print(temp2.data+" ");
                temp2 = temp2.prev;
            }while(temp2 != tail);
        }
    }
}

public class CircularAssign 
{
    public static void main(String[] args)
    {
        Circular2 m = new Circular2();
        Scanner sc = new Scanner(System.in);
        Node2 b = null;
	int data;
	System.out.println("Enter the size");
	int n = sc.nextInt();
	System.out.println("Enter the elements");
	for(int i=0 ; i<n ; i++)
	{
	    data = sc.nextInt();
	    b = m.add(data);
	} 
        System.out.println("CircularList is: ");
        m.display(b);
        System.out.println("\n Enter the position");
        int pos = sc.nextInt();
        System.out.println("Enter data");
        data = sc.nextInt();
        m.insertpos(data , pos);
        System.out.println("CircularList after adding is: ");
        m.display(b);
        System.out.println("\n Enter the position");
        int p = sc.nextInt();
        m.deletepos(p);
        System.out.println("CircularList after deleting is: ");
        m.display(b);
    }
}
