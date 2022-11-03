package demoapplication.dto;


import demoapplication.model.Region;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private Long id;
    private String shortName;
    private String fullName;
    private int population;
    List<Region> regions;
}
