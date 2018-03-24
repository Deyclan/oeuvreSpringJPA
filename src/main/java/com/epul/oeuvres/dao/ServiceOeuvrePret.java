package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.OeuvrepretEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceOeuvrePret extends EntityService {

    public void insertOeuvrePret(OeuvrepretEntity oeuvrepret) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.persist(oeuvrepret);
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<OeuvrepretEntity> getListOeuvrePret(){
        List<OeuvrepretEntity> OeuvrePretList = null;
        try{
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            OeuvrePretList = (List<OeuvrepretEntity>) entityManager.createQuery("select o from OeuvrepretEntity o order by o.titreOeuvrepret").getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return OeuvrePretList;
    }

    public OeuvrepretEntity getOeuvrePretByIdOeuvre(int id){
        OeuvrepretEntity oeuvre = null;
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            oeuvre = (OeuvrepretEntity) entityManager.createQuery("select * from OeuvrepretEntity where idOeuvrepret = "+id).getResultList().get(0);
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return oeuvre;
    }

}
