package com.example.upgradetest.domain.request;

import java.util.UUID;

public record AnimalUpgradeRequest(
        UUID userUUID,
        Long itemId,
        Integer buff
) {
}
