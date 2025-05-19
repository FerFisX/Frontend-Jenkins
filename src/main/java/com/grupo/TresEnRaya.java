package com.grupo;

public class TresEnRaya {
    // Clase principal que contiene la lógica del juego Tres en Raya
    private final char[][] tablero = new char[3][3];
    private char turnoActual = 'X';

    // Inicializamos el tablero vacío con espacios

    public TresEnRaya() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = ' ';
    }

    public void colocarFicha(int x, int y) {
        // Validamos que la coordenada X esté dentro del rango
        if (x < 0 || x >= 3) throw new IllegalArgumentException("Eje X fuera de rango");
        // Validamos que la coordenada Y esté dentro del rango
        if (y < 0 || y >= 3) throw new IllegalArgumentException("Eje Y fuera de rango");
        if (tablero[x][y] != ' ') throw new IllegalStateException("Posición ocupada");

        tablero[x][y] = turnoActual;
        turnoActual = (turnoActual == 'X') ? 'O' : 'X';
    }

    public char getTurno() {
        return turnoActual;
    }

    public char verificarGanador() {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2])
                return tablero[i][0];
            if (tablero[0][i] != ' ' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i])
                return tablero[0][i];
        }

        // Verificar diagonales
        if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2])
            return tablero[0][0];
        if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0])
            return tablero[0][2];

        return ' ';
    }
}
