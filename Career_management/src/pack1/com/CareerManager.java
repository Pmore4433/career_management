package pack1.com;

import java.util.Scanner;

public class CareerManager {
    private DataStorage dataStorage = new DataStorage();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\nCareer Management System");
            System.out.println("1. Add User");
            System.out.println("2. View User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    viewUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        User1 user = new User1(name);
        System.out.print("Enter education: ");
        user.setEducation(scanner.nextLine());
        System.out.print("Enter experience: ");
        user.setExperience(scanner.nextLine());
        System.out.print("Enter skills: ");
        user.setSkills(scanner.nextLine());
        System.out.print("Enter career goals: ");
        user.setCareerGoals(scanner.nextLine());
        dataStorage.addUser(user);
        System.out.println("User added successfully.");
    }

    private void viewUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        User1 user = dataStorage.getUser(name);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("User not found.");
        }
    }

    private void updateUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        User1 user = dataStorage.getUser(name);
        if (user != null) {
            System.out.print("Enter new education: ");
            user.setEducation(scanner.nextLine());
            System.out.print("Enter new experience: ");
            user.setExperience(scanner.nextLine());
            System.out.print("Enter new skills: ");
            user.setSkills(scanner.nextLine());
            System.out.print("Enter new career goals: ");
            user.setCareerGoals(scanner.nextLine());
            dataStorage.updateUser(name, user);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    private void deleteUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        dataStorage.removeUser(name);
        System.out.println("User deleted successfully.");
    }
}
