package io.subspacedev.alm.domain.model;

import java.util.List;

import org.springframework.scheduling.config.Task;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class Story extends WorkItem {
    @ManyToOne
    private Feature feature;

    @OneToMany(mappedBy = "story")
    private List<Task> tasks;
}