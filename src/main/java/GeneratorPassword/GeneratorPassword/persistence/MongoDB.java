/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.persistence;

import GeneratorPassword.GeneratorPassword.model.Contrasena;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.springframework.stereotype.Service;

/**
 *
 * @author DicoAdmin
 */
@Service
public class MongoDB {

    private MongoClientURI uri = new MongoClientURI("mongodb://passgenerator:Examinador4butaca5Afirmar1@ds239692.mlab.com:39692/generatorpassword?retryWrites=false");

    public boolean isHereOrNot(String hash) {
        boolean respuesta = false;
        MongoClient client = new MongoClient(uri);
        //MongoDatabase db = client.getDatabase(uri.getDatabase());
        DB db = client.getDB(uri.getDatabase());
        DBCollection collection =  db.getCollection("contrasenah");
        DBObject query = new BasicDBObject("contrasena", new BasicDBObject("$regex", hash));
        DBCursor cursor = collection.find(query);        
        try {
            if (cursor.hasNext()) {
                respuesta=true;    
                System.out.println("PUTA :"+ cursor.next().get("contrasena"));                
            }
        } finally {
            cursor.close();
        }        
        return respuesta;
    }

    public void findAndPrintData() {
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        MongoCollection<Document> coll = db.getCollection("contrasenah");
        BasicDBObject dbo = new BasicDBObject();
        FindIterable<Document> res = coll.find(dbo);
        MongoCursor<Document> docit = res.iterator();
        while (docit.hasNext()) {
            Document doc = docit.next();
            //contrasenasHash.add(new Contras();
            System.out.println("miremos : " + (String) doc.get("contrasena"));
            String g = (String) doc.get("contrasena");
            if (g.equals("4a7b98d24d5a3b17017d765680b88aa6")) {
                System.out.println("si es igual");
            }
        }
        client.close();
    }

    public void insertData(String contrasena) {
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        MongoCollection<Document> coll = db.getCollection("contrasenah");
        Document master = Document.parse("{contrasena:'" + contrasena + "'}");
        coll.insertOne(master);
        client.close();
    }

}
