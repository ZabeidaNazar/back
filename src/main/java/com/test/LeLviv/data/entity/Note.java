package com.test.LeLviv.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    @Size(min = 1, max = 200)
    private String title;

    @Column(nullable = false)
    @Size(min = 5)
    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
