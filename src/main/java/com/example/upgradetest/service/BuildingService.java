package com.example.upgradetest.service;

import com.example.upgradetest.domain.entity.BuildingInventory;
import com.example.upgradetest.domain.response.ResultResponse;
import com.example.upgradetest.repository.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuildingService {
    private final BuildingRepository buildingRepository;



    public ResultResponse upgradeBuilding(Integer userId, Integer buildingId) { // 강화
        BuildingInventory findBuilding = buildingRepository.findByUserIdAndBuildingId(userId, buildingId).orElseThrow(() -> new RuntimeException("에러")); // userId, buildingId 없을수도있다.
        ResultResponse resultResponse = upgradeMethod(findBuilding);
//       todo : resultResponse kafka를 통해서 user에 보내줘야한다.
        return new ResultResponse(resultResponse.name(), resultResponse.buff());
    }
    private ResultResponse upgradeMethod(BuildingInventory findBuilding) { // 강화하는 매소드
        final int randomNumber = (int)(Math.random()*100); // 랜덤숫자
        final int[] arr = {100, 90, 80, 70, 60, 35, 25, 15, 10}; // 0, 1, 2, 3, 4 ...

        if (randomNumber < arr[findBuilding.getBuff()]) { // 1강 100% 확률
            int buff = findBuilding.getBuff(); // 강화 성공시 강화수치를 1로 변경
            buff = +1;
            update(findBuilding, buff);
            System.out.println("강화성공");
        }else {
            System.out.println("강화 실패");
        }
        return new ResultResponse(findBuilding.getName(),findBuilding.getBuff()+1);
    }
    private void update(BuildingInventory findBuilding, int buff){ // 강화수치 업데이트
        findBuilding.setBuff(buff);
    }
}
