package com.example.upgradetest.service;

import com.example.upgradetest.domain.entity.AnimalInventory;
import com.example.upgradetest.domain.request.SaveRequest;
import com.example.upgradetest.domain.response.ResultResponse;
import com.example.upgradetest.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;

    public void save(SaveRequest request) {
        animalRepository.save(request.toEntity());
    }

    public ResultResponse upgrade(Integer userId, Integer animalId) {
        AnimalInventory findAnimal = animalRepository.findByUserIdAndAnimalId(userId, animalId); // 인벤토리에서 강화할 동물을 가져왔다.
        Integer x = (int) (Math.random());

        switch (findAnimal.getBuff()) {
            case 0:
                if (x < 100) { // 1강 100% 확률
                    if (findAnimal.getGrade().equals("NORMAL")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("RARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("SUPERRARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("UNIQUE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("LEGEND")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }
                }

                break;

            case 1:
                if (x < 89) { // 1강 90% 확률
                    if (findAnimal.getGrade().equals("NORMAL")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("RARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("SUPERRARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("UNIQUE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("LEGEND")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }
                } else {
                    System.out.println("강화실패");
                    return null;
                }
                break;

            case 2:
                if (x < 79) { // 1강 80% 확률
                    if (findAnimal.getGrade().equals("NORMAL")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("RARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("SUPERRARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("UNIQUE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("LEGEND")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }
                } else {
                    System.out.println("강화실패");
                    return null;
                }
                break;

            case 3:
                if (x < 69) { // 1강 70% 확률
                    if (findAnimal.getGrade().equals("NORMAL")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("RARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("SUPERRARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("UNIQUE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("LEGEND")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }
                } else {
                    System.out.println("강화실패");
                    return null;
                }
                break;

            case 4:
                if (x < 59) { // 1강 60% 확률
                    if (findAnimal.getGrade().equals("NORMAL")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("RARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("SUPERRARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("UNIQUE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("LEGEND")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }
                } else {
                    System.out.println("강화실패");
                    return null;
                }
                break;

            case 5:
                if (x < 49) { // 1강 35% 확률 여기서부터는 강화수치가 1단계 하락
                    if (findAnimal.getGrade().equals("NORMAL")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("RARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("SUPERRARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("UNIQUE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("LEGEND")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }
                } else {
                    System.out.println("강화실패 강화수치가 1단계 하락합니다");
                    return null;
                }
                break;

            case 6:
                if (x < 39) { // 1강 25% 확률
                    if (findAnimal.getGrade().equals("NORMAL")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("RARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("SUPERRARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("UNIQUE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("LEGEND")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }
                } else {
                    System.out.println("강화실패 강화수치가 1단계 하락합니다");
                    return null;
                }
                break;

            case 7:
                if (x < 29) { // 1강 15% 확률
                    if (findAnimal.getGrade().equals("NORMAL")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("RARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("SUPERRARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("UNIQUE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("LEGEND")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.1),
                                (int)(findAnimal.getDefencePower()*1.1),
                                (int)(findAnimal.getLife()*1.1),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }
                } else {
                    System.out.println("강화실패 강화수치가 1단계 하락합니다");
                    return null;
                }
                break;

            case 8:
                if (x < 9) { // 1강 10% 확률 마지막 강화 성공하면 25% 상승
                    if (findAnimal.getGrade().equals("NORMAL")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.25),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                findAnimal.getDefencePower(),
                                (int)(findAnimal.getLife()*1.25),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("RARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.25),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                findAnimal.getAttackPower(),
                                (int)(findAnimal.getDefencePower()*1.25),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("SUPERRARE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.25),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.25),
                                findAnimal.getDefencePower(),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("UNIQUE")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.25),
                                (int)(findAnimal.getDefencePower()*1.25),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.25),
                                (int)(findAnimal.getDefencePower()*1.25),
                                findAnimal.getLife(),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }else if (findAnimal.getGrade().equals("LEGEND")){
                        animalRepository.deleteById(findAnimal.getId()); // 해당 인벤토리의 동물을 삭제하고
                        SaveRequest request = new SaveRequest( // 새로 저장한다.
                                findAnimal.getUserId(),
                                findAnimal.getAnimalId(),
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.25),
                                (int)(findAnimal.getDefencePower()*1.25),
                                (int)(findAnimal.getLife()*1.25),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                        animalRepository.save(request.toEntity());
                        System.out.println("강화성공");
                        return new ResultResponse(
                                findAnimal.getName(),
                                findAnimal.getGrade(),
                                (int)(findAnimal.getAttackPower()*1.25),
                                (int)(findAnimal.getDefencePower()*1.25),
                                (int)(findAnimal.getLife()*1.25),
                                findAnimal.getType(),
                                findAnimal.getBuff()
                        );
                    }
                } else {
                    System.out.println("강화실패 강화수치가 1단계 하락합니다");
                    return null;
                }
                break;

        }
        return null;

    }
}
