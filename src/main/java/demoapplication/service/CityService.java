package demoapplication.service;

import demoapplication.model.Region;
import demoapplication.model.City;
import demoapplication.repository.CityRepo;
import demoapplication.repository.RegionRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityService {

    private final CityRepo cityRepo;

    private final RegionRepo regionRepo;

    public CityService(CityRepo cityRepo, RegionRepo regionRepo) {
        this.regionRepo = regionRepo;
        this.cityRepo = cityRepo;
    }

    public City getById(Long id) {
        return cityRepo.findById(id).orElse(null);
    }

    @Transactional
    public City save(City city, Long regionId) {

        final Region region = regionRepo.getReferenceById(regionId);

        city.setRegion(region);

        return cityRepo.save(city);
    }

    @Transactional
    public void update(City city, Long id) {
        cityRepo.updateCity(city.getName(), city.getPopulation(), id);
    }

    @Transactional
    public void delete(Long id) {
        cityRepo.deleteById(id);
    }
}