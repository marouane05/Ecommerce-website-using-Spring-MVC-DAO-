package com.dryouch.account.controller;

import com.dryouch.account.dao.ArticleDAO;
import com.dryouch.account.dao.ArticleDAOImpl;
import com.dryouch.account.dao.CommandeDAO;
import com.dryouch.account.dao.CommandeDAOImpl;
import com.dryouch.account.dao.SecurityService;
import com.dryouch.account.dao.UserService;
import com.dryouch.account.model.Articles;
import com.dryouch.account.model.Commande;
import com.dryouch.account.model.User;
import com.dryouch.account.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;
   

    @Autowired
    private UserValidator userValidator;
@Autowired 
private ArticleDAO  articleDAO ;
@Autowired 
private CommandeDAO commandeDAO ;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Votre nom d'utilisateur et votre mot de passe ne sont pas valides.");

        if (logout != null)
            model.addAttribute("message", "Vous avez été déconnecté avec succès.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {

    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if( authentication.getAuthorities().stream()
  	          .anyMatch(r -> r.getAuthority().equals("ROLE_USER"))) {
    	return "welcome";
    }
    	
        return "adminwelcome";
    }
    
    @RequestMapping(value="/voirarticles")
    public ModelAndView listArticles (ModelAndView model) throws IOException{
    	List <Articles> list = articleDAO.getArticles() ;
    	model.addObject("list",list);
    	model.setViewName("articles");

		return model;
    	
    }
    
    @RequestMapping(value="/detailCatalogue", method = RequestMethod.GET)
    public ModelAndView detailArticles (@RequestParam("ref") Long ref,ModelAndView model) throws IOException{
    	 
    	model.addObject("article",articleDAO.DetailCatalogue(ref));
    	model.setViewName("articlesdetails");

		return model;
    	
    }
    
    @RequestMapping(value="/commander", method = RequestMethod.GET)
    public ModelAndView AjouterCommande (@RequestParam("ref") Long ref,@RequestParam("name") String name,@RequestParam("prix") int prix,ModelAndView model) throws IOException{
    	 
    	articleDAO.Commander(ref, name,prix);
    	model.setViewName("articles");

		return model;
    	
    }
    
    
    @RequestMapping(value="/commander/valider", method = RequestMethod.GET)
    public ModelAndView ValiderCommande (@RequestParam("id") int id,@RequestParam("name") String name,ModelAndView model) throws IOException{
    	 
    	articleDAO.ValiderCommande(id);
    	List <Commande> list = commandeDAO.getPanier(name) ;
        
        /*	List <Commande> list = new ArrayList<Commande>();
        	list.add(commandeDAO.getPanier(name));
        	*/
        	model.addObject("list",list);
        	model.setViewName("panier");
           

		return model;
    	
    }
    
    
    
    
    @RequestMapping(value="/voirpanier", method = RequestMethod.GET)
    public ModelAndView panier (@RequestParam("name") String name,ModelAndView model) throws IOException{
    	List <Commande> list = commandeDAO.getPanier(name) ;
    
    /*	List <Commande> list = new ArrayList<Commande>();
    	list.add(commandeDAO.getPanier(name));
    	*/
    	model.addObject("list",list);
    	model.setViewName("panier");
       
		return model;
    	
    }
    
    @RequestMapping(value="/voirarticlesbycategory", method = RequestMethod.GET)
    public ModelAndView listArticlesByCategory (@RequestParam("cat") String cat,ModelAndView model) throws IOException{
    	List <Articles> list = articleDAO.getArticlesByCategory(cat) ;
    	model.addObject("list",list);
    	model.setViewName("articles");

		return model;
    	
    }
    
    @RequestMapping(value = "/valider", method = RequestMethod.GET)
    public ModelAndView valider(@RequestParam("name") String name,ModelAndView model) throws IOException {
    	List <Commande> list = commandeDAO.ticket(name) ;
        
        /*	List <Commande> list = new ArrayList<Commande>();
        	list.add(commandeDAO.getPanier(name));
        	*/
    	int prix_totale=0 ;
    	for(int i=0 ; i< list.size() ; i++) {
    		
    		prix_totale += list.get(i).getPrix() ;
    	}
    	
       for(int i=0 ; i< list.size() ; i++) {
    		
    	list.get(i).setPrix(prix_totale);
    	 }
    	
        model.addObject("list",list);
    	model.setViewName("validation");

		return model;
    }
    
    
    @RequestMapping(value = "/valider/terminer", method = RequestMethod.GET)
    public ModelAndView terminer(@RequestParam("name") String name,ModelAndView model) throws IOException {
    	 commandeDAO.ViderPanier(name);
        
    	model.setViewName("welcome");

		return model;
    }
    
    
    @RequestMapping(value = { "/ajout"}, method = RequestMethod.GET)
    public String AjoutProduit(Model model) {
        return "ajoutproduit";
    }
    
    @RequestMapping(value = { "/ajoutprod"}, method = RequestMethod.GET)
    public String AjoutProduitEffectuer(@RequestParam("designation") String designation,@RequestParam("prix") String prix,@RequestParam("stock") String stock,@RequestParam("categorie") String categorie,@RequestParam("image") String image,ModelAndView model) throws SerialException, SQLException {
    	
    	Articles article = new Articles();
    	article.setCategorie(categorie);
    	article.setDesignation(designation);
    	article.setPrix(Integer.parseInt(prix));
    	article.setStock(stock);
    	
    	byte[] byteData = image.getBytes();//Better to specify encoding
    
    	articleDAO.AjoutArticle(article,byteData);
    	
    	 return "ajoutproduit";

		//return "ajoutproduit";
    }
    
    
    
    @RequestMapping(value = { "/produit/supprimer"}, method = RequestMethod.GET)
    public ModelAndView SuppressionProduitRedirection(ModelAndView model) {
    	List <Articles> list = articleDAO.getArticles() ;
    	model.addObject("list",list);
    	model.setViewName("supprimerproduit");

        return model;
    }
    
    
    @RequestMapping(value = { "/produit/supprimer/bycat"}, method = RequestMethod.GET)
    public String SupprimerProduit(@RequestParam("ref") String ref,ModelAndView model)  {
    	
    	
    	articleDAO.SupprimerProduit(ref);
    	
    	 return "supprimerproduit";

		//return "ajoutproduit";
    }
    
}
