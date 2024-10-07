import java.util.List;
import java.util.Scanner;
//hello Video
public class Main {
    public static void main(String[] args) {
        TodoItemDAO todoItemDAO = new TodoItemDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add a to-do item");
            System.out.println("2. Delete a to-do item");
            System.out.println("3. View all to-do items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the description of the to-do item: ");
                    String description = scanner.nextLine();
                    todoItemDAO.addTodoItem(new TodoItem(description));
                    System.out.println("Added: " + description);
                    break;

                case 2:
                    List<TodoItem> items = todoItemDAO.getAllTodoItems();
                    if (items.isEmpty()) {
                        System.out.println("No items to delete.");
                    } else {
                        for (int i = 0; i < items.size(); i++) {
                            System.out.println((i + 1) + ". " + items.get(i).getDescription());
                        }
                        System.out.print("Enter the number of the item to delete: ");
                        int index = scanner.nextInt();
                        todoItemDAO.deleteTodoItem(items.get(index - 1).getId());
                        System.out.println("Deleted.");
                    }
                    break;

                case 3:
                    List<TodoItem> todoItems = todoItemDAO.getAllTodoItems();
                    if (todoItems.isEmpty()) {
                        System.out.println("No items in the to-do list.");
                    } else {
                        System.out.println("To-Do List:");
                        for (TodoItem item : todoItems) {
                            System.out.println(item.getId() + ". " + item.getDescription());
                        }
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
