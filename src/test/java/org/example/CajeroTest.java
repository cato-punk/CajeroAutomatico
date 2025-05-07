package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class CajeroTest {

    private Cajero cajero; // No es necesario instanciar Cajero directamente ya que los métodos son estáticos
    private final InputStream standardIn = System.in;
    private ByteArrayInputStream testIn;

    @BeforeEach
    void setUp() {// reiniciar el saldo antes de cada prueba para asegurar la independencia
        Cajero.saldo = 100000; //para despues
        Cajero.scanner = new Scanner(System.in);
    }

    @Test
    void retirar_montoValido_reduceSaldo() {
        Cajero.retirar(50000); //para despues
        assertEquals(50000, Cajero.obtenerSaldo(), "El saldo debe reducirse después de un retiro válido");
    }
