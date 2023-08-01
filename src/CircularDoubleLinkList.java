import java.util.Scanner;

class Node
{
    int value;
    Node next;
    Node prev;
    public Node(int value)
    {
        this.value = value;
    }
}
public class CircularDoubleLinkList {
    Node head;
    Node tail;
    int length;
    CircularDoubleLinkList(int value)
    {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        newNode.next = head;
        newNode.prev = tail;
        length = 1;
    }

    public void Append(int value)
    {
        Node newNode = new Node(value);
        if(length == 0)
        {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = tail;
        }
        else {
            newNode.next = tail.next;
            newNode.prev=head.prev;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        length++;
    }

    public void Prepend(int value)
    {
        Node newNode = new Node(value);
        if(length == 0)
        {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = tail;
        }
        else {
            newNode.next = tail.next;
            newNode.prev=head.prev;
            tail.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node RemoveFromEnd()
    {
        if(length == 0)
        {
            return null;
        }
        Node temp = tail;
        if(length == 1)
        {
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
            temp.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node RemoveFromFirst()
    {
        if(length == 0)
        {
            return null;
        }
        Node temp = head;
        if(length == 1)
        {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
            temp.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public void display()
    {
        Node temp = head;
        if(head == null)
        {
            System.out.println("Empty");
        }
        else {
            do{
                System.out.println(temp.value);
                temp = temp.next;
            }while (temp != head);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularDoubleLinkList circular = new CircularDoubleLinkList(4);
        circular.Append(5);
        circular.display();
        circular.Prepend(6);
        circular.display();
        circular.Append(7);
        circular.display();
        circular.Prepend(8);
        circular.display();
        System.out.println("Removed from End:"+circular.RemoveFromEnd().value);
        circular.display();
        System.out.println("Removed from first:"+circular.RemoveFromFirst().value);
        circular.display();
    }
}
