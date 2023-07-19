package io.subspacedev.alm.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class Task extends WorkItem {
    private int estimatedHours;

    private int toDoHours;

    private int actualHours;

    @ManyToOne
    private Story story;
}