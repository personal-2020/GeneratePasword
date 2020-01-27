/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import GeneratorPassword.GeneratorPassword.model.Hourse;
import GeneratorPassword.GeneratorPassword.model.Matriz;
import GeneratorPassword.GeneratorPassword.persistence.impl.Tupla;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cefar -- Dicomatico
 */
@Service
public class PasswordGeneratorStub implements PaswordGeneratorServices {

    static List<Tupla> posAll = new ArrayList<Tupla>();
    List<Tupla> posVi = new ArrayList<Tupla>();

    String numeroS = "";
    private String numero = "";
    Hourse ho;
    Matriz ma;
    Tupla posActual;
    List<Tupla> po;
    int matris[][] = new int[5][4];

    public PasswordGeneratorStub() {
        ho = new Hourse();
        ma = new Matriz();
        posActual = ho.getPosInitial();
        matris = ma.getMartis();

    }

    @Override
    public List<Tupla> getVisitados() {
        return posVi;
    }

    public String getNumeroFinal() {
        return numero;
    }

    @Override
    public void GenerateRandom(Matriz matris) {
        ma = matris;
        ma.setIniciado(true);
        int[][] matri = ma.getMartis();
        for (int x = 0; x < matri.length; x++) {
            for (int y = 0; y < matri[x].length; y++) {
                if (matri[x][y] == -1) {
                    matri[x][y] = getNumRandom();
                } else if (matri[x][y] != -1) {
                    matri[x][y] = getNumRandom();
                }
            }
        }
    }

    @Override
    public String numberOfMatriz() {
        numeroS = "";
        System.out.println("EL numero es: " + numeroS);
        if (ma.getIniciado()) {
            posVi.clear();//Si no se indica una posicion se toma la del caballo.
            int cont = 0;
            int a = 0; //Extraemos la matriz de matriz
            int matris[][] = ma.getMartis();//COn la posicion inicial del caballo tomamos ese numero y agregamos la posicion a las pos ya visitadas.
            //Para el caso base tomamos como el primer elemento a ingresar, por ende la lista de visitados esta vacia.
            //posVi.add(posActual);
            //Actualizamos posActual con la primera ocurrencia de la lista de posibilidadess.
            for (int g = 0; g < 20; g++) {
                a = 0;
                po = posibilitis(posActual);
                if (po.size() > 0) {
                    if (a < po.size()) {
                        while (a < po.size()) {//posActual = po.get(a);
                            posActual = po.get((int) (Math.random() * (po.size())));
                            if (esta(posActual)) {
                                a++;
                            } else {
                                posVi.add(posActual);
                                numeroS += String.valueOf(matris[(Integer) posActual.getElem2()][(Integer) posActual.getElem1()]);
                                a = 0;
                                break;
                            }
                        }
                    } else if (a >= po.size()) {
                        posActual = getNewPosition();
                        posVi.add(posActual);
                        numeroS += String.valueOf(matris[(Integer) posActual.getElem2()][(Integer) posActual.getElem1()]);
                        a = 0;
                    }
                } else if (po.isEmpty()) {
                    posActual = getNewPosition();
                    posVi.add(posActual);
                    numeroS += String.valueOf(matris[(Integer) posActual.getElem2()][(Integer) posActual.getElem1()]);
                    a = 0;
                }
            }
            numero = numeroS;
        }
        System.out.println("el numero es: " + numeroS);
        return numeroS;
    }

    @Override
    public Boolean esta(Tupla pos) {
        Boolean es = false;
        if (posVi.size() > 0) {
            for (Tupla tu : posVi) {
                if (tu.getElem1().equals(pos.getElem1()) && (tu.getElem2().equals(pos.getElem2()))) {
                    es = true;
                }
            }
        }
        return es;
    }

    @Override
    public Tupla getNewPosition() {
        boolean seguir = true;
        boolean g = false;
        int tamv = posVi.size();
        Tupla t = new Tupla();
        int qq = 0;
        while (qq < posAll.size() && seguir) {
            Tupla kk = posAll.get(qq);
            if (!posVi.contains(kk)) {
                seguir = false;
                t.setElem1(kk.getElem1());
                t.setElem2(kk.getElem2());
            }
            qq++;
        }
        return t;
    }

    @Override
    public Integer getNumRandom() {
        return (int) (Math.random() * 10);
    }

    @Override
    public List<Tupla> posibilitis(Tupla position) {
        int rowsm = ma.getRows();
        int columm = ma.getColumns();
        List<Tupla> posibilities = new ArrayList<Tupla>();
        int posColIni = (int) position.getElem1();
        int posRowsIni = (int) position.getElem2();
        Tupla tu = new Tupla();
        List<Tupla> posb = ho.getMovements();
        for (Tupla po : posb) { // C y F
            int columnPosb = (int) po.getElem1();
            int rowsPosb = (int) po.getElem2();    // In here calculate the new position
            int newPoaitionColumn = posColIni + columnPosb;
            int newPositionRows = posRowsIni + rowsPosb;
            if (newPoaitionColumn < columm && newPositionRows < rowsm && newPoaitionColumn >= 0 && newPositionRows >= 0) {
                Tupla h = new Tupla(newPoaitionColumn, newPositionRows);
                if (!esta(h)) {
                    posibilities.add(h);
                }
            }
        }
        return posibilities;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String paintMatrs() {
        int[][] matDib = ma.getMartis();
        String resp = "";
        for (int x = 0; x < matDib.length; x++) {
            resp += " - FILA :" + x;
            System.out.println("Fila ; " + x);
            for (int y = 0; y < matDib[x].length; y++) {
                resp += " - COLUMNA : " + y;
                System.out.println("Columna : " + y);
                resp += " :  " + matDib[x][y];
                System.out.println(matDib[x][y]);
            }
        }
        return resp;
    }

    static {
        posAll.add(new Tupla(0, 0));
        posAll.add(new Tupla(0, 1));
        posAll.add(new Tupla(0, 2));
        posAll.add(new Tupla(0, 3));
        posAll.add(new Tupla(1, 0));
        posAll.add(new Tupla(1, 1));
        posAll.add(new Tupla(1, 2));
        posAll.add(new Tupla(1, 3));
        posAll.add(new Tupla(2, 0));
        posAll.add(new Tupla(2, 1));
        posAll.add(new Tupla(2, 2));
        posAll.add(new Tupla(2, 3));
        posAll.add(new Tupla(3, 0));
        posAll.add(new Tupla(3, 1));
        posAll.add(new Tupla(3, 2));
        posAll.add(new Tupla(3, 3));
        posAll.add(new Tupla(4, 0));
        posAll.add(new Tupla(4, 1));
        posAll.add(new Tupla(4, 2));
        posAll.add(new Tupla(4, 3));
    }
}
