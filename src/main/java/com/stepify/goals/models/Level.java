package com.stepify.goals.models;

import com.stepify.validation.DateFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Level {
    @NotNull(message = "{Level.corrupted}")
    private int level;
    @Size.List({
        @Size(min = 3, message = "{Level.name.min}"),
        @Size(max = 80, message = "{Level.name.max}")
    })
    private String name;
    @Size(max = 80, message = "{Level.reward.max}")
    private String reward;
    @NotNull(message = "{Level.corrupted}")
    private boolean achieved;
    private Date achievedAt;
    @URL
    private String achievedProof;
    @DateFormat(formats = {"uuuu", "M.uuuu", "d.M.uuuu"})
    private String toBeDoneAt;
}
