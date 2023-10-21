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
@RequestMapping("/api/upgrade")
public class UpgradeController {

    private final AnimalService animalService;
    private final BuildingService buildingService;

    @PostMapping("/animal/save")
    public void save(@RequestBody SaveRequest request){
        animalService.save(request);
    }

    @PostMapping("/animal/{userId}/{animalId}")
    public ResultResponse upgrade(@PathVariable("userId") Integer userId, @PathVariable("animalId") Integer animalId){
        return animalService.upgrade(userId, animalId);
    }


}
