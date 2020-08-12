package com.motin.diary.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Category extends Auditable<Category>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;

    @OneToMany(fetch = FetchType.LAZY,cascade ={CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},mappedBy = "category")
    private List<Note> notes;
}
