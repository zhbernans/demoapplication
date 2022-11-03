package demoapplication.controller;


import demoapplication.dto.CityDto;
import demoapplication.model.City;
import demoapplication.service.CityService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/admin/city")
public record CityController(CityService cityService) {

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable(name = "id") Long cityId) {

        var cityDto = new CityDto();
        BeanUtils.copyProperties(cityService.getById(cityId), cityDto);
        return new ResponseEntity<>(cityDto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CityDto> updateCity(
            @RequestBody @Valid CityDto cityDto,
            @PathVariable("id") Long id) {

        var city = new City();
        BeanUtils.copyProperties(cityDto,city);
        cityService.update(city, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CityDto> deleteCity(@PathVariable(name = "id") Long cityId) {

        cityService.delete(cityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}