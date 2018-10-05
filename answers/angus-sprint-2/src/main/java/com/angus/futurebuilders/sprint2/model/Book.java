package com.angus.futurebuilders.sprint2.model;

import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Getter @Setter private Integer id;
    @Getter @Setter private String author;
    @Getter @Setter private String title;
    @Getter @Setter private Date releaseDate;

    @Override
    public String toString() {
        return String.format("Book[id=%d, title='%s', author='%s', releaseDate=%s]",
                id, title, author, releaseDate.toString());
    }
}