package co.jg.vlab.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.jg.vlab.model.entity.Labcase;

@Stateless
public class LabcaseService {

    @PersistenceContext(unitName = "vlabDS")
    private EntityManager em;

    public List<Labcase> getLabcases() {
        return (List<Labcase>) em.createQuery("from Labcase").getResultList();
    }

    public Labcase getLabcase(Integer idLabcase) {
        return em.find(Labcase.class, idLabcase);
    }

    public void persistLabcase(Labcase labcase) {
        em.persist(labcase);
    }

    public void removeLabcase(Integer id) {
        em.remove(em.find(Labcase.class, id));
    }

    public Labcase updateLabcase(Labcase labcase) {
        return em.merge(labcase);
    }

    public List<Labcase> getLabcaseByCode(String code) {
        return em.createNamedQuery("Labcase.findByCode").setParameter("code", code).getResultList();
    }

}
