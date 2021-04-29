package core.app.controllers;

import core.app.entity.BuyingCurrency;
import core.app.entity.CursValutar;
import core.app.entity.DetailedNumerar;
import core.app.entity.Operator;
import core.app.services.ExchangeOperationsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operations")
public class ExchangeOperationsController {

    @Autowired
    ExchangeOperationsServices exchangeOperationsServices;


    @PostMapping(value = "/rates", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addExchangeRate(@RequestBody CursValutar currencyVal) {
        if (exchangeOperationsServices.serviceAddExchangeRate(currencyVal)) {
            return ResponseEntity.ok().body("Successful execution operation!");
        } else {
            return ResponseEntity.badRequest().body("Failed execution operation!");
        }
    }

    @PostMapping(value = "/currencies", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> buyingCurrency(@RequestBody BuyingCurrency buyingCurrency) {
        if (exchangeOperationsServices.serviceBuyingCurrency(buyingCurrency)) {
            return ResponseEntity.ok().body("Successful execution operation!");
        } else {
            return ResponseEntity.badRequest().body("Failed execution operation!");
        }
    }

    @PutMapping(value = "/internal/rates", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> getExchangeRate(@RequestBody DetailedNumerar numerar) {

        if (exchangeOperationsServices.serviceEditExchangeRate(numerar)) {
            return ResponseEntity.ok().body("Successful execution operation!");
        } else {
            return ResponseEntity.badRequest().body("Failed execution operation!");
        }
    }

    @GetMapping(value = "/rates/{currencyId}", produces = "application/json")
    public ResponseEntity<CursValutar> editExchangeRate(@PathVariable String currencyId) {
        CursValutar currency = exchangeOperationsServices.serviceGetExchangeRate(currencyId);

        return ResponseEntity.ok().body(currency);

    }

    @PostMapping(value = "/operators", produces = "application/json")
    public ResponseEntity<String> addOperatorInSystem(@RequestBody Operator operator) {
        if (exchangeOperationsServices.addOperatorInSystem(operator)) {
            return ResponseEntity.ok().body("");
        } else {
            return ResponseEntity.badRequest().body("");
        }
    }
}
