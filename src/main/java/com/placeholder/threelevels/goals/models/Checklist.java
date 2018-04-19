package com.placeholder.threelevels.goals.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Checklist {
    private String name;
    private List<ListItem> list;
}
