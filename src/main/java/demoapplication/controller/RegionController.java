package demoapplication.controller;


import demoapplication.dto.CityDto;
import demoapplication.dto.RegionDto;
import demoapplication.model.City;
import demoapplication.model.Region;
import demoapplication.service.CityService;
import demoapplication.service.RegionService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/admin/region")
public record RegionController(RegionService regionService, CityService cityService) {

    @GetMapping(value = "/{id}")
    public ResponseEntity<RegionDto> getRegionById(@PathVariable(name = "id") Long regionId) {

        var regionDto = new RegionDto();
        BeanUtils.copyProperties(regionService.getById(regionId), regionDto);
        return new ResponseEntity<>(regionDto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RegionDto> updateRegion(
            @RequestBody @Valid RegionDto regionDto,
            @PathVariable("id") Long id) {

        var region = new Region();
        BeanUtils.copyProperties(regionDto,region);
        regionService.update(region, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/city")
    public ResponseEntity<CityDto> createCityForRegion(
            @RequestBody @Valid CityDto cityDto,
            @PathVariable(value = "id") Long regionId) {

        var city = new City();
        BeanUtils.copyProperties(cityDto, city);
        cityService.save(city, regionId);
        return new ResponseEntity<>(cityDto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<RegionDto> deleteRegion(@PathVariable(name = "id") Long regionId) {

        regionService.delete(regionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}