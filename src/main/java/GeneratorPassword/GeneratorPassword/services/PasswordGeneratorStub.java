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

    List<Tupla> posVi = new ArrayList<Tupla>();

    String numeroS = "";

    Hourse ho;
    Matriz ma;
    Tupla posActual;
    int matris[][] = new int[5][4];

    public PasswordGeneratorStub() {
        ho = new Hourse();
        ma = new Matriz();
        posActual = ho.getPosInitial();
        matris = ma.getMartis();

    }

    @Override
    public void GenerateRandom(Matriz matris) {

        ma = matris;
        System.out.println("la matris es. " + ma);
        int[][] matri = ma.getMartis();
        for (int x = 0; x < matri.length; x++) {
            for (int y = 0; y < matri[x].length; y++) {
                if (matri[x][y] == -1) {
                    matri[x][y] = getNumRandom();
                }
            }
        }
    }

    @Override
    public String numberOfMatriz() {
        //Si no se indica una posicion se toma la del caballo.
        int cont = 0;
        //Extraemos la matriz de matriz
        int matris[][] = ma.getMartis();
        //COn la posicion inicial del caballo tomamos ese numero y agregamos la posicion a las pos ya visitadas.

        //Para el caso base tomamos como el primer elemento a ingresar, por ende la lista de visitados esta vacia.
        posVi.add(posActual);
        //Actualizamos posActual con la primera ocurrencia de la lista de posibilidadess.
        List<Tupla> po = posibilitis(posActual);

        posActual = po.get(0);
//        System.out.println("TAMAÑO DE MATRIZ : " + matris.length);
        //System.out.println("columnas y filas ma :" + ma.getColumns() + "filaas " + ma.getRows());

        //System.out.println("Que arroja las pos de posActual: 1: > " + posActual.getElem1() + " 2: " + posActual.getElem2());
        numeroS += String.valueOf(matris[(Integer) posActual.getElem2()][(Integer) posActual.getElem1()]);

        while (cont < 20) {
            //Tupla temp = new Tupla();
            int a = 0;
            //Primero se calcula si POsActual esta o no
            if (!esta(posActual)) {
                System.out.println("Entrmaos 1");
                posVi.add(posActual);
                //Calculamos la snuevas posibles movidas.
                po = posibilitis(posActual);
                System.out.println("Que arroja las pos de posActual: 2: > " + posActual.getElem2() + " : " + posActual.getElem1());
                numeroS += String.valueOf(matris[(Integer) posActual.getElem2()][(Integer) posActual.getElem1()]);
                po.remove(0);
                System.out.println("QUE ES P0 :" + po.get(0).getElem2() + " y: " + po.get(0).getElem1());
                posActual = po.get(0);
                cont++;
                System.out.println("CONT VA EN : " + cont);
            } else {
                //falta
                while (a < 8 && cont < 20) {
                    if (!esta(posActual)) {//si no esta tome esa posicion
                        System.out.println("Entrmaos 2");
                        posVi.add(posActual);
                        //Calculamos la snuevas posibles movidas.
                        po = posibilitis(posActual);
                        numeroS += String.valueOf(matris[(Integer) posActual.getElem2()][(Integer) posActual.getElem1()]);
                        po.remove(0);
                        posActual = po.get(0);
                        cont++;
                        System.out.println("CONT VA EN : " + cont);
                        a = 0;
                    } else {
                        if (po.size() > 1) {
                            System.out.println("Entrmaos 3");
                            po.remove(0);
                            posActual = po.get(0);
                            a++;
                            System.out.println("como va a1 : " + a);
                        } else {
                            po = posibilitis(getNewPosition());
                            posActual = po.get(0);
                            //if (!esta(posActual)) {
                                numeroS += String.valueOf(matris[(Integer) posActual.getElem2()][(Integer) posActual.getElem1()]);
                                po.remove(0);
                                posActual = po.get(0);
                                cont++;
                            //}

                            System.out.println("CONT VA EN : " + cont);

                            System.out.println("Entrmaos 4");
                            a++;
                            System.out.println("como va a2 : " + a);
                        }

                    }

                }
                if (a >= 8) {
                    posActual = getNewPosition();
                }

            }
            //cont++;
            System.out.println("como va contador : " + cont);

        }
        System.out.println("El numero es : " + numeroS);

        return numeroS;
    }

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

    public Tupla getNewPosition() {

        Tupla t = new Tupla();

        int a = 0;
        int b = 0;

        Boolean tem = true;
        while (tem & a < 6 & b < 5) {
            for (Tupla g : posVi) {
                if (g.getElem1().equals(a) && g.getElem2().equals(b)) {
                    a++;
                    b++;
                } else {
                    tem = false;
                    t.setElem1(a);
                    t.setElem2(b);
                }
            }
        }
        return t;

    }

    @Override
    public Integer getNumRandom() {
        return (int) (Math.random() * 10);
    }

    /**
     *
     *
     * List<Tupla> mov = ho.getMovements(); Tupla init = ma.getPostInitial();
     * Tupla posActual = init; int cont = 0; while (cont < 20) {
     * System.out.println("como va contador : " + cont); System.out.println("pos
     * acxtual : " + posActual); List<Tupla> posibilities =
     * posibilitis(posActual); System.out.println("Las posibilidades son:" +
     * posibilities.size());
     *
     * if (posibilities.size() > 0) {
     *
     * //We get a firts element of list posibilities, and try star with this.
     * Boolean t = true; System.out.println("t es :" + t); int numt = 0; while
     * (t) { int numero = (int) (Math.random() * 10+1);
     * System.out.println("cuanto va numt : " + numt); System.out.println("que
     * es t t : " + t); if (numt < 20&& numt<posibilities.size()) { Tupla q =
     * posibilities.get(numt); int nc = (int) posActual.getElem1() + (int)
     * q.getElem1(); int nr = (int) posActual.getElem1() + (int) q.getElem1();
     * if (nc < ma.getColumns() && nr < ma.getRows()) { List<Tupla> temp =
     * ma.getFinderColumnandRows(nc); if (!(Boolean) temp.get(nr).getElem2()) {
     * if ((int) temp.get(nr).getElem1() == -1) {
     * System.out.println("cambiamos"); ma.setStadeOfNumber(numero, nc, nr); t =
     * false; } } } numt++; } else { t = false; } } } else {//This case will be
     * when the list of posibilites are empty .
     *
     *
     * }
     * cont++; }
     */
    @Override
    //private List<Tupla> posibilitis(Tupla position) {
    public List<Tupla> posibilitis(Tupla position) {
        int rowsm = ma.getRows();
        int columm = ma.getColumns();
        List<Tupla> posibilities = new ArrayList<Tupla>();

        int posColIni = (int) position.getElem1();
        int posRowsIni = (int) position.getElem2();
        Tupla tu = new Tupla();
        List<Tupla> posb = ho.getMovements();
        for (Tupla po : posb) {
            // C y F
            int columnPosb = (int) po.getElem1();
            int rowsPosb = (int) po.getElem2();
            // In here calculate the new position
            int newPoaitionColumn = posColIni + columnPosb;
            int newPositionRows = posRowsIni + rowsPosb;
            if (newPoaitionColumn < columm && newPositionRows < rowsm && newPoaitionColumn >= 0 && newPositionRows >= 0) {
                posibilities.add(new Tupla(newPoaitionColumn, newPositionRows));
            }
        }

        for (Tupla f : posibilities) {
            System.out.println("Las nuevas posibilidades son: " + f.getElem1() + " : y : " + f.getElem2());

        }

        return posibilities;
    }

    @Override
    public void paintMatrs() {
        int[][] matDib = ma.getMartis();

        for (int x = 0; x < matDib.length; x++) {
            System.out.println("Fila ; " + x);
            for (int y = 0; y < matDib[x].length; y++) {
                System.out.println("Columna : " + y);
                System.out.println(matDib[x][y]);
            }
        }

    }

}
