/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.persistence.impl;

import GeneratorPassword.GeneratorPassword.services.PasswordException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Cefar -- Dicomatico
 */
public class Diccionario {

    private static Map<String, List<Tupla>> map;
    private static List<Tupla> arrA;
    private static List<Tupla> arrB;
    private static List<Tupla> arrC;
    private static List<Tupla> arrD;
    private static List<Tupla> arrE;
    private static List<Tupla> arrF;

    public Diccionario() {

    }

    public Map<String, List<Tupla>> getMap(){
        return map;
    }
    public List<Tupla> getListOfLetter(String letra) throws PasswordException{               
        if(map.containsKey(letra)){                        
             return map.get(letra);       
        }else{            
            throw  new PasswordException("NO se encuentra esa letra");                    
        }
    }

    static {
        map = new HashMap<String, List<Tupla>>();
        arrA = new ArrayList<Tupla>();
        arrA.add(new Tupla("Abatatar", 0));arrA.add(new Tupla("abejorro ", 0));arrA.add(new Tupla("Ábaco", 0));arrA.add(new Tupla("Abajo", 0));arrA.add(new Tupla("Abanico", 0));arrA.add(new Tupla("Abdomen", 0));arrA.add(new Tupla("Abeja", 0));arrA.add(new Tupla("Abierto", 0));arrA.add(new Tupla("Abogado", 0));arrA.add(new Tupla("Aborigen", 0));arrA.add(new Tupla("Abreviar", 0));arrA.add(new Tupla("Abrojo", 0));
        arrA.add(new Tupla("Absoluto", 0));arrA.add(new Tupla("Abundancia", 0));arrA.add(new Tupla("Aburrir", 0));arrA.add(new Tupla("Acabar", 0));arrA.add(new Tupla("Academia", 0));arrA.add(new Tupla("Acaro", 0));arrA.add(new Tupla("Acceder", 0));arrA.add(new Tupla("Acecho", 0));arrA.add(new Tupla("Aceptar", 0));arrA.add(new Tupla("Acompañar", 0));arrA.add(new Tupla("Acreditar", 0));arrA.add(new Tupla("Acuario", 0));
        arrA.add(new Tupla("Acuse", 0));arrA.add(new Tupla("Adjetivo", 0));arrA.add(new Tupla("Adúltero", 0));arrA.add(new Tupla("Aéreo", 0));arrA.add(new Tupla("Afirmar", 0));arrA.add(new Tupla("Afuera", 0));arrA.add(new Tupla("Agachar", 0));arrA.add(new Tupla("Agencia", 0));arrA.add(new Tupla("Abstracto", 0)); arrA.add(new Tupla("Agrícola", 0));arrA.add(new Tupla("Agora", 0));arrA.add(new Tupla("Aguijón", 0));
        arrA.add(new Tupla("Aguja", 0));arrA.add(new Tupla("Aire", 0));arrA.add(new Tupla("Afecto", 0));arrA.add(new Tupla("Agil", 0));arrA.add(new Tupla("Ajustar", 0));arrA.add(new Tupla("Alarma", 0));arrA.add(new Tupla("Ahorrar", 0));arrA.add(new Tupla("Albino", 0));arrA.add(new Tupla("Acatar", 0));arrA.add(new Tupla("Asentar", 0));arrA.add(new Tupla("Ayuntamiento", 0));arrA.add(new Tupla("Asociación", 0));
        arrA.add(new Tupla("Atisbar", 0));arrA.add(new Tupla("Androide", 0));

/**afluente,ágata,agua,águila,ajenjo,alabardero,alacrán,alarife,albarán,albaricoque,albergue,álbum,alcachofa,alcohol,alfabeto,alforja,algoritmo,alicate,aliento,alimento,allí,almanaque,almirante,almohada,alumbrado,amanecer,amargo,ámbar,ambiente,ameba,ameno,amigo,amor,amparo,ampliar,anacardo,ánade,anaquel,anatomía,ancho,anciano,andar,anécdota,ánfora,angosto,anguila,ángulo,anillo,animal,anochecer,anorak,ansia,antena,anterior,antes,anticipar,antifaz,antiguo,antípoda
antojo,antología,anudar,anuncio,añil,apagar,aparcar,apartado,apático,apeo,apertura,apio,aplicar,apogeo,apóstrofe,apreciar,aprovechar,apuntar,aquelarre,arácnido,arbitrar,arcaico,archivo,área,argot,argumento,arista,arma,armador,armonía,arnés,arponero,arquitecto,arrabal,arraigo,arre,arrebatar,arrecife,arrendajo,arrendar,arrepentimiento,arroba,arrojar,arropar,arruga,arte,artículo,artífice,artillero,artista,artrosis,asador,asalto,asar,ascenso,asceta,asegurar,asilo,asistir,asno,aspecto,áspero,aspirina,astillero,astucia,
atajo,atasco,atiborrar,atinar,atizar,atosigar,atrás,atributo,atroz,aula,auricular,autógrafo,avance,avellana,aviador,azafrán,azúcar,azulejo.*/                
        arrB = new ArrayList<Tupla>();
        arrB.add(new Tupla("Babel", 0));arrB.add(new Tupla("bacteria", 0));arrB.add(new Tupla("Báculo", 0));arrB.add(new Tupla("Badulaque", 0));arrB.add(new Tupla("bahía", 0));arrB.add(new Tupla("Baila", 0));
        arrB.add(new Tupla("bajeza", 0));arrB.add(new Tupla("balada", 0));arrB.add(new Tupla("balancín", 0));arrB.add(new Tupla("Balaustrada", 0));arrB.add(new Tupla("balcón", 0));arrB.add(new Tupla("baldosa", 0));
        arrB.add(new Tupla("Balompédico", 0));arrB.add(new Tupla("ballesta", 0));arrB.add(new Tupla("Buzón", 0)); arrB.add(new Tupla("butaca", 0));arrB.add(new Tupla("Bestiario", 0));arrB.add(new Tupla("bufón", 0));arrB.add(new Tupla("Blanco", 0));arrB.add(new Tupla("barranco", 0));
        arrB.add(new Tupla("Bofetada", 0));arrB.add(new Tupla("borda", 0));arrB.add(new Tupla("Bípedo", 0));arrB.add(new Tupla("besamanos", 0));arrB.add(new Tupla("Bellota", 0));arrB.add(new Tupla("Bruma", 0));arrB.add(new Tupla("benceno", 0));arrB.add(new Tupla("Berrinche", 0));arrB.add(new Tupla("báscula", 0));arrB.add(new Tupla("barba", 0));
        arrB.add(new Tupla("Bergantín", 0));arrB.add(new Tupla("bético", 0));arrB.add(new Tupla("Bendito", 0));arrB.add(new Tupla("betún", 0));arrB.add(new Tupla("Benjamín", 0));arrB.add(new Tupla("Batalla", 0));arrB.add(new Tupla("bambú", 0));arrB.add(new Tupla("Burdel", 0));arrB.add(new Tupla("becario", 0));arrB.add(new Tupla("bandera", 0));
        arrB.add(new Tupla("Bautizar", 0));arrB.add(new Tupla("broche", 0));arrB.add(new Tupla("Bebida", 0));arrB.add(new Tupla("banda", 0));arrB.add(new Tupla("Blusa", 0));arrB.add(new Tupla("Bucear", 0));arrB.add(new Tupla("bigamia", 0));arrB.add(new Tupla("Berrendo", 0));arrB.add(new Tupla("belladona", 0));arrB.add(new Tupla("bandido", 0));
        arrB.add(new Tupla("barómetro", 0));arrB.add(new Tupla("Berlinés", 0));arrB.add(new Tupla("Beso", 0));arrB.add(new Tupla("bélico", 0));arrB.add(new Tupla("Berberecho", 0));arrB.add(new Tupla("beduino", 0));arrB.add(new Tupla("beato", 0));arrB.add(new Tupla("Búnker", 0));arrB.add(new Tupla("barbudo", 0));arrB.add(new Tupla("Bastidor", 0));        
/**babero,báculo,badén,bagaje,bailador,bajamar,bajar,bajonazo,baladí,balanza,balar,balbuceo,baldazo,balneario,balido,bálsamo,banano,banco,bandazo,baqueta,barbarismo,barco,bardo,barniz,barrer,barro,base,batería,bayo,bebedizo,becada,becerro,bedel,beicon,beige,bellaco,belleza,bello,beluga,bemoles,bendecir,beneficio,bengalí,beodo,bercial,berilio,berlinga,berza,besana,
bestia,beta,bicho,bicicleta,biela,bífida,bikini,binario,bingo,biología,birlar,birlibirloque,bledo,bocina,boicot,boina,bonito,boñiga,bragas,brea,brida,brillo,broma,bronco,brujo,bucal,búcaro,budista,buey,búfalo,buitre,bujía,bulevar,búlgaro,bulo,buñuelo,burdo,burgués,butano, **/      

//cabás cabed caben  cabes cabía cabio cable cabos cabra  cabré cabro cacán cacao  cacea cacee caceé cacen caceo caceó caces cacha cache caché cacho cachó cachú cacle cacos cacto caéis caeré cafés cafiz cafre cagad cagan  cagas cague cagué cahíz caían caías caico caída caído caiga caigo caima caire cairo caite cajas cajel cajín cajón calad calan calán cálao calar calas calca calce calcé calco calcó calda caldo cuñes cuños cuplé cupón cupos cuque cuqué curad cural curco curdo curen cures curie curio curro curtí curul curvo cusan cusen cusma cúter cutio cundo cunea cunen cuneo cuneó culos culpa culón
//calen caler cales calés cáliz calla calle callé callo calló calma calme calmé  calmó calón  calós calta calva calve calvé calvo calvó calza  calzó camal camao camas camba cambe cambo camio camón campa campe campé campó canas canda cande candé candi cando candó canea canee caneé caneo caneó canes canés  caney canez canga cango cania canil canje canoa canon canos cansa canse cansé canso cansó cante canté canto cantó cantú cañal cañar cutis cutra cuyos cuzma cúneo cunes cuñad cuñal cuñan cuñar cuñas cuñen cuide cuidé cuido cuidó cuija cuina cuino cuita cujas cujón cular culas culea culee culeé culén culeo     
//cañón caños caoba caobo capad capan  capas capás cauza cavad cavan caván cavar cavas cávea caven caves cavia cavío cavón cayán   colan colar colas colea colee coleé colen coleo coleó  cóleo coles colgó colín colla colle colma  colme colmé colmo colmó colón color  cosas cosca cosco  coscó cosed cosen  coses cosía cosió cosos cospe costa  coste costé costo costó cotad cotan cotar cotas coten cotes  cotín cotón cotos  cotúa couta  coxis coyán coyol crack crane crasa craso  craza cread crean rear creas  crece crecí credo creed creen creer crees creía cúmel cumpa cunad cunan cunar cunas cunda cunde cundí 
//crepe  cresa creso creta creyó  criad crían  crías criba cribe cribé  cribo cribó crica crida críen  críes crine críos croad croan croar croas croco  croen croes croma crome cromé  cromo cromó crono  croto  cruce  crucé cruda  cruje crují cruza cruzo cruzó cuaba cuaco cuado cuaga cuaja cuaje cuajé cuajo cuajó cuasi cuate cuatí cubas cubil cubos cubra cubre cubrí cubro cucad cucan  cucar cucas cucha cuche cuché cuchí cucho cucos cucuy cueca cuece cueco cuela cuele cuelo cuera cuero cuete cueto cueva cueza cuezo cugar cuica cuico cuida culpe culpé culpo  culta cumba cumbé cumbo culle culeó

        arrC = new ArrayList<Tupla>();
        arrC.add(new Tupla("Cuzco", 0));arrC.add(new Tupla("Cuyas", 0));arrC.add(new Tupla("cutre", 0));arrC.add(new Tupla("Cutos", 0));arrC.add(new Tupla("cutir", 0));arrC.add(new Tupla("cuspa", 0));arrC.add(new Tupla("Cusir", 0));arrC.add(new Tupla("cusca", 0));arrC.add(new Tupla("Curvó", 0));arrC.add(new Tupla("Curva", 0));arrC.add(new Tupla("curto", 0));arrC.add(new Tupla("curta", 0));
        arrC.add(new Tupla("Curso", 0));arrC.add(new Tupla("cursi", 0));arrC.add(new Tupla("curry", 0));arrC.add(new Tupla("Curre", 0));arrC.add(new Tupla("curra", 0));arrC.add(new Tupla("curía", 0));arrC.add(new Tupla("Curda", 0));arrC.add(new Tupla("curas", 0));arrC.add(new Tupla("curan", 0));arrC.add(new Tupla("Curar", 0));arrC.add(new Tupla("cuota", 0)); arrC.add(new Tupla("culto", 0));
        arrC.add(new Tupla("Culpó", 0));arrC.add(new Tupla("crujo", 0));arrC.add(new Tupla("cruja", 0));arrC.add(new Tupla("Cruel", 0));arrC.add(new Tupla("crudo", 0));arrC.add(new Tupla("croza", 0));arrC.add(new Tupla("Cross", 0));arrC.add(new Tupla("criar", 0));arrC.add(new Tupla("crepé", 0));arrC.add(new Tupla("Cremá", 0));arrC.add(new Tupla("coxal", 0));arrC.add(new Tupla("coser", 0));
        arrC.add(new Tupla("Cabal", 0));arrC.add(new Tupla("caber", 0));arrC.add(new Tupla("cacas", 0));arrC.add(new Tupla("Cabrá", 0));arrC.add(new Tupla("caerá", 0));arrC.add(new Tupla("cagar", 0));arrC.add(new Tupla("Cagón", 0));arrC.add(new Tupla("calmo", 0));arrC.add(new Tupla("calor", 0));arrC.add(new Tupla("Calzo", 0));arrC.add(new Tupla("campo", 0));arrC.add(new Tupla("canal", 0));
        arrC.add(new Tupla("Cañas", 0));arrC.add(new Tupla("capar", 0));
             
//dama danza disentir democrático	 dardos	densidad dato	desanimar dialecto diametral doctor decente	decir dictaminar dogma dietético dolor	diez donde decorar dos decretar	difícil	
//dédalo	dignidad duda dedicar dueño dedo dimensión dejadez dinastía durazno delgado dinero	        
        arrD = new ArrayList<Tupla>();
        arrD.add(new Tupla("Dexter", 0));arrD.add(new Tupla("Duna", 0));arrD.add(new Tupla("Derian", 0));arrD.add(new Tupla("Danira", 0));arrD.add(new Tupla("Dorian", 0));arrD.add(new Tupla("Donovan", 0));arrD.add(new Tupla("Donatella", 0));arrD.add(new Tupla("daga", 0));arrD.add(new Tupla("dioses", 0));arrD.add(new Tupla("documento", 0));arrD.add(new Tupla("dilucidar", 0));arrD.add(new Tupla("decena", 0));
        arrD.add(new Tupla("Darwin", 0));arrD.add(new Tupla("Dana", 0));arrD.add(new Tupla("Dixie", 0));arrD.add(new Tupla("Dinamarca", 0));arrD.add(new Tupla("Darío", 0));arrD.add(new Tupla("Dalí", 0));arrD.add(new Tupla("Dimas", 0));arrD.add(new Tupla("discreción", 0));arrD.add(new Tupla("diabetes", 0));arrD.add(new Tupla("docena", 0));arrD.add(new Tupla("decisión", 0));arrD.add(new Tupla("degradar", 0));
        arrD.add(new Tupla("duración", 0));arrD.add(new Tupla("duermen", 0));arrD.add(new Tupla("deliberar", 0));arrD.add(new Tupla("delito", 0));arrD.add(new Tupla("doble", 0));arrD.add(new Tupla("diferenciar", 0));arrD.add(new Tupla("dilema", 0));arrD.add(new Tupla("Domenico", 0));arrD.add(new Tupla("declarar", 0));arrD.add(new Tupla("Dante", 0));arrD.add(new Tupla("docilidad", 0));arrD.add(new Tupla("delicia", 0));
        arrD.add(new Tupla("disciplina", 0));arrD.add(new Tupla("demasiado", 0));arrD.add(new Tupla("disminuir", 0));arrD.add(new Tupla("deambular", 0));arrD.add(new Tupla("damasco", 0));arrD.add(new Tupla("dañino", 0));arrD.add(new Tupla("debate", 0));arrD.add(new Tupla("disparo", 0));arrD.add(new Tupla("dureza", 0));arrD.add(new Tupla("dualidad", 0));arrD.add(new Tupla("Damasco", 0));arrD.add(new Tupla("Delfina", 0));
        arrD.add(new Tupla("Darek", 0));arrD.add(new Tupla("dicha", 0));
       		
//Echar Economía Ecuador Editar Elefante Embudo Emprendimiento Enano Enchufe Enojado Estuche Equipo Erizo Escalera  Escarabajo Escoba  Escopeta Espada  Espejo Estrella Estrés Etcétera //-------------------------------------------------- //Eglefino. Elanio tijereta.  Elefante Marino del Sur Emú. Equidna. Erizo común. Escarabajo. Escorpión. Escribano de Brandt. Esmerejón.  Espanta Caimán. Espatula africana. Espátula Rosada. Esponja. Estercorario Parasítico. Estornino. Estrella de mar. Estrilda común. Esturión. //--------------------------------------------------------------
//Eclipse Ecología Economía Ecosistemas Ecosistemas terrestres  Ecuaciones Educación Ejercicios Elasticidad  Electricidad Electrodos Email Embalaje Embarazo Emergencias Emociones Empaque   Emprendedores Empresarios Empresas  Encimeras Encuestas Enemas Enfermería Enfoques  Ensayo Enseñanza  Entrenamiento Entrevista Envase  Epilepsia//Equilibrio Equipos  Equipos de trabajo  Erosión Errores Erupciones Escalas Escalas  musicales  Escáner  scenarios Esclavitud Escritura Escuelas  Esculturas Esfera Esguince Espacio Especies Espejos Esponjas Esquemas Esquizofrenia  Estadística Etiqueta //----------------------------------
//Edam Eggah Elote Embutido Empanada Empanadilla Enchilada Enchilado Endrina Ensalada Entomatada Entrecot Entremeses Erizo De Mar Escabeche Escaldón  Escalivada Escalope Escamol Escaramujo  Esgarrat Eskallus Espaguetti Espalda_De_Ternera Espárrago Espelón Espetada Espinazo Esquites Estofado Eusko Kutixi//---------------------------- //Egipto  Emiratos Árabes Unidos Eritrea Eslovenia Estados Unidos de América Etiopía //------------------------------------------------------------------ //Endrina  Escaramujo Escorlina//----------------------------------- Eastpak Ebarrito EDC by Esprit Eddie Bauer Edwin Eglo Eiffel Textile 
//Elbeo Elements Elie Tahari Elisabetta Franchi Elli El NaturalistaEmanuel Ungaro Emilio Pucci Emporio ArmaniEmsa Engelsrufer  Entre Amis Equipment Erika Cavallini Semi Couture Ermanno Scervino //Esprit Essix Home Collection  Etnies  Eurographics European Culture EVANS Excelsa Exclusive Home Curtains Eysa //----------------------- Enanitos Verdes Elton John Evanescence ////-------------------------------------------------------- Ecólogo Economista Educador Endocrinólogo Enólogo Entomólogo Epidemiólogo Espeleólogo Estadista Etimóloga  Etimólogo Etnógrafo Etnólogo  Etólogo 

 
        arrE = new ArrayList<Tupla>();
        arrE.add(new Tupla("Examinador", 0));arrE.add(new Tupla("Estadístico", 0));arrE.add(new Tupla("Especialista", 0));
        arrE.add(new Tupla("Enfermero", 0));arrE.add(new Tupla("Egiptólogo", 0));arrE.add(new Tupla("Enrique_iglesias", 0));
        arrE.add(new Tupla("Eyelevel", 0));arrE.add(new Tupla("Etro", 0));arrE.add(new Tupla("Essentiel", 0));
        arrE.add(new Tupla("Eminza", 0));arrE.add(new Tupla("Eleventy", 0));arrE.add(new Tupla("Ecco", 0));
        arrE.add(new Tupla("Escada", 0));arrE.add(new Tupla("Eterna", 0));arrE.add(new Tupla("Espinaca", 0));
        arrE.add(new Tupla("Espinacas", 0));arrE.add(new Tupla("Ejote", 0));arrE.add(new Tupla("El_Salvador", 0));
        arrE.add(new Tupla("Echalote", 0));arrE.add(new Tupla("Espinaca", 0));arrE.add(new Tupla("Enchufe", 0));
        arrE.add(new Tupla("Ejote", 0));arrE.add(new Tupla("Ensaladas", 0));arrE.add(new Tupla("Ecuador", 0));
        arrE.add(new Tupla("Empleo", 0));arrE.add(new Tupla("Esmeralda", 0));arrE.add(new Tupla("Estonia", 0));
        arrE.add(new Tupla("Emparedado", 0));arrE.add(new Tupla("Escarlata", 0));arrE.add(new Tupla("Escarola", 0));
        arrE.add(new Tupla("Enzimas", 0));arrE.add(new Tupla("Encaje_antiguo", 0));arrE.add(new Tupla("Endivia", 0));
        arrE.add(new Tupla("Ergonomía", 0));arrE.add(new Tupla("Ébano", 0));arrE.add(new Tupla("España", 0));
        arrE.add(new Tupla("Elegir", 0));arrE.add(new Tupla("Esparragás", 0));arrE.add(new Tupla("Edificio", 0));
        arrE.add(new Tupla("Ecuación", 0));arrE.add(new Tupla("Empanada", 0));arrE.add(new Tupla("Espárragos", 0));
        arrE.add(new Tupla("Escorpión", 0));arrE.add(new Tupla("Estrella", 0));arrE.add(new Tupla("Eslovaquia", 0));
        arrE.add(new Tupla("Ecología", 0));arrE.add(new Tupla("Escupiña", 0));arrE.add(new Tupla("Escaleras", 0));
        arrE.add(new Tupla("Elefante", 0));arrE.add(new Tupla("Elote", 0));

        
//Fachada Factorización Falacia Falda Falla Fauna Fecundación Felicidad Feminicidio Frutas Fuego Fuentes Fertilizante Fibras musculare Fichero Fiestas Filtración  Flexibilidad Flore Flujograma Frente Fricción Fronteras //Folklore  Formularios Fósiles Fotosíntesis Fracciones Fracturas Franquicias Frases Fraudes Frecuencia ////--------------------------------
//Faisán_vulgar.  Fajada_de_Matorral. Falaropo_picofino. Febo Festoneada Menor. Flamenco común. //Focha americana. Frailecillo atlántico.  Franciscana. Franja Ámbar. Frotadora Común. Fulmar boreal. Furtiva. Futarra. ////----------------------------------------------//Fresas Frutillas Fajitas Fabes Factura Fagot Falafél FardelejosFarinato Farinatta Fariña Felipe  Fernet Feta Fetuccini Fiambre Fideo Fideua Filet de paleta  Filet_mignon 
//Filete Filloa  Filo Financiero Fingers  Fior_di_latte Flamenquines Flamiche Flao Flor_de_guía Focaccia Fontina Fondue Formatjada Francesinha Frangollo Frittata Fuet Fumet Funche  Fusilli Flor de calabaza ////------------------------------//F.lli Campagnolo Fabiana Filippi Fackelmann Faith Connexion Falke Farah Faro Barcelona Fat Face FAUSTO PUGLISI Fay  Fenty Puma by Rihanna  Fila FILIPPO DE LAURENTIIS Fiorelli
//First People First Fisico FitFlop Fixdesign Fjällräven Fleuresse FLY London  Forte_Forte Fossil Frame_Company Frame_Denim Frankie_Morello Franklin_&_Marshall Fred_Mello Fred_Perry //Fred´s_World_By_Green_Cotton Free People Freeman_T._Porter French_Connection Fruit_Of_The_Loom Fynch_Hatton
////--------------------------------//Fiscal Forense Filólogo Foníatra Fonoaudiologo Fisiólogo Fotógrafo Facultativo Funcionario Farmacéutico              
        
        arrF = new ArrayList<Tupla>();
        arrF.add(new Tupla("Físico", 0));arrF.add(new Tupla("Fosco", 0));arrF.add(new Tupla("Fergie", 0));arrF.add(new Tupla("Frambuesa", 0));arrF.add(new Tupla("Feijoa", 0));arrF.add(new Tupla("Falda", 0));
        arrF.add(new Tupla("Fendi", 0));arrF.add(new Tupla("Fandango", 0));arrF.add(new Tupla("Fritos", 0));arrF.add(new Tupla("Feldgrau", 0));arrF.add(new Tupla("Fonólogo", 0));arrF.add(new Tupla("Frambuesa", 0));
        arrF.add(new Tupla("Filipinas", 0));arrF.add(new Tupla("Franco de Vita", 0));arrF.add(new Tupla("Fucsia", 0));arrF.add(new Tupla("Farruko", 0));arrF.add(new Tupla("Ferrari", 0));arrF.add(new Tupla("Flamma", 0));
        arrF.add(new Tupla("Filósofo", 0));arrF.add(new Tupla("Fabada", 0));arrF.add(new Tupla("Fresa", 0));arrF.add(new Tupla("Fabrica", 0));arrF.add(new Tupla("Fabula", 0));arrF.add(new Tupla("Fonetista", 0));
        arrF.add(new Tupla("Filtro", 0));arrF.add(new Tupla("Frutilla", 0));arrF.add(new Tupla("Fresquilla", 0));arrF.add(new Tupla("Fito Páez", 0));arrF.add(new Tupla("Fiyi", 0));arrF.add(new Tupla("Furla", 0));
        arrF.add(new Tupla("Faneca", 0));arrF.add(new Tupla("Fanny Lú", 0));arrF.add(new Tupla("Foca", 0));arrF.add(new Tupla("Francia", 0));arrF.add(new Tupla("Fantasma", 0));arrF.add(new Tupla("Finlandia", 0));
        arrF.add(new Tupla("Factura", 0));arrF.add(new Tupla("Farmacólogo", 0));arrF.add(new Tupla("Farmacia", 0));arrF.add(new Tupla("Frutipan", 0));arrF.add(new Tupla("Feminismo", 0));arrF.add(new Tupla("Flan", 0));
        arrF.add(new Tupla("Frijoles", 0));arrF.add(new Tupla("Familia", 0));arrF.add(new Tupla("Fideicomiso", 0));arrF.add(new Tupla("Fornarina", 0));arrF.add(new Tupla("Fenogreco", 0));arrF.add(new Tupla("Fermentación", 0));arrF.add(new Tupla("Fobia", 0));arrF.add(new Tupla("Fisioterapeuta", 0));

        map.put("A", arrA);
        map.put("B", arrB);
        map.put("C", arrC);
        map.put("D", arrD);
        map.put("E", arrE);
        map.put("F", arrF);

    }

}
