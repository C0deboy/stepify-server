package com.placeholder.threelevels.goals.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    private ObjectId owner;
    @Size.List({
        @Size(min = 3, message = "{Goal.name.min}"),
        @Size(max = 100, message = "{Goal.name.max}")
    })
    private String name;
    @Size(max = 5, message = "{Goal.levels.max}")
    private List< @Valid Level> levels;
    @Valid
    private Checklist checklist;
    @Valid
    private DailyHabit dailyHabit;
    @NotNull(message = "{Goal.corrupted}")
    private boolean achieved;
}
