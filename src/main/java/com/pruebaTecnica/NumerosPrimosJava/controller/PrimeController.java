package com.pruebaTecnica.NumerosPrimosJava.controller;

import com.pruebaTecnica.NumerosPrimosJava.exceptions.NumerosException;
import com.pruebaTecnica.NumerosPrimosJava.models.entity.Primo;
import com.pruebaTecnica.NumerosPrimosJava.service.PrimeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api")
public class PrimeController {

    @Autowired
    private PrimeService service;

    @PostMapping("/prime-number")
    public ResponseEntity<String> isPrimeHandler(@RequestBody Primo primo) throws NumerosException {
        log.info("Post Mapping isPrimeHandler");
        String numberValidate = String.valueOf(primo.getNumber());
        int number = primo.getNumber();
        try {
            if (Integer.parseInt(numberValidate) == 0){
                log.info("{} no es primo",numberValidate);
                return ResponseEntity.ok("0 no es primo");
            }
            NumerosException.validarNumeroPositivo(numberValidate);
            String message = service.isPrime(number) ? "Es primo": "No es primo";
            return ResponseEntity.ok(message);
        }catch (Exception e){
            log.info("Error Exception isPrimeHandler: {}",e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/ten-numbers-prime")
    public ResponseEntity<List<Primo>> getFirstTenNumberPrimeHsandler(){
        try {
            return ResponseEntity.ok(service.getFirstTenNumberPrime());
        }catch (Exception e){
            log.info("Error Exception getFirstTenNumberPrimeHsandler: {}",e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
