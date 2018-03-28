package com.epul.oeuvres.controle;

//import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epul.oeuvres.dao.ServiceAdherent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
//import com.epul.metier.*;
//import com.epul.meserreurs.*;



import com.epul.oeuvres.dao.*;
import com.epul.oeuvres.meserreurs.*;
import com.epul.oeuvres.metier.*;







import org.springframework.ui.Model;



import java.util.*;

///
/// Les m�thode du contr�leur r�pondent � des sollicitations
/// des pages JSP

@Controller
public class MultiControleur {

//	private static final Logger logger = LoggerFactory.getLogger(MultiControleur.class);

	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("index");
	}

	// /
    // / Affichage de la page d'accueil
    // /
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("index");
    }

    // /
    // / Affichage de la page d'accueil
    // /
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView Afficheindex3(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("index");
    }

    // /
    // / Affichage de la page d'accueil oeuvre suite à une connexion
    // /
    @RequestMapping(value = "seConnecter", method = RequestMethod.POST)
    public ModelAndView connexion(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Boolean canConnect = false;
        String destinationPage;
        try {
            // TODO : session start?
            Service unService = new Service();
            canConnect = unService.seConnecter(request.getParameter("username"), request.getParameter("password"));
            destinationPage = canConnect ? "accueil" : "seConnecter";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
	    return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "seDeconnecter", method = RequestMethod.POST)
    public ModelAndView deconnexion(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO : session quit?
	    return new ModelAndView("index");
    }

    // /
    // / Affichage de la page d'accueil oeuvre
    // /
    @RequestMapping(value = "accueil", method = RequestMethod.GET)
    public ModelAndView accueil(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("accueil");
    }

	// /
	// / Affichage de la page d'erreur
	// /
	@RequestMapping(value = "erreur", method = RequestMethod.GET)
	public ModelAndView AfficheErreur(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("Erreur");
	}
	

}
