package com.epul.oeuvres.controle;

//import com.epul.oeuvres.dao.ServiceConnexion;
import com.epul.oeuvres.dao.ServiceAdherent;
import com.epul.oeuvres.metier.AdherentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdherentControleur {

    @RequestMapping(value = "listerAdherent")
    public ModelAndView listerAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            ServiceAdherent serviceAdherent = new ServiceAdherent();
            request.setAttribute("mesAdherents", serviceAdherent.getListAdherent());
            destinationPage = "listerAdherent";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "insererAdherent")
    public ModelAndView insererAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage;
        try {
            AdherentEntity adherent = new AdherentEntity();
            adherent.setNomAdherent(request.getParameter("txtnom"));
            adherent.setPrenomAdherent(request.getParameter("txtprenom"));
            adherent.setVilleAdherent(request.getParameter("txtville"));
            ServiceAdherent serviceAdherent = new ServiceAdherent();
            serviceAdherent.insertAdherent(adherent);
            request.setAttribute("mesAdherents", serviceAdherent.getListAdherent());
            destinationPage = "listerAdherent";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "ajouterAdherent")
    public ModelAndView ajouterAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            destinationPage = "ajouterAdherent";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "modifierAdherent")
    public ModelAndView modifyAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            ServiceAdherent serviceAdherent = new ServiceAdherent();
            AdherentEntity adherent = serviceAdherent.getAdherentById(Integer.parseInt(request.getParameter("modifier")));
            request.setAttribute("adherentAModifier", adherent);
            destinationPage = "modifierAdherent";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "sauvegarderAdherent")
    public ModelAndView sauvegarderAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            ServiceAdherent serviceAdherent = new ServiceAdherent();
            AdherentEntity adherent = serviceAdherent.getAdherentById(Integer.parseInt(request.getParameter("txtid")));
            adherent.setNomAdherent(request.getParameter("txtnom"));
            adherent.setPrenomAdherent(request.getParameter("txtprenom"));
            adherent.setVilleAdherent(request.getParameter("txtville"));
            serviceAdherent.updateAdherent(adherent);
            request.setAttribute("mesAdherents", serviceAdherent.getListAdherent());
            destinationPage = "listerAdherent";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "supprimerAdherent")
    public ModelAndView supprimerAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try{
            ServiceAdherent serviceAdherent = new ServiceAdherent();
            AdherentEntity adherent = serviceAdherent.getAdherentById(Integer.parseInt(request.getParameter("supprimer")));
            serviceAdherent.deleteAdherent(adherent);
            request.setAttribute("mesAdherents", serviceAdherent.getListAdherent());
            destinationPage = "listerAdherent";
        }
        catch (Exception e){
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

}
