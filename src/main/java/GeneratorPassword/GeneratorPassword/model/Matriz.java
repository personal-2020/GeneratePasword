/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.model;

import GeneratorPassword.GeneratorPassword.persistence.impl.Tupla;
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
    private int matris[][]=new int[5][4];
                                 //C  F
    
    public Matriz() {

        for (int a = 0; a < 5; a++) {
            //
            for (int b = 0; b < 4; b++) {
                matris[a][b] = -1;
            }
        }

    }

    public Matriz(int rows, int columns, Tupla postInitial) {      
        matris=new int[rows][columns];
        this.postInitial = postInitial;
        this.rows = rows;
        this.columns = columns;
        this.elements = rows * columns;
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < columns; b++) {
                matris[a][b] = -1;
            }
        }
        /**
        System.out.println("ahora veremos");
        for (int x = 0; x < matris.length; x++) {
            for (int y = 0; y < matris[x].length; y++) {
                System.out.println(matris[x][y]);
            }
        }*/
    }

    public Tupla getPostInitial() {
        return postInitial;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public int[][] getMartis() {
        return matris;
    }
    
    public Integer getElements() {
        return elements;
    }
     
    public void GenerateRandom() {

        int numero = (int) (Math.random() * 10);

    }

    public Integer getTamC() {
        return columns;
    }

    public Integer getTamF() {
        return rows;
    }

    /**
     * @Override public String toString() { return "Matriz{" + "dato=" + dato +
     * "pos=" + pos + "nombre=" + nombre + '}';
    }
     */
}
