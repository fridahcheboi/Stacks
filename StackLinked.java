import java.util.Scanner;
class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}
}
public class StackLinked{
	int size = 0;
	private Node top;
	
	StackLinked(){
		this.top = null;
	}
	
	public void push(int element){
		Node n = new Node(element);
		
		if (isEmpty())
			top = n;
		else{
			n.next = top;
			top = n;
		}
		size++;
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack Underflow! Cannot pop an empty stack");
			return -1;
		}else {
			int popped = top.data;
			top = top.next;
			size--;
			return popped;
		}
	}
	
	public int peek(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return -1;
		}else
			return top.data;		
	}
	public boolean isEmpty(){
		return (top== null);
	}
	public int length(){
		return size;
	}
	public static void main(String[] args){
		StackLinked stack2 = new StackLinked();
		System.out.println("This stack is implemented using a linked list\nStack has been created");
		
		Scanner keyboard = new Scanner(System.in);
		while (true){
			System.out.println("\nChoose an operation: ");
			System.out.println("0. Exit application \n1. Add element \n2. Remove element \n3. Check if stack is empty \n4. Retrieve element at the top \n5. Get number of elements in stack");
			
			int input = keyboard.nextInt();
			if (input == 0)
				System.exit(0);
			else if(input == 1){
				System.out.print("Enter element to be added: ");
				int value = keyboard.nextInt();
				stack2.push(value);				
			}
			else if(input == 2)
				System.out.println(stack2.pop());
			else if(input == 3)
				System.out.println(stack2.isEmpty());
			else if(input == 4)
				System.out.println(stack2.peek());
			else if(input == 5)
				System.out.println(stack2.length());
			else
				System.out.println("Invalid command");
		}
		// keyboard.close();		
	}
}