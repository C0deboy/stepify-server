package com.placeholder.threelevels.goals.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DailyHabit {
  private boolean everyday;
  private LocalDate from;
  private LocalDate to;
}
