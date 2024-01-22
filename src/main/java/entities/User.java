package entities;


public class User {
    private int userId;
    private String name;
    private String userName;
    private String email;
    private String userPasswordl;


    public User() {
    }

    public User(int userId, String name, String userName, String email, String userPasswordl) {
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.userPasswordl = userPasswordl;
    }

    public User(String name, String userName, String email, String userPasswordl) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.userPasswordl = userPasswordl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPasswordl() {
        return userPasswordl;
    }

    public void setUserPasswordl(String userPasswordl) {
        this.userPasswordl = userPasswordl;
    }
}