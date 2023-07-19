package io.subspacedev.alm.domain.model;

import java.util.List;

import org.springframework.scheduling.config.Task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "teamBoard")
    private List<Epic> epics;

    @OneToMany(mappedBy = "teamBoard")
    private List<Feature> features;

    @OneToMany(mappedBy = "teamBoard")
    private List<Story> stories;

    @OneToMany(mappedBy = "teamBoard")
    private List<Task> tasks;
}
