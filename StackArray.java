// Stacks
/**
* Abstract Data types: Linear (stacks(LIFO), lists, queues) vs non-linear
* Can be implemented using arrays and linked lists.
* top -1 this variable keeps tabs on the index of the element at the top of the stack
* top = -1 means the stack is empty... trying to pop/delete from an empty stack causes a STACK UNDERFLOW ERROR
* top = n-1 means stack is full.. trying to insert into a full stack causes a STACK OVERFLOW error
* size = keeps track of no. of items
* pop and push
*/ 

// Queues
/**
* Simple vs. circular FIFO
* Variables: front/head, rear/back/tail .. index 
* Inserted from one end, deleted from the other. First element is deleted. 
* Enqueue takes place at the tail, Dequeue takes place at the head
* front = read .. 1 element
* front = rear + 1 queue is full 
* THE ABOVE LINE DOES NOT FULLY MAKE SENSE.. DOES IT APPLY FOR BOTH SIMPLE AND CIRCULAR QUEUES

*
*/
import java.util.Scanner;
public class StackArray{
	private int top = -1; // index of the top element in the stack
	private int size = 0; 
	private int maxSize; // max size of the stack
	private int[] array;
	
	// constructor to initialize the stacks
	StackArray (int size){
		maxSize = size;
		array = new int[size];
	}
	// insert element to the stack
	public void push(int elem){
		if (top == maxSize-1)
			throw new RuntimeException("Stack Overflow! Cannot push any new items");		
		else{
			top = top+1;
			array[top] = elem;
			size++;
		}
	}
	public int pop(){
		if (top == -1){
			throw new RuntimeException("Stack Underflow! Cannot pop an empty stack");
		}
		else{
			int popped = array[top];
			array[top] = 0;
			top = top-1;
			size--;
			return popped;			
		}
	}
	public boolean isEmpty(){
		if (top == -1)
			return true;
		else
			return false;		
	}
	public int length(){
		return size;
	}
	public int peek(){
		if (top == -1)
			throw new RuntimeException("Stack is empty");
		else
			return array[top];
	}
	
	public static void main(String[] args){
		StackArray stack1 = new StackArray(7);
		System.out.println("This stack is implemented using an array\nStack has been created");
		
		while (true){
			System.out.println("\nChoose an operation: ");
			System.out.println("0. Exit application \n1. Add element \n2. Remove element \n3. Check if stack is empty \n4. Retrieve element at the top \n5. Get number of elements in stack");
			Scanner keyboard = new Scanner(System.in);
			
			int input = keyboard.nextInt();
			if (input == 0)
				System.exit(0);
			else if(input == 1){
				System.out.print("Enter element to be added: ");
				int value = keyboard.nextInt();
				try{
					stack1.push(value);
				}catch (RuntimeException e){
					System.out.println(e.getMessage());
				}				
			}
			else if(input == 2){
				try{
					System.out.println(stack1.pop());
				} catch (RuntimeException e){
					System.out.println(e.getMessage());	
				}
			}
			else if(input == 3){
				System.out.println(stack1.isEmpty());
			}
			else if(input == 4){
				try{
					System.out.println(stack1.peek());
				} catch (RuntimeException e){
					System.out.println(e.getMessage());	
				}
			}
			else if(input == 5){
				System.out.println(stack1.length());
			}
			else
				System.out.println("Invalid command");
		}
	}
}