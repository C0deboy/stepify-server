package com.stepify.goals.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Checklist {
    @Size.List({
        @Size(min = 3, message = "{Checklist.name.min}"),
        @Size(max = 150, message = "{Checklist.name.max}")
    })
    private String name;
    @Size.List({
        @Size(min = 1, message = "{Checklist.list.min}"),
        @Size(max = 100, message = "{Checklist.list.max}")
    })
    private List<@Valid ListItem> list;
}