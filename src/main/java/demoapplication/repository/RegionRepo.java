package demoapplication.repository;

import demoapplication.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface RegionRepo extends JpaRepository<Region, Long> {

    @Override
    Optional<Region> findById(Long id);

    @Query(value = "update Region r set r.name = :name, r.population = :population where r.id = :id")
    @Modifying
    void updateRegion(@Param("name") String name, @Param("population") Integer population, @Param("id") Long id);
}