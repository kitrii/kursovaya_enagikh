package server.appserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.appserver.calculation.Calculation;
import server.appserver.entities.BondEntity;
import server.appserver.mapper.BondMapper;
import server.appserver.models.Bond;
import server.appserver.services.BondService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bonds")
public class BondController {

    private final BondService bondService;

    @Autowired
    public BondController(BondService bondService) {
        this.bondService = bondService;
    }


    /** Получить информацию о всех облигациях**/
    @GetMapping("/all")
    private ResponseEntity<List<Bond>> getBonds() {
        List<BondEntity> DbBonds = bondService.getAllBonds();
        List<Bond> bonds = BondMapper.BondEntityToBondMapper(DbBonds);
        return new ResponseEntity<>(bonds, HttpStatus.OK);
    }


    /**Получить информацию о всех облигациях по id обладателя*/
    @GetMapping("/ownerId")
    private ResponseEntity<List<Bond>> getBondsByOwnerId(@RequestParam(name = "ownerId") int ownerId) {
        List<BondEntity> DbBonds = bondService.getBondsByOwnerId(ownerId);
        List<Bond> bonds = BondMapper.BondEntityToBondMapper(DbBonds);
        return new ResponseEntity<>(bonds, HttpStatus.OK);
    }

    /**Получить информацию о всех облигациях по id обладателя*/
    @GetMapping("/ownerName")
    private ResponseEntity<List<Bond>> getBondsByOwnerName(@RequestParam(name = "ownerName") String ownerName) {
        List<BondEntity> DbBonds = bondService.getBondsByOwnerName(ownerName);
        List<Bond> bonds = BondMapper.BondEntityToBondMapper(DbBonds);
        return new ResponseEntity<>(bonds, HttpStatus.OK);
    }

    /** Добавление облигации в БД*/
    @PostMapping("/add")
    private ResponseEntity<?> addBond(@RequestBody BondEntity bond) {
        Map<String, Object> map = new HashMap<>();
        bondService.addBondInfo(bond);
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**Удаление облигации**/
    @GetMapping("/delete")
    private ResponseEntity<?> deleteBondByBondIdOwnerId(@RequestParam(name = "bondId") int bondId,
                                                        @RequestParam(name = "ownerId") int ownerId) {
        bondService.deleteBondByOwnerIdBondId(bondId, ownerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**Рассчитать дюрацию всех облигаций для пользователя по ownerId*/
    @GetMapping("/calculateDuration")
    private ResponseEntity<Float> calculateDurationByOwnerId(@RequestParam(name = "ownerId") int ownerId) {
        List<BondEntity> bonds = bondService.getBondsByOwnerId(ownerId);
        float duration = Calculation.calculateDuration(bonds);
        return new ResponseEntity<>(duration, HttpStatus.OK);
    }

    /**Обновить информауию об облигации*/
    @PutMapping("/edit")

    private ResponseEntity<?> editBondInfo(@RequestBody BondEntity bond) {
        Map<String, Object> map = new HashMap<>();
        bondService.editBondInfo(bond);
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}