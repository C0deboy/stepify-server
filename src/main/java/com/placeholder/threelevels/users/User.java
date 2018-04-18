package com.placeholder.threelevels.users;

import com.placeholder.threelevels.goals.models.Checklist;
import com.placeholder.threelevels.goals.models.DailyHabit;
import com.placeholder.threelevels.goals.models.Level;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

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
}
