/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.persistence;

import GeneratorPassword.GeneratorPassword.model.Contrasena;
import GeneratorPassword.GeneratorPassword.services.PasswordException;
//import com.mongodb.BasicDBObject;
//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.DBCursor;
//import com.mongodb.DBObject;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoCursor;
//import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
//import org.bson.Document;
import org.springframework.stereotype.Service;

/**
 *
 * @author DicoAdmin
 */
@Service
public class MongoDB {

//    private MongoClientURI uri = new MongoClientURI("mongodb+srv://cartm:decena9Ajustar8Dalí2@cluster0.gwdk1.mongodb.net/DB_Contrasenas?retryWrites=true&w=majority");
//
//    /**
//     * Esta funcion retorna True o False si encuentra un hash igual.
//     * @param hash  String que se pasa por parametro.
//     * @return  respesuta   Valor booleano que representa si fue encontrado o no el hash en la base de datos.
//     * @throws PasswordException 
//     */
//    public boolean isHereOrNot(String hash) throws PasswordException {
//        boolean respuesta = false;
//        MongoClient client = new MongoClient(uri);        
//        DB db = client.getDB(uri.getDatabase());
//        DBCollection collection =  db.getCollection("Contrasenas");        
//        DBObject query = new BasicDBObject("Contrasenas", new BasicDBObject("$regex", hash));
//        DBCursor cursor = collection.find(query);        
//        try {
//            if (cursor.hasNext()) {
//                respuesta=true;    
//            }
//        }catch (Exception ex){
//            throw new PasswordException("Excepcion MongoBD Consulta : "+ex.getMessage());               
//        }finally {
//            cursor.close();
//        }
//        return respuesta;
//    }
//
//    public void findAndPrintData()throws PasswordException  {
//        try{
//        MongoClient client = new MongoClient(uri);
//        MongoDatabase db = client.getDatabase(uri.getDatabase());
//        MongoCollection<Document> coll = db.getCollection("Contrasenas");
//        BasicDBObject dbo = new BasicDBObject();
//        FindIterable<Document> res = coll.find(dbo);
//        MongoCursor<Document> docit = res.iterator();
//        while (docit.hasNext()) {
//            Document doc = docit.next();
//            System.out.println("miremos : " + (String) doc.get("Contrasenas"));
//            String g = (String) doc.get("ContrasenaS");
//            if (g.equals("4a7b98d24d5a3b17017d765680b88aa6")) {
//                System.out.println("si es igual");
//            }
//        }
//        client.close();
//        }catch (Exception ex){
//            throw new PasswordException("Excepcion MongoBD Consulta : "+ex.getMessage());               
//        }
//    }
//
//    public void insertData(String contrasena) throws PasswordException {
//        try{
//        MongoClient client = new MongoClient(uri);
//        MongoDatabase db = client.getDatabase(uri.getDatabase());
//        MongoCollection<Document> coll = db.getCollection("Contrasenas");
//        Document master = Document.parse("{contrasena:'" + contrasena + "'}");
//        coll.insertOne(master);
//        client.close();
//        }catch (Exception ex){
//            throw new PasswordException("Excepcion Insersion datos MongoBD : "+ex.getMessage());               
//        }     
//    }

}
