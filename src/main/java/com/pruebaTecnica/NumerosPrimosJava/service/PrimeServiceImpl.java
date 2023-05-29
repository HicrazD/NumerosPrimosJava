package com.pruebaTecnica.NumerosPrimosJava.service;

import com.pruebaTecnica.NumerosPrimosJava.models.entity.Primo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class PrimeServiceImpl implements PrimeService {

    //Empezamos desde el 2 porque 1 y 0 o menores a 1 no se consideran primos
    private final int COUNTER_START = 2;

    @Override
    public Boolean isPrime(int number) {
        // Los números menores o iguales a 1 no son primos
        if (number <= 1) return false;

        //Para saber si un número es primo basta con probar si el número no es divisible por los primos hasta su raiz cuadrada.
        for (int i = COUNTER_START; i <= Math.sqrt(number); i++) {
            //guardamos en divisor  el numero por cual vamos a dividir  number, este lo obtenemos de i
            int divisor = i;
            // Si se encuentra un divisor, el número no es primo
            if (number % divisor == 0) return false;
        }
        // Si no se encontraron divisores, el número es primo
        return true;
    }

    @Override
    public List<Primo> getFirstTenNumberPrime() {
        List<Primo> numberList = new ArrayList<>();
        int i = 0; // Contador
        int amount = 10; // cantidad de n numeros que se desean mostrar
        int number = COUNTER_START; //

        while (i < amount) {

            if (isPrime(number)) {
                numberList.add(Primo.builder().number(number).build());
                i++;
            }

            number++;
        }
        log.info("Los primero {} numeros primos son", amount);
        log.info(numberList);
        return numberList;
    }
}
