package demoapplication.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "city", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column
    @NotNull
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @NotNull
    private Region region;

    @Column
    @NotNull
    private int population;
}
