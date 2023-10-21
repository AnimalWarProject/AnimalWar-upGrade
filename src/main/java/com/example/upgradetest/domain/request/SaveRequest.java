package com.example.upgradetest.domain.request;

import com.example.upgradetest.domain.entity.AnimalInventory;

public record SaveRequest(
        Long userId,
        Long animalId,
        String name,
        String grade,
        Integer attackPower,
        Integer defencePower,
        Integer life,
        String type,
        Integer buff
) {
    public AnimalInventory toEntity(){
        if (buff == null){ //
            int tmp = 0;
            return AnimalInventory.builder()
                    .userId(userId)
                    .animalId(animalId)
                    .name(name)
                    .grade(grade)
                    .attackPower(attackPower)
                    .defencePower(defencePower)
                    .life(life)
                    .type(type)
                    .buff(tmp)
                    .build();
        }
        return AnimalInventory.builder()
                .userId(userId)
                .animalId(animalId)
                .name(name)
                .grade(grade)
                .attackPower(attackPower)
                .defencePower(defencePower)
                .life(life)
                .type(type)
                .buff(buff)
                .build();
    }
}
