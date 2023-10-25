package com.example.upgradetest.service;

import com.example.upgradetest.domain.entity.AnimalInventory;
import com.example.upgradetest.domain.request.SaveRequest;
import com.example.upgradetest.domain.response.ResultResponse;
import com.example.upgradetest.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;




    public void save(SaveRequest request) { // Test용
        animalRepository.save(request.toEntity());
    }


    public ResultResponse upgradeAnimal(Integer userId, Integer animalId) { // 강화
        AnimalInventory findAnimal = animalRepository.findByUserIdAndAnimalId(userId, animalId).orElseThrow(() -> new RuntimeException("에러")); // userId, animalId 없을수도있다.
        ResultResponse resultResponse = upgradeMethod(findAnimal);
//       todo : resultResponse kafka를 통해서 user에 보내줘야한다.
        return new ResultResponse(resultResponse.name(), resultResponse.grade(), resultResponse.buff());
    }
    private ResultResponse upgradeMethod(AnimalInventory findAnimal) { // 강화하는 매소드
        final int randomNumber = (int)(Math.random()*100); // 랜덤숫자
        final int[] arr = {100, 90, 80, 70, 60, 35, 25, 15, 10}; // 0, 1, 2, 3, 4 ...

        if (randomNumber < arr[findAnimal.getBuff()]) { // 1강 100% 확률
            int buff = findAnimal.getBuff(); // 강화 성공시 강화수치를 1로 변경
            buff = +1;
            update(findAnimal, buff);
            System.out.println("강화성공");
        }else {
            System.out.println("강화 실패");
        }
        return new ResultResponse(findAnimal.getName(), findAnimal.getGrade(), findAnimal.getBuff()+1);
    }
    private void update(AnimalInventory findAnimal, int buff){ // 강화수치 업데이트
        findAnimal.setBuff(buff);
    }
}
