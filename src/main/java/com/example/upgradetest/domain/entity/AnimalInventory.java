package com.example.upgradetest.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder @Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "animals")
public class AnimalInventory {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 동물 중간테이블
    private Long id;
    private Long userId;
    private Long animalId;
    private String name;
    private String grade;
    private Integer attackPower;
    private Integer defencePower;
    private Integer life;
    private String type;
    private Integer buff; // 몇 강화

}
