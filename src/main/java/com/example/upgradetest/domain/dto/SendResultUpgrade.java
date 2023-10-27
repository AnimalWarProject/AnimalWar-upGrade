package com.example.upgradetest.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class SendResultUpgrade {
    private UUID userUUID;
    private Long animalId;
    private Integer resultUpgrade;

    public SendResultUpgrade() {
    }
}
