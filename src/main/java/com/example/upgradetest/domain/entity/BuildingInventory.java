package com.example.upgradetest.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @Builder @Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "buildings")
public class BuildingInventory {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 건물 중간테이블
    private Long id;
    private Long userId;
    private Long animalId;
    private String name;
    private String grade;
    private Integer attackPower;
    private Integer defencePower;
    private Integer life;
    private Integer woodRate;
    private Integer ironRate;
    private Integer foodRate;
    private Integer buff;

}
