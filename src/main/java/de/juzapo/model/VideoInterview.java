package de.juzapo.model;

import java.util.List;

/**
 * Created by Manuel on 18.11.2015.
 */
public class VideoInterview {

    private String title;
    private String videoUrl;
    private User user;
    private List<String> comments;

    public VideoInterview() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
