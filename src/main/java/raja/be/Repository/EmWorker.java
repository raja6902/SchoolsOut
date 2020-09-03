package raja.be.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmWorker {
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("datasource");

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager createem() {

        EntityManager em = emf.createEntityManager();

        return em;
    }



}
