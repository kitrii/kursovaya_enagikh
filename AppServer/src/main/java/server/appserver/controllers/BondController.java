package server.appserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.appserver.entities.BondEntity;
import server.appserver.mapper.BondMapper;
import server.appserver.models.Bond;
import server.appserver.services.BondService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс контроллер Облигаций
 */
@RestController
@RequestMapping("/bonds")
public class BondController {

    private final BondService bondService;

    @Autowired
    public BondController(BondService bondService) {
        this.bondService = bondService;
    }


    /**
     * Получить информацию о всех облигациях
     *
     */
    @GetMapping("/all")
    public ResponseEntity<List<Bond>> getBonds() {
        List<BondEntity> DbBonds = bondService.getAllBonds();
        List<Bond> bonds = BondMapper.BondEntityToBondMapper(DbBonds);
        return new ResponseEntity<>(bonds, HttpStatus.OK);
    }


    /**
     * Получить информацию о всех облигациях по id обладателя
     *
     * @param ownerId
     */
    @GetMapping("/ownerId")
    public ResponseEntity<List<Bond>> getBondsByOwnerId(@RequestParam(name = "ownerId") int ownerId) {
        List<BondEntity> DbBonds = bondService.getBondsByOwnerId(ownerId);
        List<Bond> bonds = BondMapper.BondEntityToBondMapper(DbBonds);
        return new ResponseEntity<>(bonds, HttpStatus.OK);
    }

    /**
     * Получить информацию о всех облигациях по id обладателя
     *
     * @param ownerName
     */
    @GetMapping("/ownerName")
    public ResponseEntity<List<Bond>> getBondsByOwnerName(@RequestParam(name = "ownerName") String ownerName) {
        List<BondEntity> DbBonds = bondService.getBondsByOwnerName(ownerName);
        List<Bond> bonds = BondMapper.BondEntityToBondMapper(DbBonds);
        return new ResponseEntity<>(bonds, HttpStatus.OK);
    }
    /**
     * Добавление облигации в БД
     *
     * @param bond сущность облигации
     */

    @PostMapping("/add")
    public ResponseEntity<?> addBond(@RequestBody BondEntity bond) {
        Map<String, Object> map = new HashMap<>();
        bondService.addBond(bond);
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * Удаление облигации
     *
     */
    @GetMapping("/delete")
    public ResponseEntity<?> deleteBondByBondIdOwnerId(@RequestParam(name = "bondId") int bondId,
                                                       @RequestParam(name = "ownerId") int ownerId) {
        bondService.deleteBondByOwnerIdBondId(bondId, ownerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Рассчитать дюрацию всех облигаций для пользователя по ownerId
     *
     * @param ownerId
     */
    @GetMapping("/calculateDuration")
    public ResponseEntity<Long> calculateDurationByOwnerId(@RequestParam(name = "ownerId") int ownerId) {
        List<BondEntity> bonds = bondService.getBondsByOwnerId(ownerId);
        long duration = 21;
        return new ResponseEntity<>(duration, HttpStatus.OK);
    }

    /**
     * Обновить информауию об акции
     *
     * @param bond
     */
    @PutMapping("/edit")
    public ResponseEntity<?> editBondInfo(@RequestBody BondEntity bond) {
        Map<String, Object> map = new HashMap<>();
        bondService.addBond(bond);
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}