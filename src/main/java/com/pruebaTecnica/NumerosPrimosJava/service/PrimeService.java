package com.pruebaTecnica.NumerosPrimosJava.service;

import com.pruebaTecnica.NumerosPrimosJava.models.entity.Primo;

import java.util.List;

public interface PrimeService {

    Boolean isPrime( int number);
    List<Primo> getFirstTenNumberPrime();
}
