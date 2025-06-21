package datastructureassignment1;

import java.util.*;


class Post {
    private String content;
    private String authorName;
    private long timestamp;

    public Post(String content, String authorName) {
        this.content = content;
        this.authorName = authorName;
        this.timestamp = System.currentTimeMillis();
    }

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return authorName + ": " + content + " (" + new Date(timestamp) + ")";
    }
}