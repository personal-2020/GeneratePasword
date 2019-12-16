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

    Hourse ho;
    Matriz ma;

    public PasswordGeneratorStub() {
        ho = new Hourse();
        ma = new Matriz();

    }

    @Override
    public void GenerateRandom(Matriz matris) {

        ma = matris;
        System.out.println("la matris es. "+ma);
        int[][] matri = ma.getMartis();
        for (int x = 0; x < matri.length; x++) {
            for (int y = 0; y < matri[x].length; y++) {
                if(matri[x][y]==-1){
                    matri[x][y]=getNumRandom();                
                }                
            }
        }

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
    
    private List<Tupla> posibilitis(Tupla position) {
        
        int rowsm = ma.getColumns();
        int columm = ma.getColumns();
        List<Tupla> posibilities = new ArrayList<Tupla>();

        int posColIni = (int) position.getElem1();
        int posRowsIni = (int) position.getElem2();
        Tupla tu = new Tupla();
        List<Tupla> posb = ho.getMovements();
        System.out.println("el tamaño de movi es: " + posb.size());
        for (Tupla po : posb) {
            // C y F
            int columnPosb = (int) po.getElem1();
            int rowsPosb = (int) po.getElem2();
            System.out.println("los elementos a revisar son :" + columnPosb + "y : " + rowsPosb);
            // In here calculate the new position
            int newPoaitionColumn = posColIni + columnPosb;
            int newPositionRows = posRowsIni + rowsPosb;
            if (newPoaitionColumn < columm && newPositionRows < rowsm && newPoaitionColumn >= 0 && newPositionRows >= 0) {                                   
                    posibilities.add(po);
                }
            }        
        return posibilities;
    }
     
    @Override
    public void prueba() {
        System.out.println("hola mundo");
    }

    @Override
    public void paintMatrs() {       
        int[][] matDib = ma.getMartis();

        for (int x = 0; x < matDib.length; x++) {
            System.out.println("Fila ; "+x);
            for (int y = 0; y < matDib[x].length; y++) {
                System.out.println("Columna : "+y);
                System.out.println(matDib[x][y]);
            }
        }

    }

}
