package com.placeholder.threelevels.goals.models;

import lombok.*;

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
