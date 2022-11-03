package demoapplication.controller;


import demoapplication.dto.CountryDto;
import demoapplication.dto.RegionDto;
import demoapplication.model.Country;
import demoapplication.model.Region;
import demoapplication.service.CountryService;
import demoapplication.service.RegionService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/admin/country")
public record CountryController(CountryService countryService, RegionService regionService) {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable(name = "id") Long countryId) {

        var country = countryService.getById(countryId);
        var countryDto = new CountryDto();
        BeanUtils.copyProperties(country, countryDto);
        return new ResponseEntity<>(countryDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CountryDto> createCountry(@RequestBody @Valid CountryDto countryDto) {

        var country = new Country();
        BeanUtils.copyProperties(countryDto,country);
        countryService.save(country);
        return new ResponseEntity<>(countryDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/{id}/region")
    public ResponseEntity<CountryDto> createRegionForCountry(
            @RequestBody @Valid RegionDto regionDto,
            @PathVariable(value = "id") Long countryId) {

        var region = new Region();
        BeanUtils.copyProperties(regionDto,region);
        regionService.save(region, countryId);
        var countryDto = new CountryDto();
        BeanUtils.copyProperties(countryService.getById(countryId), countryDto);
        return new ResponseEntity<>(countryDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CountryDto> updateCountry(
            @RequestBody @Valid CountryDto countryDto,
            @PathVariable("id") Long id) {

        var country = new Country();
        BeanUtils.copyProperties(countryDto,country);
        countryService.update(country, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CountryDto> deleteCountry(@PathVariable(name = "id") Long countryId) {

        countryService.delete(countryId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}