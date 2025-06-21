
package datastructureassignment1;

import java.util.*;
public class SocialNetwork {
    private HashMap<Integer, User> users;
    private HashMap<Integer, List<Integer>> adjacencyList;

    public SocialNetwork() {
        this.users = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }

    // Add a new user to the system
    public void addUser(int id, String name) {
        if (!users.containsKey(id)) {
            users.put(id, new User(id, name));
            adjacencyList.put(id, new ArrayList<>());
            System.out.println("User added: " + name);
        } else {
            System.out.println("User with ID " + id + " already exists.");
        }
    }

    // Add a friendship between two users
    public void addFriend(int id1, int id2) {
        if (users.containsKey(id1) && users.containsKey(id2)) {
            adjacencyList.get(id1).add(id2);
            adjacencyList.get(id2).add(id1);
            System.out.println(users.get(id1).getName() + " and " + users.get(id2).getName() + " are now friends.");
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int id1, int id2) {
        if (users.containsKey(id1) && users.containsKey(id2)) {
            Set<Integer> mutualFriends = new HashSet<>(adjacencyList.get(id1));
            mutualFriends.retainAll(adjacencyList.get(id2));

            System.out.println("Mutual friends between " + users.get(id1).getName() + " and " + users.get(id2).getName() + ":");
            for (int friendId : mutualFriends) {
                System.out.println(users.get(friendId).getName());
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Search for a user by name using binary search
    public void searchUser(String name) {
        List<User> userList = new ArrayList<>(users.values());
        userList.sort(Comparator.comparing(User::getName));

        int left = 0, right = userList.size() - 1;
        boolean found = false;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            User midUser = userList.get(mid);

            if (midUser.getName().equalsIgnoreCase(name)) {
                System.out.println("User found: " + midUser);
                found = true;
                break;
            } else if (midUser.getName().compareToIgnoreCase(name) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("No user found with name: " + name);
        }
    }

    // Post a message
    public void postMessage(int userId, String content) {
        User user = users.get(userId);
        if (user != null) {
            user.addPost(content);
            System.out.println("Post added for user: " + user.getName());
        } else {
            System.out.println("User not found.");
        }
    }

    // View news feed of a user
    public void viewNewsFeed(int userId) {
        if (!users.containsKey(userId)) {
            System.out.println("User not found.");
            return;
        }

        PriorityQueue<Post> feed = new PriorityQueue<>(Comparator.comparing(Post::getTimestamp).reversed());
        for (int friendId : adjacencyList.get(userId)) {
            User friend = users.get(friendId);
            if (friend != null) {
                List<Post> posts = friend.getPosts();
                if (posts != null) {
                    for (Post post : posts) {
                        feed.add(post);
                    }
                }
            }
        }

        System.out.println("News Feed for " + users.get(userId).getName() + ":");
        while (!feed.isEmpty()) {
            System.out.println(feed.poll());
        }
    }

    // View activity feed of a user
    public void viewActivityFeed(int userId) {
        User user = users.get(userId);
        if (user != null) {
            System.out.println("Activity Feed for " + user.getName() + ":");
            for (String activity : user.getActivities()) {
                System.out.println(activity);
            }
        } else {
            System.out.println("User not found.");
        }
    }

    // Recommend friends for a user
    public void recommendFriends(int userId) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        Map<Integer, Integer> recommendations = new HashMap<>();
        for (int friendId : adjacencyList.get(userId)) {
            for (int friendOfFriendId : adjacencyList.get(friendId)) {
                if (friendOfFriendId != userId && !adjacencyList.get(userId).contains(friendOfFriendId)) {
                    recommendations.put(friendOfFriendId, recommendations.getOrDefault(friendOfFriendId, 0) + 1);
                }
            }
        }

        recommendations.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .forEach(entry -> {
                System.out.println("Recommended Friend: " + users.get(entry.getKey()).getName() +
                        " (Mutual Friends: " + entry.getValue() + ")");
            });
    }

    // Remove a user from the network
    public void removeUser(int userId) {
        if (users.containsKey(userId)) {
            adjacencyList.remove(userId);
            for (List<Integer> friends : adjacencyList.values()) {
                friends.remove(Integer.valueOf(userId));
            }
            users.remove(userId);
            System.out.println("User removed.");
        } else {
            System.out.println("User not found.");
        }
    }

    // Remove a friendship between two users
    public void removeFriend(int id1, int id2) {
        if (users.containsKey(id1) && users.containsKey(id2)) {
            adjacencyList.get(id1).remove(Integer.valueOf(id2));
            adjacencyList.get(id2).remove(Integer.valueOf(id1));
            System.out.println("Friendship removed between " + users.get(id1).getName() + " and " + users.get(id2).getName());
        } else {
            System.out.println("One or both users not found.");
        }
    }
}
