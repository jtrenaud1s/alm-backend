package io.subspacedev.alm.domain.model;

import java.util.List;

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
public class Epic extends WorkItem {
    @ManyToOne
    private Board teamBoard;

    @OneToMany(mappedBy = "epic")
    private List<Feature> features;
}