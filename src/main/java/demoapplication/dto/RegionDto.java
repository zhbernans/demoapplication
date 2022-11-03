package demoapplication.dto;

import demoapplication.model.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegionDto {
    private String name;
    private String fullName;
    private int population;
    List<City> cities;
}
