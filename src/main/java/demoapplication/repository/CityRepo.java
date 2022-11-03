package demoapplication.repository;

import demoapplication.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface CityRepo extends JpaRepository<City, Long> {
    @Override
    Optional<City> findById(Long id);

    @Query(value = "update City c set c.name = :name, c.population = :population where c.id = :id")
    @Modifying
    void updateCity(@Param("name") String name, @Param("population") Integer population, @Param("id") Long id);
}