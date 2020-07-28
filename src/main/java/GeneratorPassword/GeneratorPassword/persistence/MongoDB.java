/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorPassword.GeneratorPassword.persistence;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Service;

/**
 *
 * @author DicoAdmin
 */
@Service
public class MongoDB {

    private MongoClientURI uri = new MongoClientURI("mongodb://passgenerator:Examinador4butaca5Afirmar1@ds239692.mlab.com:39692/generatorpassword?retryWrites=false");

    public void insertData(String contrasena) {
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        MongoCollection<Document> coll = db.getCollection("contrasenah");
        Document master = Document.parse("{contrasena:'" + contrasena + "'}");
        coll.insertOne(master);
        client.close();
    }

}
