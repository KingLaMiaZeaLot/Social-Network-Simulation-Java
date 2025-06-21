
package datastructureassignment1;

import java.util.*;
class User {
    private int id;
    private String name;
    private LinkedList<Post> posts;
    private PriorityQueue<String> activities;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.posts = new LinkedList<>();
        this.activities = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Post> getPosts() {
        return posts;
    }

    public void addPost(String content) {
        Post post = new Post(content, this.name);
        posts.addFirst(post);
        addActivity("Posted: " + content);
    }

    public void addActivity(String activity) {
        activities.add(activity + " (" + new Date() + ")");
    }

    public PriorityQueue<String> getActivities() {
        return new PriorityQueue<>(activities);
    }

    @Override
    public String toString() {
        return "User ID: " + id + ", Name: " + name;
    }
}