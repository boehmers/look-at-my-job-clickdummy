package de.juzapo.model;

/**
 * Created by Manuel on 18.11.2015.
 */
public class User {

    private String username;
    private String evilUnencryptedPassword;
    private String email;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEvilUnencryptedPassword() {
        return evilUnencryptedPassword;
    }

    public void setEvilUnencryptedPassword(String evilUnencryptedPassword) {
        this.evilUnencryptedPassword = evilUnencryptedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", evilUnencryptedPassword='" + evilUnencryptedPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
