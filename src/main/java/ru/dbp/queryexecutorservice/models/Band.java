package ru.dbp.queryexecutorservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "bands")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "band_sequence")
    @SequenceGenerator(name = "band_sequence", sequenceName = "band_sequence", allocationSize = 1)
    private Long id;

    private String name;
    private String genre;

    @OneToMany(mappedBy = "band", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Song> songs;
}
