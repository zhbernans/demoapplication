package demoapplication.service;

import demoapplication.model.Country;
import demoapplication.model.Region;
import demoapplication.repository.CountryRepo;
import demoapplication.repository.RegionRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegionService {

    private final RegionRepo regionRepo;

    private final CountryRepo countryRepo;

    public RegionService(RegionRepo regionRepo, CountryRepo countryRepo) {
        this.regionRepo = regionRepo;
        this.countryRepo = countryRepo;
    }

    public Region getById(Long id) {
        return regionRepo.findById(id).orElse(null);
    }

    @Transactional
    public Region save(Region region, Long countryId) {

        final Country country = countryRepo.getReferenceById(countryId);

        region.setCountry(country);

        return regionRepo.save(region);
    }

    @Transactional
    public void update(Region region, Long id) {
        regionRepo.updateRegion(region.getName(), region.getPopulation(), id);
    }

    @Transactional
    public void delete(Long id) {
        regionRepo.deleteById(id);
    }
}