package demoapplication.service;

import demoapplication.model.Country;
import demoapplication.repository.CountryRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CountryService {

    private final CountryRepo countryRepo;

    public CountryService(CountryRepo countryRepo){
        this.countryRepo = countryRepo;
    }

    public Country getById(Long id){
        return countryRepo.findById(id).orElse(null);
    }

    @Transactional
    public Country save(Country country){
        return countryRepo.save(country);
    }

    @Transactional
    public void update(Country country, Long id){
        countryRepo.updateCountry(country.getFullName(), country.getShortName(), country.getPopulation(), id);
    }

    @Transactional
    public void delete(Long id){
        countryRepo.deleteById(id);
    }
}