package Common;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Post implements Serializable,Comparable<Post> {
    private Account writer;
    private String title;
    private String description;
    private AtomicInteger likes=new AtomicInteger(0);
    private AtomicInteger reposts=new AtomicInteger(0);
    private final Long createdTime;
    private final String timeString;

    public void setLikes(AtomicInteger likes) {
        this.likes = likes;
    }

    public void setReposts(AtomicInteger reposts) {
        this.reposts = reposts;
    }

    public AtomicInteger getLikes() {
        return likes;
    }

    public AtomicInteger getReposts() {
        return reposts;
    }

    public Post() {
        this.createdTime =Time.getMilli();
        this.timeString =Time.getTime() ;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getWriter() {
        return writer;
    }

    public void setWriter(Account writer) {
        this.writer = writer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public String getTimeString() {
        return timeString;
    }

    @Override
    public int compareTo(Post o) {
        return (int) (this.createdTime - o.createdTime);
    }
}
