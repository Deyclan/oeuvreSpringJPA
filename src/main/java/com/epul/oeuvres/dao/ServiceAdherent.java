package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.AdherentEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceAdherent extends EntityService {

    public void insertAdherent(AdherentEntity adherent) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.persist(adherent);
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<AdherentEntity> getListAdherent(){
        List<AdherentEntity> adherentEntityList = null;
        try{
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            adherentEntityList = (List<AdherentEntity>) entityManager.createQuery("select a from AdherentEntity a order by a.nomAdherent").getResultList();
            entityManager.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return adherentEntityList;
    }

    public AdherentEntity getAdherentById(int id){
        AdherentEntity adherent = null;
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();

            adherent = (AdherentEntity) entityManager.createQuery("select a from AdherentEntity a where a.idAdherent ="+id).getResultList().get(0);
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return adherent;
    }

}
