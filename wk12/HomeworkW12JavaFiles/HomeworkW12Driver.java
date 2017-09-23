import java.util.*;

public class HomeworkW12Driver {

    public static void main(String[] args) {   
    	        
        // Q16 print in order
        StackInterface s = new LinkedStack();
        System.out.println("**********Q16");
        System.out.println("Should print cat, dog, hamster, zebra (one per line)");
        s.push("cat");
        s.push("dog");
        s.push("hamster");
        s.push("zebra");
        printInAddOrder(s);
        System.out.println();
    		
        // Q17 min on top
        System.out.println("**********Q17");
    	ArrayStack<Integer> numStack = new ArrayStack<>();
    	addToMinStack(numStack, 8);
    	System.out.println("Top of stack should be 8");
    	numStack.display(); // NOTE: THIS RELIES ON YOUR DISPLAY METHOD FROM Q19
    	addToMinStack(numStack, 4);
    	System.out.println("Top of stack should be 4");
    	numStack.display(); 
    	addToMinStack(numStack, 3);
    	System.out.println("Top of stack should be 3");
    	numStack.display();
    	addToMinStack(numStack, 6);
    	System.out.println("Top of stack should be 3");
    	numStack.display();    	
    	addToMinStack(numStack, 7);
    	System.out.println("Top of stack should be 3");
    	numStack.display();
    	addToMinStack(numStack, 1);
    	System.out.println("Top of stack should be 1");
    	numStack.display();
    	
        
		// Q18 fibonacci numbers
    	System.out.println("**********Q18");
    	int fibNum = 9;
    	System.out.println("Fib recursive should be the same as Fib using stacks (" + fibonacciRecursive(fibNum)  +
    			"): " + fibonacciStack(fibNum));
    	System.out.println();
    	
    	// Q19 display methods    	
    	System.out.println("**********Q19");
    	ArrayStack displayArrayStack = new ArrayStack();
    	System.out.println("Should give a message that the stack is empty.");
    	displayArrayStack.display();
    	displayArrayStack.push("California");
    	displayArrayStack.push("Florida");
    	displayArrayStack.push("Georgia");
    	displayArrayStack.push("Hawaii");
    	System.out.println("Should print BOTTOM California Florida Georgia Hawaii TOP");
    	displayArrayStack.display();
    	System.out.println();
    	
    	System.out.println("**********Q20");
    	LinkedStack displayLinkedStack = new LinkedStack();
    	System.out.println("Should give a message that the stack is empty.");
    	displayLinkedStack.display();
    	displayLinkedStack.push("Alaska");
    	displayLinkedStack.push("Delaware");
    	displayLinkedStack.push("Iowa");
    	displayLinkedStack.push("New York");
    	System.out.println("Should print BOTTOM Alaska Delaware Iowa New York TOP");
    	displayLinkedStack.display();

    	
    	// QEC1 peek2 in LinkedStack
    	
		System.out.println("**********EC1");
    	LinkedStack peekStackLinked = new LinkedStack();
    	System.out.println("Should print null/throw exception: " + peekStackLinked.peek2());
    	peekStackLinked.push("hello");
    	System.out.println("Should print null/throw exception: " + peekStackLinked.peek2());
    	peekStackLinked.push("goodbye");
    	System.out.println("Should print hello: " + peekStackLinked.peek2());
    	peekStackLinked.push("and good night");
    	System.out.println("Should print goodbye: " + peekStackLinked.peek2());
    	System.out.println();
    	
    	
    	//QEC2 peek2 in ArrayStack
    	
		System.out.println("**********QEC2");
    	ArrayStack peekStackArray = new ArrayStack();
    	System.out.println("Should print null/throw exception: " + peekStackArray.peek2());
    	peekStackArray.push("hello");
    	System.out.println("Should print null/throw exception: " + peekStackArray.peek2());
    	peekStackArray.push("goodbye");
    	System.out.println("Should print hello: " + peekStackArray.peek2());
    	peekStackArray.push("and good night");
    	System.out.println("Should print goodbye: " + peekStackArray.peek2());
    	System.out.println();
    		
    }       
    
    public static void printInAddOrder(StackInterface stack) {
    	StackInterface tmpStack = new LinkedStack();
        while (!stack.isEmpty()){
            tmpStack.push(stack.pop());
        }
        while (!tmpStack.isEmpty()){
            Object tmp = tmpStack.pop();
            System.out.println(tmp);
            stack.push(tmp);
        }
    }
    public static void addToMinStack(StackInterface<Integer> stack, int newVal) {
        int min;
        if (stack.isEmpty()){
            stack.push(newVal);
            min = newVal;
            return; 
        } else {
            min = stack.peek();
            if (newVal< min){ // new insert is the smallest element
                min = newVal;
                stack.push(newVal);
            } else { // new insert is not the smallest element
                min = stack.pop(); 
                stack.push(newVal);
                stack.push(min);
            }
        }
    } 
    
    public static int fibonacciRecursive(int n) {
    	if(n==1 || n ==2) {
    		return 1;
    	} else {
    		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    	}
    }
    public static int fibonacciStack(int n) {
    	StackInterface tmpStack = new LinkedStack();
        for (int i=1; i<=n; i++){
            if (i==1 || i==2){
                tmpStack.push(1);
            } else {
                int prev = (int) tmpStack.pop();
                int prevPrev = (int) tmpStack.pop();
                int newVal = prev+prevPrev;
                tmpStack.push(prev);
                tmpStack.push(newVal);
            }
        }
        return (int) tmpStack.peek();
    }
    
}