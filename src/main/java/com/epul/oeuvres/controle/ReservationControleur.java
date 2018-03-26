package com.epul.oeuvres.controle;

import com.epul.oeuvres.dao.ServiceProprietaire;
import com.epul.oeuvres.dao.ServiceReservation;
import com.epul.oeuvres.metier.OeuvreventeEntity;
import com.epul.oeuvres.metier.ReservationEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

@Controller
public class ReservationControleur {

    @RequestMapping( value = "ajouterReservation")
    public ModelAndView ajouterReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            ServiceProprietaire unService = new ServiceProprietaire();
            request.setAttribute("proprietaires", unService.getListProprietaire());
            destinationPage = "ajouterReservation";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( value = "insererReservation")
    public ModelAndView insererReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try{
            ReservationEntity uneR = new ReservationEntity();
            uneR.setIdOeuvrevente(Integer.parseInt(request.getParameter("txtIDOeuvre")));
            // TODO set adherent selon session
            uneR.setIdAdherent(1);
            uneR.setDateReservation(Date.valueOf(request.getParameter("txtdate")));
            uneR.setStatut("attente");
            ServiceReservation unS = new ServiceReservation();
            unS.insertReservation(uneR);
            destinationPage = "listerOeuvre";
        } catch (Exception e){
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( value = "gererReservations")
    public ModelAndView gererReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            ServiceReservation unService = new ServiceReservation();
            request.setAttribute("mesReservations", unService.getListReservation());
            destinationPage = "listerReservation";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( value = "confirmerReservation")
    public ModelAndView confirmerReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try{
            ServiceReservation unS = new ServiceReservation();
            ReservationEntity uneR = unS.getReservationById(Integer.parseInt(request.getParameter("confirmer")));
            unS.confirmerReservation(uneR);
            destinationPage = "listerReservation";
        } catch (Exception e){
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( value = "annulerReservation")
    public ModelAndView annulerReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try{
            ServiceReservation unS = new ServiceReservation();
            ReservationEntity uneR = unS.getReservationById(Integer.parseInt(request.getParameter("annuler")));
            unS.deleteReservation(uneR);
            destinationPage = "listerReservation";
        } catch (Exception e){
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

}
