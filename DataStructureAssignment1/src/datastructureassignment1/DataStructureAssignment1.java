package datastructureassignment1;

import java.util.*;
public class DataStructureAssignment1 {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Social Network Assignment of Ata Sakik ===");
        System.out.println("\nMenu: \n1. Add User\n2. Add Friend\n3. Find Mutual Friends\n4. Post Message\n5. View News Feed\n6. View Activity Feed\n7. Search User\n8. Remove User\n9. Remove Friend\n10. Friend Recommendations\n11. Exit");

        while (true) {
            System.out.print("Enter your choice (1-11): ");
            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1: // Add User
                    System.out.print("Enter user ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    network.addUser(id, name);
                    break;

                case 2: // Add Friend
                    System.out.print("Enter first user ID: ");
                    int id1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter second user ID: ");
                    int id2 = Integer.parseInt(scanner.nextLine());
                    network.addFriend(id1, id2);
                    break;

                case 3: // Find Mutual Friends
                    System.out.print("Enter first user ID: ");
                    int userId1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter second user ID: ");
                    int userId2 = Integer.parseInt(scanner.nextLine());
                    network.findMutualFriends(userId1, userId2);
                    break;

                case 4: // Post Message
                    System.out.print("Enter user ID: ");
                    int userId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter message content: ");
                    String content = scanner.nextLine();
                    network.postMessage(userId, content);
                    break;

                case 5: // View News Feed
                    System.out.print("Enter user ID: ");
                    int feedUserId = Integer.parseInt(scanner.nextLine());
                    network.viewNewsFeed(feedUserId);
                    break;

                case 6: // View Activity Feed
                    System.out.print("Enter user ID: ");
                    int activityUserId = Integer.parseInt(scanner.nextLine());
                    network.viewActivityFeed(activityUserId);
                    break;

                case 7: // Search User
                    System.out.print("Enter user name to search: ");
                    String searchQuery = scanner.nextLine();
                    network.searchUser(searchQuery);
                    break;

                case 8: // Remove User
                    System.out.print("Enter user ID to remove: ");
                    int removeUserId = Integer.parseInt(scanner.nextLine());
                    network.removeUser(removeUserId);
                    break;

                case 9: // Remove Friend
                    System.out.print("Enter first user ID: ");
                    int user1Id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter second user ID: ");
                    int user2Id = Integer.parseInt(scanner.nextLine());
                    network.removeFriend(user1Id, user2Id);
                    break;

                case 10: // Friend Recommendations
                    System.out.print("Enter user ID: ");
                    int recommendationUserId = Integer.parseInt(scanner.nextLine());
                    network.recommendFriends(recommendationUserId);
                    break;

                case 11: // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
/*
public static void main(String[] args) {
    SocialNetwork network = new SocialNetwork();

    // Adding users
    network.addUser(1, "Nazli");
    network.addUser(2, "Ata");
    network.addUser(3, "Yasemin");
    network.addUser(4, "Furkan");

    // Adding friends
    network.addFriend(1, 2); // Nazli and Ata
    network.addFriend(2, 3); // Ata and Yasemin
    network.addFriend(3, 4); // Yasemin and Furkan

    // Posting messages
    network.postMessage(1, "Hello, this is Nazli's first post!");
    network.postMessage(2, "Good morning from Ata.");
    network.postMessage(3, "Yasemin here, excited about this project!");
    network.postMessage(4, "Furkan checking in!");

    // Viewing news feed
    System.out.println("\n--- News Feed for Ata (User 2) ---");
    network.viewNewsFeed(2);

    // Viewing activity feed
    System.out.println("\n--- Activity Feed for Yasemin (User 3) ---");
    network.viewActivityFeed(3);

    // Finding mutual friends
    System.out.println("\n--- Mutual Friends between Nazli and Yasemin ---");
    network.findMutualFriends(1, 3);

    // Searching for a user
    System.out.println("\n--- Searching for User 'Yasemin' ---");
    network.searchUser("Yasemin");

    // Friend recommendations
    System.out.println("\n--- Friend Recommendations for Nazli (User 1) ---");
    network.recommendFriends(1);

    // Removing a friend
    System.out.println("\n--- Removing friendship between Ata and Yasemin ---");
    network.removeFriend(2, 3);

    // Viewing updated news feed
    System.out.println("\n--- Updated News Feed for Ata (User 2) ---");
    network.viewNewsFeed(2);

    // Removing a user
    System.out.println("\n--- Removing User 'Furkan' ---");
    network.removeUser(4);

    // Final state of the network
    System.out.println("\n--- Final State of the Network ---");
    System.out.println("All remaining users:");
    network.searchUser(""); // Display all users
}

*/