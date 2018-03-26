package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.OeuvreventeEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceOeuvreVente extends EntityService {

    public void insertOeuvreVente(OeuvreventeEntity oeuvrepret) {
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

    public void updateOeuvre(OeuvreventeEntity uneOeuvre) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            // TODO update method ? (like persist for insert)
            entityManager.createQuery("UPDATE OeuvreventeEntity o" +
                    " SET o.titreOeuvrevente='"+uneOeuvre.getTitreOeuvrevente()+"', o.prixOeuvrevente='"+uneOeuvre.getPrixOeuvrevente()+"', o.proprietaire="+uneOeuvre.getProprietaire()+
                    " WHERE idOeuvrevente="+uneOeuvre.getIdOeuvrevente());
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OeuvreventeEntity> getListOeuvreVente(){
        List<OeuvreventeEntity> OeuvreVenteList = null;
        try{
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            OeuvreVenteList = (List<OeuvreventeEntity>) entityManager.createQuery("select o from OeuvreventeEntity o order by o.titreOeuvrevente").getResultList();
            entityManager.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return OeuvreVenteList;
    }

    public OeuvreventeEntity getOeuvreVenteByIdOeuvre(int id){
        OeuvreventeEntity oeuvre = null;
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            oeuvre = (OeuvreventeEntity) entityManager.createQuery("select o from OeuvreventeEntity o where o.idOeuvrevente = "+id).getResultList().get(0);
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return oeuvre;
    }

    public void changeEtatOeuvreVente(int idOeuvre) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            // TODO update method ? (like persist for insert)
            entityManager.createQuery("UPDATE OeuvreventeEntity o" +
                    " SET o.etatOeuvrevente='R'"+
                    " WHERE idOeuvrevente="+idOeuvre);
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}