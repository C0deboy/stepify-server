package com.placeholder.threelevels.goals.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Document(collection = "goals")
public class Goal {
  @Id
  private String id;
  private String owner;
  private String name;
  private List<Level> levels;
  private Checklist checklist;
  private DailyHabit dailyHabit;
  private boolean achieved;
}
