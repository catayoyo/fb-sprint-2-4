package com.angus.futurebuilders.sprint2.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Getter @Setter private long Id;
    @Getter @Setter private String author;
    @Getter @Setter private String title;
    @Getter @Setter private long releaseDate;
}