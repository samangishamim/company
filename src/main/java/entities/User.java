package entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {
    private int userId;
    private String name;
    private String userName;
    private String email;
    private String userPasswordl;


    public User(String name, String userName, String email, String userPasswordl) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.userPasswordl = userPasswordl;
    }

}
