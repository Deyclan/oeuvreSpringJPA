package com.epul.oeuvres.controle;

import com.epul.oeuvres.dao.ServiceConnexion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            ServiceConnexion unService = new ServiceConnexion();
            canConnect = unService.seConnecter(request.getParameter("username"), request.getParameter("password"));
            destinationPage = canConnect ? "accueil" : "seConnecter";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "seDeconnecter", method = RequestMethod.GET)
    public ModelAndView deconnexion(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
