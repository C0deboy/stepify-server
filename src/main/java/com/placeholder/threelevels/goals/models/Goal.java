package com.placeholder.threelevels.goals.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.URL;
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
    private double order;
    @Size(max = 5, message = "{Goal.levels.max}")
    private List< @Valid Level> levels;
    @Valid
    private Checklist checklist;
    @Valid
    private DailyHabit dailyHabit;
    @NotNull(message = "{Goal.corrupted}")
    private boolean achieved;
    private String inspiredBy;
    @URL
    private String inspiredByLink;
}
