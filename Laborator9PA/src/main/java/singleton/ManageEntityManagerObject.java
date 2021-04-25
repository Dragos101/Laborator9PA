package singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManageEntityManagerObject {

    private static EntityManagerFactory factory = null;

    public static EntityManagerFactory getFactory(){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory("default");
        return factory;
    }

}
