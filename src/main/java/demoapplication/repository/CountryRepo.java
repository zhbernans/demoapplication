package demoapplication.repository;

import demoapplication.model.Country;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface CountryRepo extends JpaRepository<Country, Long> {

    @Override
    @EntityGraph(attributePaths = {"regions"})
    Optional<Country> findById(Long id);

    @Query(value = "update Country c set " +
            "c.fullName = :fullname, " +
            "c.shortName = :shortname, " +
            "c.population = :population " +
            "where c.id = :id")
    @Modifying
    void updateCountry(@Param("fullname") String fullname,
                       @Param("shortname") String shortname,
                       @Param("population") Integer population,
                       @Param("id") Long id);
}