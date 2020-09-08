package raja.be.Repository;


import raja.be.Model.Module;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ModuleData {
    EmWorker emw = new EmWorker();
    EntityManager em = emw.createem();


    public void deleteModule(long id) {

        Module module = em.find(Module.class, id);
        if (module != null) {
            em.getTransaction().begin();
            em.remove(module);
            em.getTransaction().commit();
            System.out.println(module + "  this module details been removed");
            em.close();
            emw.getEmf().close();
        }

    }

    public void updateModule(long id, String name, String description) {
        Module module = em.find(Module.class, id);

        em.getTransaction().begin();
        module.setName(name);
        module.setDescription(description);
        em.merge(module);
        em.getTransaction().commit();
        em.close();
        emw.getEmf().close();

    }

    public void retrieveModule(long id) {
        Module module = em.find(Module.class, id);
        if (module != null) {
            System.out.println(module.toString());
            em.close();
            emw.getEmf().close();

        }
    }

    public List<Module> findAllModules() {
        TypedQuery<Module> query = em.createQuery("SELECT m FROM Module m", Module.class);
        return query.getResultList();


    }
}

