package com.example.upgradetest.controller;

import com.example.upgradetest.domain.request.SaveRequest;
import com.example.upgradetest.domain.response.ResultResponse;
import com.example.upgradetest.service.AnimalService;
import com.example.upgradetest.service.BuildingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/upgrade")
public class UpgradeController {

    private final AnimalService animalService;
    private final BuildingService buildingService;

    @PostMapping("/animal")
    public void save(@RequestBody SaveRequest request){
        animalService.save(request);
    }

    @PostMapping("/animal/{userId}/{animalId}") // body
    public ResultResponse upgradeAnimal(@PathVariable("userId") Integer userId, @PathVariable("animalId") Integer animalId){
        return animalService.upgradeAnimal(userId, animalId);
    }

    @PostMapping("/animal/{userId}/{buildingId}") // body
    public ResultResponse upgradeBuilding(@PathVariable("userId") Integer userId, @PathVariable("buildingId") Integer buildingId){
        return buildingService.upgradeBuilding(userId, buildingId);
    }


}
