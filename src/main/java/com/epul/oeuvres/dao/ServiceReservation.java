package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.ReservationEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceReservation extends EntityService {

    public void insertReservation(ReservationEntity reservation) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.persist(reservation);
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<ReservationEntity> getListReservation(){
        List<ReservationEntity> reservationList = null;
        try{
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            reservationList = (List<ReservationEntity>) entityManager.createQuery("select r from ReservationEntity r order by r.dateReservation").getResultList();
            entityManager.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return reservationList;
    }

    public ReservationEntity getReservationById(int id){
        ReservationEntity reservation = null;
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            reservation = (ReservationEntity) entityManager.createQuery("select r from ReservationEntity r where r.idOeuvrevente="+id).getResultList().get(0);
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return reservation;
    }

    public void confirmerReservation(ReservationEntity uneReservation) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            // TODO update method ? (like persist for insert)
            entityManager.createQuery("UPDATE ReservationEntity" +
                    " SET statut='confirmee'"+
                    " WHERE idOeuvrevente="+uneReservation.getIdOeuvrevente());
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteReservation(ReservationEntity reservation) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            // TODO delete method ? (like persist for insert)
            entityManager.createQuery("DELETE FROM ReservationEntity r WHERE r.idOeuvrevente="+ reservation.getIdOeuvrevente()+" AND r.idAdherent="+ reservation.getIdAdherent());
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
