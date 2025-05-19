package com.grupo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TresEnRayaTest {

    // Prueba para lanzar excepción cuando X está fuera del rango permitido

    @Test
    public void testEjeXFueraDeRango() {
        TresEnRaya juego = new TresEnRaya();
        assertThrows(IllegalArgumentException.class, () -> juego.colocarFicha(3, 1));
    }

    @Test
    public void testEjeYFueraDeRango() {
        TresEnRaya juego = new TresEnRaya();
        assertThrows(IllegalArgumentException.class, () -> juego.colocarFicha(1, 3));
    }

    @Test
    public void testPosicionOcupada() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0);
        assertThrows(IllegalStateException.class, () -> juego.colocarFicha(0, 0));
    }

    @Test
    public void testTurnosAlternos() {
        TresEnRaya juego = new TresEnRaya();
        assertEquals('X', juego.getTurno());
        juego.colocarFicha(0, 0);
        assertEquals('O', juego.getTurno());
        juego.colocarFicha(0, 1);
        assertEquals('X', juego.getTurno());
    }

    @Test
    public void testGanadorFila() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0); // X
        juego.colocarFicha(1, 0); // O
        juego.colocarFicha(0, 1); // X
        juego.colocarFicha(1, 1); // O
        juego.colocarFicha(0, 2); // X
        assertEquals('X', juego.verificarGanador());
    }
}
