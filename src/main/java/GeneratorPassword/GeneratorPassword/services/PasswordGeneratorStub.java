/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.services;

import GeneratorPassword.GeneratorPassword.model.Hourse;
import GeneratorPassword.GeneratorPassword.model.Matriz;
import GeneratorPassword.GeneratorPassword.model.Tupla;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cefar -- Dicomatico
 */
@Service
public class PasswordGeneratorStub implements PaswordGeneratorServices {

    private static List<Tupla> posAll = new ArrayList<Tupla>();
    private List<Tupla> posVi = new ArrayList<Tupla>();
    private String numeroS = "";
    private String numero = "";
    private Hourse ho = new Hourse();
    private Matriz ma = new Matriz();
    private Tupla posActual;
    private List<Tupla> po;
    private int matris[][] = new int[5][4];
    private Tupla posInit = new Tupla((int) (Math.random() * 4), (int) (Math.random() * 3));

    /**
    * Constructor del PasswordGeneratorStub. En el cual se crean los objetos 
    * para su correcto funcionamiento.
        * Hourse.
        * Matriz.         
     */
    public PasswordGeneratorStub() {
        ho = new Hourse();        
        posActual = ho.getPosInitial();
        matris = ma.getMartis();
    }
    
    /**
     * Esta funcion permite generar una nueva matriz con una posicion inicial diferente cada vez.
     */
    @Override
    public void generateNewMatriz(){
        Tupla posInit = new Tupla((int) (Math.random() * 3), (int) (Math.random() * 4));
        System.out.println("que posiciones miramos: El1: "+posInit.getElem1()+"--ELEMENTO 2: "+posInit.getElem2());
        ma = new Matriz(4, 5, posInit);
    }
    
    /**
     * Esta funcion retorna una lista de tipo tuplas con las posiciones visitadas por
     * el caballo.
     * @return posVi Una lista de tipo Tupla.
     */
    @Override
    public List<Tupla> getVisitados() {
        return posVi;
    }
    
    /**
     * Retorna un String que representa el numero final despues del recorrido 
     * del caballo.
     * @return numero String representando el numero fin.
     */
    public String getNumeroFinal() {
        return numero;
    }
    
    /**
     * Retorna la matriz
     * @return ma
     */
    @Override
    public Matriz getMatrizz(){
        return ma;
    }
    
    /**
     * Esta funcion rellena la matriz inicial con numeros 
     * aleatorios entre 0 y 9.
     * O la vuelve a reescribir la matriz si ya fue usada.
     * @param matris Objeto de tipo matriz que representa una matriz de 4x5
     * que almacena numeros aleatorios entre 0 y 9.
     */
    @Override
    public void GenerateRandom() {
        ma.setIniciado(true);
        int[][] matri = ma.getMartis();
        for (int x = 0; x < matri.length; x++) {
            for (int y = 0; y < matri[x].length; y++) {                
                if (matri[x][y] == -1) {
                    matri[x][y] = getNumRandom();
                } else if (matri[x][y] != -1) { 
                    matri[x][y] = getNumRandom();
                }}}
    }

    /**
     * Esta matriz genera el numero final a partir de una matriz de numeros entre 0 y 9.
     * @return numeroS String que representa el numero generado.
     */
    @Override
    public String numberOfMatriz() {
        numeroS = "";
        if (ma.getIniciado()) {//Si no se indica una posicion se toma la del caballo.
            posVi.clear();//Extraemos la matriz de matriz
            int cont = 0;//COn la posicion inicial del caballo tomamos ese numero y agregamos la posicion a las pos ya visitadas.
            int a = 0; //Para el caso base tomamos como el primer elemento a ingresar, por ende la lista de visitados esta vacia.
            int matris[][] = ma.getMartis();//posVi.add(posActual);
            for (int g = 0; g < 20; g++) {//Actualizamos posActual con la primera ocurrencia de la lista de posibilidadess.
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
                            }}
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
                }}
            numero = numeroS;
        }
        System.out.println("el numero es: " + numeroS);
        return numeroS;
    }

    /**
     * Esta funcion nos informa si la posicion ha sido visitada o no en la matris.
     * @param pos Posicion tipo Tupla que representa la posicion a analizar.
     * @return esta Variable tipo boolean que representa si la posicion ha sido o no visitada.
     */
    @Override
    public Boolean esta(Tupla pos) {
        Boolean esta = false;
        if (posVi.size() > 0) {
            for (Tupla tu : posVi) {
                if (tu.getElem1().equals(pos.getElem1()) && (tu.getElem2().equals(pos.getElem2()))) {
                    esta = true;
                }}
        }
        return esta;
    }

    /**
     * Esta funcion retorna una posicion que se encuentre no visitada 
     * por el caballo en la matriz.
     * @return nuevaPosicion De tipo Tupla que representa una nueva 
     * posicion libre para el recorrido del caballo.
     */
    @Override
    public Tupla getNewPosition() {
        boolean seguir = true;
        boolean g = false;
        Tupla nuevaPosicion = new Tupla();
        int qq = 0;
        while (qq < posAll.size() && seguir) {
            Tupla kk = posAll.get(qq);
            if (!posVi.contains(kk)) {
                seguir = false;
                nuevaPosicion.setElem1(kk.getElem1());
                nuevaPosicion.setElem2(kk.getElem2());
            }
            qq++;
        }
        return nuevaPosicion;
    }

    /**
     * Genera un numero aleatorio entre 0 y 9.
     * @return numero Entero generado entre 0 y 9.
     */
    @Override
    public Integer getNumRandom() {
        return (int) (Math.random() * 10);
    }

    /**
     * Esta funcion genera las multiples posiciones que el caballo puede tomar.
     * @param position Posicion donde se encuentra el caballo.
     * @return posibilities Lista de tipo Tupla con las diferentes 
     * posibilidades del recorrido del caballo.
     */
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
                }}}
        return posibilities;
    }

    /**
     * Esta funcion trae el numero de tipo String.
     * @return numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Remplaza el numero final.
     * @param numero 
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Funcion que representa de manera grafica la matriz.
     * @return String Que representa la matriz.
     */
    @Override
    public String paintMatrs() {
        int[][] matDib = ma.getMartis();
        String resp = "";
        for (int x = 0; x < matDib.length; x++) {
            resp +="<br>";
            resp += " - FILA : " + x;
            resp +="<br>";
            System.out.println("Fila ; " + x);
            for (int y = 0; y < matDib[x].length; y++) {
                resp += " /- COLUMNA :  " + y;
                System.out.println("Columna : " + y+"-/");
                resp += " :  " + matDib[x][y];
                System.out.println(matDib[x][y]);
            }}
        return resp;
    }
    static {
        posAll.add(new Tupla(0, 0));posAll.add(new Tupla(0, 1));posAll.add(new Tupla(0, 2));
        posAll.add(new Tupla(0, 3));posAll.add(new Tupla(1, 0));posAll.add(new Tupla(1, 1));
        posAll.add(new Tupla(1, 2));posAll.add(new Tupla(1, 3));posAll.add(new Tupla(2, 0));
        posAll.add(new Tupla(2, 1));posAll.add(new Tupla(2, 2));posAll.add(new Tupla(2, 3));
        posAll.add(new Tupla(3, 0));posAll.add(new Tupla(3, 1));posAll.add(new Tupla(3, 2));
        posAll.add(new Tupla(3, 3));posAll.add(new Tupla(4, 0));posAll.add(new Tupla(4, 1));
        posAll.add(new Tupla(4, 2));posAll.add(new Tupla(4, 3));
    }
}
