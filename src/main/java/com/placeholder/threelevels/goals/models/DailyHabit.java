package com.placeholder.threelevels.goals.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DailyHabit {

  private Date from;
  private Date to;
  private int everyNDays;
  private int[] dailyChecklist;
  private int[] specificDays;

}
