package com.example.upgradetest.domain.request;

import java.util.UUID;

public record UpgradeRequest(
        UUID userUUID,
        Long animalId,
        Integer buff
) {
}
