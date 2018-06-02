package com.placeholder.threelevels.goals.models;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ListItem {
    @Size.List({
        @Size(min = 3, message = "{ListItem.value.min}"),
        @Size(max = 100, message = "{ListItem.value.max}")
    })
    private String value;
    @NotNull(message = "{ListItem.corrupted}")
    private boolean checked;
}
