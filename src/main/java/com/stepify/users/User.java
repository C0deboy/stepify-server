package com.stepify.users;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
