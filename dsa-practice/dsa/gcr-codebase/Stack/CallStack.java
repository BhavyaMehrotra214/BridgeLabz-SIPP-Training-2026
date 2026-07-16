class CallStack {

    // Node class
    static class Frame {
        String functionName;
        Frame next;

        Frame(String functionName) {
            this.functionName = functionName;
            this.next = null;
        }
    }

    Frame top = null;

    // Push
    void push(String functionName) {
        Frame newNode = new Frame(functionName);

        newNode.next = top;
        top = newNode;
    }

    // Pop
    String pop() {
        if (isEmpty()) {
            return "No active function";
        }

        String name = top.functionName;
        top = top.next;

        return name;
    }

    // Peek
    String peek() {
        if (isEmpty()) {
            return "Stack is Empty";
        }

        return top.functionName;
    }

    // Check Empty
    boolean isEmpty() {
        return top == null;
    }

    // Display Stack
    void display() {
        if (isEmpty()) {
            System.out.println("Call Stack is Empty");
            return;
        }

        System.out.println("Current Call Stack:");

        Frame temp = top;

        while (temp != null) {
            System.out.println(temp.functionName);
            temp = temp.next;
        }
    }

    // Main Method
    public static void main(String[] args) {

        CallStack cs = new CallStack();

        cs.push("main()");
        cs.push("login()");
        cs.push("validateUser()");

        cs.display();

        System.out.println("Current Function: " + cs.peek());

        System.out.println("Returned From: " + cs.pop());

        cs.display();
    }
}