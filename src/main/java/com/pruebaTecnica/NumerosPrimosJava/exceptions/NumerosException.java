package com.pruebaTecnica.NumerosPrimosJava.exceptions;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class NumerosException extends Exception {
    public NumerosException(String mensaje) {
        super(mensaje);
    }

    public static void validarNumeroPositivo(String valor) throws NumerosException {
        //System.out.println(valor);
        if (valor.matches(".*[a-zA-Z].*") && !valor.matches("-?\\d+(\\.\\d+)?")) {
            log.info("Numeros Exception: Entrada inválida. Se esperaba un número: {}",valor);
            throw new NumerosException("Entrada inválida. Se esperaba un número.");
        }



        int numero = Integer.parseInt(valor);
        if (numero <= 0) {
            log.info("Numeros Exception: Entrada inválida. Se esperaba un número positivo: {}",valor);
            throw new NumerosException("Entrada inválida. Se esperaba un número positivo.");
        }
    }
}
