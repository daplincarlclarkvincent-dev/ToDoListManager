public class ToDoList {
    private TaskNode head;

    public void addTask(String title) {
        TaskNode newNode = new TaskNode(title);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("\nTask added!");
    }

    public void deleteTask(String title) {
        if (head == null) {
            System.out.println("\nTask list is empty.");
            return;
        }

        if (head.title.equals(title)) {
            head = head.next;
            System.out.println("\nTask deleted!");
            return;
        }

        TaskNode current = head;
        while (current.next != null && !current.next.title.equals(title)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("\nTask not found.");
        } else {
            current.next = current.next.next;
            System.out.println("\nTask deleted!");
        }
    }

    public void printTasks() {
        if (head == null) {
            System.out.println("\nNo tasks found.");
            return;
        }

        System.out.println("\nYour Tasks:");
        TaskNode current = head;
        while (current != null) {
            System.out.println("- " + current.title);
            current = current.next;
        }
    }

    public boolean contains(String title) {
        TaskNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Optional Bonus
    public int countTasks() {
        int count = 0;
        TaskNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Optional Bonus
    public void insertAt(int index, String title) {
        TaskNode newNode = new TaskNode(title);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        TaskNode current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                System.out.println("Index out of bounds.");
                return;
            }
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }
}
