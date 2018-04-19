package com.placeholder.threelevels.goals.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Level {
    private int level;
    private String name;
    private String reward;
    private boolean achieved;
}
