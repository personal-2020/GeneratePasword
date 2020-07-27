/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cefar -- Dicomatico
 */
public class Matriz {

    private int rows;
    private int columns;
    private int elements;
    private Tupla postInitial;
    private Boolean iniciado;
    private int matris[][] = new int[5][4]; //C  F

    /**
     *Constructor vacio.
     */
    public Matriz() {
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 4; b++) {
                matris[a][b] = -1;
            }}
        iniciado = false;
    }

    /**
     *  Constructor con varios parametros.
     * @param rows  Entero que representa la fila de la matriz.
     * @param columns   Entero que representa la columna de la matriz.
     * @param postInitial   Posicion inicial donde comienza el recorrido del caballo.
     */
    public Matriz(int rows, int columns, Tupla postInitial) {
        matris = new int[rows][columns];
        this.postInitial = postInitial;
        this.rows = rows;
        this.columns = columns;
        this.elements = rows * columns;
        iniciado = false;
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < columns; b++) {
                matris[a][b] = -1;
            }
        }}

    /**
     * Valor booleano que representa si la matriz ha sido iniciado.
     * @return iniciado
     */
    public Boolean getIniciado() {
        return iniciado;
    }

    /**
     * Establece el valor de la variable iniciado.
     * @param iniciado 
     */
    public void setIniciado(Boolean iniciado) {
        this.iniciado = iniciado;
    }

    /**
     * Devuelve la posicion inicial del caballo de ajedrez.
     * @return postInitial
     */
    public Tupla getPostInitial() {
        return postInitial;
    }

    /**
     * Retorna la cantidad de filas de la matriz.
     * @return rows
     */
    public Integer getRows() {
        return rows;
    }

    /**
     * Retorna la cantidad de columna de la matriz.
     * @return columns
     */
    public Integer getColumns() {
        return columns;
    }

    /**
     * Retorna el objeto matriz.
     * @return matris
     */
    public int[][] getMartis() {
        return matris;
    }

    /**
     * Retorna la cantidad de elementos de la matriz.
     * @return elements
     */
    public Integer getElements() {
        return elements;
    }

    /**
     * Genera un numero aleatorio entre 0 y 9
     */
    public void GenerateRandom() {
        int numero = (int) (Math.random() * 10);
    }
    
    /**
     * Funcion que retorna el objeto en Stgring.
     * @return 
     */
    @Override public String toString(){ 
        return "Matriz{" + "columns=" + columns + "rows=" + rows  + '}'; 
    }        
    
}
