class UndoBuffer {

    String[] data;
    int top;

    // Constructor
    UndoBuffer(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
    }

    // Push
    boolean push(String edit) {
        if (top == data.length - 1) {
            System.out.println("Stack Overflow! Undo buffer is full.");
            return false;
        }

        data[++top] = edit;
        return true;
    }

    // Pop
    String pop() {
        if (isEmpty()) {
            return "Nothing to undo";
        }

        return data[top--];
    }

    // Peek
    String peek() {
        if (isEmpty()) {
            return "Nothing to show";
        }

        return data[top];
    }

    // Check Empty
    boolean isEmpty() {
        return top == -1;
    }

    // Display Stack
    void display() {
        if (isEmpty()) {
            System.out.println("Undo Buffer is Empty");
            return;
        }

        System.out.println("Undo Buffer:");

        for (int i = top; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }

    // Main Method
    public static void main(String[] args) {

        UndoBuffer ub = new UndoBuffer(5);

        ub.push("Typed Hello");
        ub.push("Added World");
        ub.push("Deleted Line");

        ub.display();

        System.out.println("Top Edit: " + ub.peek());

        System.out.println("Undo: " + ub.pop());

        ub.display();
    }
}