package com.example.upgradetest.controller;

import com.example.upgradetest.domain.request.UpgradeRequest;
import com.example.upgradetest.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/upgrade")
public class UpgradeController {

    private final AnimalService animalService;

    @PostMapping("/animal") // 동물 강화
    public void upgradeAnimal(@RequestBody UpgradeRequest request){
        animalService.upgradeAnimal(request);
    }

}
