//package server.appserver.controllers;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import server.appserver.models.Bond;
//import server.appserver.services.BondService;
//
//@RestController
//public class GetPortfolioByUserName {
//
//    @GetMapping("/getBonds")
//    public Bond getBonds(@RequestParam String name) {
//        BondService result = new BondService();
//        return result.getBondsByOwnerName(name);
//    }
//}
