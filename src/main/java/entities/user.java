package entities;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class user {
private int userId;
private String userName;
private  String email;
private  String userPasswordl;


    public user(String userName, String email, String userPasswordl) {
        this.userName = userName;
        this.email = email;
        this.userPasswordl = userPasswordl;
    }
}
