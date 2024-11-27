import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        
        do {
            System.out.println("\n------ To-Do List ------");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks");
            System.out.println("3. Remove a task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;Please tell me who you are.
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 4);
    }

    // Method to add a task to the list
    private static void addTask(Scanner scanner) {
        System.out.print("Enter the task to add: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    // Method to view all tasks
    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show.");
        } else {
            System.out.println("\nYour To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
    // Method to remove all tasks

   private static void removeTask(Scanner scanner) {
    if (tasks.isEmpty()) {
        System.out.println("No tasks to remove.");
    } else {
        viewTasks();
        System.out.print("Enter the task numbers to remove (comma-separated, e.g., 1,3,5): ");
        String input = scanner.nextLine();
        
        // Split the input by commas and parse the task numbers
        String[] taskNumbers = input.split(",");
        ArrayList<Integer> tasksToRemove = new ArrayList<>();

        try {
            for (String number : taskNumbers) {
                int taskNumber = Integer.parseInt(number.trim());
                if (taskNumber > 0 && taskNumber <= tasks.size()) {
                    tasksToRemove.add(taskNumber - 1); // Store zero-based indices
                } else {
                    System.out.println("Invalid task number: " + taskNumber);
                }
            }
            
            // Sort in reverse to avoid index shifting issues when removing
            tasksToRemove.sort((a, b) -> b - a);

            for (int index : tasksToRemove) {
                tasks.remove(index);
            }

            System.out.println("Selected tasks removed successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers separated by commas.");
        }
    }
}

    
    }

