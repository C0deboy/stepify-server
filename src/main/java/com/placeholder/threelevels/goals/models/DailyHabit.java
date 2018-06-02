package com.placeholder.threelevels.goals.models;

import lombok.*;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DailyHabit {

    @NotNull(message = "{DailyHabit.corrupted}")
    private Date from;
    @NotNull(message = "{DailyHabit.corrupted}")
    private Date to;
    @Min(value = 1, message = "{DailyHabit.everyNDays.min}")
    @Max(value = 7, message = "{DailyHabit.everyNDays.max}")
    private Integer everyNDays;
    @NotNull(message = "{DailyHabit.corrupted}")
    private int[] dailyChecklist;
    @Size(max = 7, message = "{DailyHabit.specificDays.max}")
    private int[] specificDays;

    @AssertTrue(message = "{DailyHabit.dateRange}")
    public boolean isDateRangeValid() {
        return from.compareTo(to) < 0;
    }

    @AssertTrue(message = "{DailyHabit.corrupted}")
    public boolean isDailyChecklistValid() {
        boolean valid = true;
        for (int flag : dailyChecklist) {
            valid = flag == 0 || flag == 1;
        }
        return valid;
    }

    @AssertTrue(message = "{DailyHabit.corrupted}")
    public boolean isSpecificDaysValid() {
        boolean valid = true;

        if(specificDays == null) {
            return true;
        }

        for (int day : specificDays) {
            valid = day > 0 && day <= 7;
        }

        return valid;
    }
}
