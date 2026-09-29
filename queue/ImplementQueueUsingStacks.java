"""
Implement a first in first out (FIFO) queue using only two stacks.
The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.

Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
"""

class MyQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {}

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        // check if the stack2 is empty
        if (stack2.isEmpty() == true){
            // loop as long as stack1 is not empty
            while( stack1.isEmpty() == false ){
                // push the value returned by pop() & removed from stack1
                stack2.push(stack1.pop());
            }
        }
        // return the value removed from stack2
        return stack2.pop();
    }

    public int peek() {
        // check if the stack2 is empty
        if (stack2.isEmpty() == true){
            // loop as long as stack1 is not empty
            while( stack1.isEmpty() == false ){
                // push the value returned by pop() & removed from stack1
                stack2.push(stack1.pop());
            }
        }
        // return the value at the top of stack2
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}