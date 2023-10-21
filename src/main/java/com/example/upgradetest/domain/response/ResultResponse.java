package com.example.upgradetest.domain.response;

public record ResultResponse(
        String name,
        String grade,
        Integer attackPower,
        Integer defencePower,
        Integer life,
        String type,
        Integer buff
) {
}
