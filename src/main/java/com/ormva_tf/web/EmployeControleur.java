package com.ormva_tf.web;

import java.io.File;
import java.io.FileInputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.ormva_tf.dao.TypeRepository;
import com.ormva_tf.dao.CompteRepository;
import com.ormva_tf.dao.CongeRepository;
import com.ormva_tf.dao.DiplomeRepository;
import com.ormva_tf.dao.EmplDiplomeRepository;
import com.ormva_tf.dao.EmplFonctionRepository;
import com.ormva_tf.dao.EmployeRepository;
import com.ormva_tf.dao.EntiteRepository;
import com.ormva_tf.dao.FiliereRepository;
import com.ormva_tf.dao.FonctionRepository;
import com.ormva_tf.dao.RoleRepository;
import com.ormva_tf.dao.TypeCongeRepository;
import com.ormva_tf.entities.Conge;
import com.ormva_tf.entities.Diplome;
import com.ormva_tf.entities.EmplDiplome;
import com.ormva_tf.entities.EmplFonction;
import com.ormva_tf.entities.Employe;
import com.ormva_tf.entities.Entite;
import com.ormva_tf.entities.Filiere;
import com.ormva_tf.entities.Fonction;
import com.ormva_tf.entities.Type;
import com.ormva_tf.entities.TypeConge;
import com.ormva_tf.sec.Compte;
import com.ormva_tf.sec.CustomUserDetails;

@Controller
public class EmployeControleur {
	@Autowired 
	private TypeRepository typeRepository ;
	@Autowired 
	private FiliereRepository filiereRepository ;
	@Autowired
	private EmployeRepository employeRepository ;
	@Autowired
	private EntiteRepository entiteRepository ;
	@Autowired
	private DiplomeRepository diplomeRepository ;
	@Autowired
	private FonctionRepository fonctionRepository ;
	@Autowired
	private EmplFonctionRepository emlpFoncRepository ;
	@Autowired
	private TypeCongeRepository typeCongeRepository ;
	@Autowired
	private EmplDiplomeRepository emlpDiplmRepository ;
	@Autowired
	private CongeRepository congeRepository ;
	@Autowired
	private RoleRepository roleRepository ;
	@Autowired
	private CompteRepository compteRepository ;
	@Value("${dir.images}")
	private String imageDir ;
	///////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/Index")
	public String index(ModelMap model , Principal principal){
		 String cin = principal.getName();
	       Employe employe = employeRepository.getById(cin) ;
	        model.addAttribute("employe", employe);
		
		return "indexa" ;
	}
	
	@RequestMapping(value="/")
	public String home() {
		return "redirect:/Index " ;
	}
	@RequestMapping(value="/user")
	public String homeuser() {
		return "redirect:/user/user" ;
	}
		
	@RequestMapping(value="/employe")
	public String employe(Model model ,  @RequestParam(name="page" , defaultValue="0")int page ,@RequestParam(name="motCle" , defaultValue="") String mc) {
		Page<Employe> pageEmploye = employeRepository.chercherEmploye("%"+mc+"%", PageRequest.of(page,4));
		int pagesCount =pageEmploye.getTotalPages() ;
		int[] pages= new int[pagesCount] ;
		for(int i=0 ; i < pagesCount ; i++) pages [i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("pageEmploye", pageEmploye);
		model.addAttribute("pageCourante", page);
		model.addAttribute("motCle", mc);
		return "employee" ;
		
	}
	@RequestMapping(value="/type")
	public String type(Model model ,  @RequestParam(name="page" , defaultValue="0")int page,@RequestParam(name="motCle" , defaultValue="") String mc) {
		Page<Type> listType = typeRepository.chercherType("%"+mc+"%", PageRequest.of(page,6));
		int pagesCount =listType.getTotalPages() ;
		int[] pages= new int[pagesCount] ;
		for(int i=0 ; i < pagesCount ; i++) pages [i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("listType", listType);
		model.addAttribute("pageCourante", page);
		model.addAttribute("motCle", mc);
		return "typeEntite" ;
	}
	@RequestMapping(value="/typeConge")
	public String type(Model model ,  @RequestParam(name="page" , defaultValue="0")int page) {
		Page<TypeConge> listTypeConge = typeCongeRepository.findAll(PageRequest.of(page,6));
		int pagesCount =listTypeConge.getTotalPages() ;
		int[] pages= new int[pagesCount] ;
		for(int i=0 ; i < pagesCount ; i++) pages [i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("listTypeConge", listTypeConge);
		model.addAttribute("pageCourante", page);
		return "typeConge" ;
	}
	@RequestMapping(value="/filiere")
	public String filiere(Model model ,  @RequestParam(name="page" , defaultValue="0")int page,@RequestParam(name="motCle" , defaultValue="") String mc) {
		Page<Filiere> listFiliere = filiereRepository.chercherFiliere("%"+mc+"%", PageRequest.of(page,6));
		int pagesCount =listFiliere.getTotalPages() ;
		int[] pages= new int[pagesCount] ;
		for(int i=0 ; i < pagesCount ; i++) pages [i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("listFiliere", listFiliere);
		model.addAttribute("pageCourante", page);
		model.addAttribute("motCle", mc);
		return "filiere" ;
	}
	@RequestMapping(value="/fonction")
	public String fonction(Model model ,  @RequestParam(name="page" , defaultValue="0")int page,@RequestParam(name="motCle" , defaultValue="") String mc) {
		Page<Fonction> listFonction = fonctionRepository.chercherFonction("%"+mc+"%", PageRequest.of(page,6));
		int pagesCount =listFonction.getTotalPages() ;
		int[] pages= new int[pagesCount] ;
		for(int i=0 ; i < pagesCount ; i++) pages [i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("listFonction", listFonction);
		model.addAttribute("pageCourante", page);
		model.addAttribute("motCle", mc);
		return "fonction" ;
	}
	@RequestMapping(value="/EmplFonct")
	public String emlpFonct(Model model ,  @RequestParam(name="page" , defaultValue="0")int page,@RequestParam(name="motCle" , defaultValue="") String mc) {
		Page<EmplFonction> listEmplFonc = emlpFoncRepository.chercherEmplFonct("%"+mc+"%", PageRequest.of(page,6));
		int pagesCount =listEmplFonc.getTotalPages() ;
		int[] pages= new int[pagesCount] ;
		for(int i=0 ; i < pagesCount ; i++) pages [i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("listEmplFonc", listEmplFonc);
		model.addAttribute("pageCourante", page);
		model.addAttribute("motCle", mc);
		return "EmpFonct" ;
	}
	@RequestMapping(value="/EmplDiplm")
	public String emlpDiplm(Model model ,  @RequestParam(name="page" , defaultValue="0")int page,@RequestParam(name="motCle" , defaultValue="") String mc) {
		Page<EmplDiplome> listEmplDiplm = emlpDiplmRepository.chercherEmplDiplm("%"+mc+"%", PageRequest.of(page,6));
		int pagesCount =listEmplDiplm.getTotalPages() ;
		int[] pages= new int[pagesCount] ;
		for(int i=0 ; i < pagesCount ; i++) pages [i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("listEmplDiplm", listEmplDiplm);
		model.addAttribute("pageCourante", page);
		model.addAttribute("motCle", mc);
		return "EmpDiplm" ;
	}
	@RequestMapping(value="/entite")
	public String entite(Model model ,  @RequestParam(name="page" , defaultValue="0")int page,@RequestParam(name="motCle" , defaultValue="") String mc) {
		Page<Entite> listEntite = entiteRepository.chercherEntite("%"+mc+"%", PageRequest.of(page,6));
		int pagesCount =listEntite.getTotalPages() ;
		int[] pages= new int[pagesCount] ;
		for(int i=0 ; i < pagesCount ; i++) pages [i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("listEntite", listEntite);
		model.addAttribute("pageCourante", page);
		model.addAttribute("motCle", mc);
		return "entite" ;
}
	@RequestMapping(value="/diplome")
	public String diplome(Model model ,  @RequestParam(name="page" , defaultValue="0")int page,@RequestParam(name="motCle" , defaultValue="") String mc) {
		Page<Diplome> listDiplome = diplomeRepository.chercherDiplome("%"+mc+"%", PageRequest.of(page,6));
		int pagesCount =listDiplome.getTotalPages() ;
		int[] pages= new int[pagesCount] ;
		for(int i=0 ; i < pagesCount ; i++) pages [i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("listDiplome", listDiplome);
		model.addAttribute("pageCourante", page);
		model.addAttribute("motCle", mc);
		return "diplome" ;
}
	@RequestMapping(value="/conge")
	public String conge(Model model ,  @RequestParam(name="page" , defaultValue="0")int page,@RequestParam(name="motCle" , defaultValue="") String mc) {
		Page<Conge> listConge = congeRepository.chercherConge("%"+mc+"%", PageRequest.of(page,6));
		int pagesCount =listConge.getTotalPages() ;
		int[] pages= new int[pagesCount] ;
		for(int i=0 ; i < pagesCount ; i++) pages [i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("listConge", listConge);
		model.addAttribute("pageCourante", page);
		model.addAttribute("motCle", mc);
		return "conge" ;
}
	@RequestMapping(value="/user/etatDemande")
	public String etatDemande( @RequestParam(name="page" , defaultValue="0")int page ,ModelMap model , Principal principal){
		 String cin = principal.getName();
	       Employe employe = employeRepository.getById(cin) ;
	        model.addAttribute("employe", employe);
		Page<Conge> listConge = congeRepository.findAll(PageRequest.of(page,6));
		int pagesCount =listConge.getTotalPages() ;
		int[] pages= new int[pagesCount] ;
		for(int i=0 ; i < pagesCount ; i++) pages [i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("listConge", listConge);
		model.addAttribute("pageCourante", page);
		return "etatDemande" ;
}
	@RequestMapping(value="/accepter")
	public String accepter(Model model ,  @RequestParam(name="id" )Long id) {
		congeRepository.StatusAccepter(id);
		return "redirect:/conge" ;
}
	@RequestMapping(value="/refuser")
	public String refuser(Model model ,  @RequestParam(name="id" )Long id) {
		congeRepository.StatusRefuser(id);
		return "redirect:/conge" ;
}
	@RequestMapping("/userEmpl")
    public String userEmpl( ModelMap model ,String cin ){
		Employe employe = employeRepository.getById(cin) ;
        model.addAttribute("employe", employe);
        return "userEmpl" ;
    }
	@RequestMapping(value="/user/editerem")
	public String editerem(String cin , Model model) {
		Employe employe = employeRepository.getById(cin) ;
		System.out.println(employe.getPrenom());
		model.addAttribute("entites", entiteRepository.findAll());
		model.addAttribute("employe", employe);
		return "editEmploye" ;	
		}
	 @RequestMapping("/user/user")
	    public String myMethod( ModelMap model , Principal principal){
		 String cin = principal.getName();
	       Employe employe = employeRepository.getById(cin) ;
	        model.addAttribute("employe", employe);
	        System.out.println("µµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµ");
			System.out.println(cin);
			System.out.println(employe.getNom());
	        return "user" ;
	    }
	

	///////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/formType" , method=RequestMethod.GET)
	public String formType(Model model ) {
		model.addAttribute("type", new Type());
		return "formType" ;
	}
	@RequestMapping(value="/formTypeConge" , method=RequestMethod.GET)
	public String formTypeCg(Model model) {
		model.addAttribute("typeConge", new TypeConge());
		return "formTypeConge" ;
	}
	@RequestMapping(value="/formFiliere" , method=RequestMethod.GET)
	public String formFiliere(Model model) {
		model.addAttribute("filiere", new Filiere());
		return "formFiliere" ;
	}
	@RequestMapping(value="/formFonction" , method=RequestMethod.GET)
	public String formFonction(Model model) {
		model.addAttribute("fonction", new Fonction());
		return "formFonction" ;
	}
	@RequestMapping(value="/formEntite" , method=RequestMethod.GET)
	public String formEntite(Model model) {
		model.addAttribute("types", typeRepository.findAll());
		model.addAttribute("entitePeres", entiteRepository.findAll());
		model.addAttribute("entite", new Entite());
		return "formEntite" ;
	}
	@RequestMapping(value="/user/formConge" , method=RequestMethod.GET)
	public String demandeConge(ModelMap model , Principal principal){
			 String cin = principal.getName();
		       Employe employe = employeRepository.getById(cin) ;
		        model.addAttribute("employe", employe);
		model.addAttribute("typesConge", typeCongeRepository.findAll());
		Conge conge = new Conge();
		conge.setEmploye(employe);
		model.addAttribute("conge", conge);
		return "formConge" ;
	}
	@RequestMapping(value="/formDiplome" , method=RequestMethod.GET)
	public String formDiplome(Model model) {
		model.addAttribute("filieres", filiereRepository.findAll());
		model.addAttribute("diplome", new Diplome());
		return "formDiplome" ;
	}
	@RequestMapping(value="/formEm" , method=RequestMethod.GET)
	public String formEmploye(Model model) {
		model.addAttribute("entites", entiteRepository.findAll());
		model.addAttribute("employe", new Employe());
		return "formEmploye" ;
	}
	@RequestMapping(value="/formCompte" , method=RequestMethod.GET)
	public String formCompte(Model model) {
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute("compte", new Compte());
		return "formCompte" ;
	}
	@RequestMapping(value="/formAfectation" , method=RequestMethod.GET)
	public String formAfectation(Model model) {
		model.addAttribute("fonctions", fonctionRepository.findAll());
		model.addAttribute("employes", employeRepository.findAll());
		model.addAttribute("emplFonc", new EmplFonction());
		return "formAfectation" ;
	}
	@RequestMapping(value="/formAfectationDplm" , method=RequestMethod.GET)
	public String formAfectationDplm(Model model) {
		model.addAttribute("diplomes", diplomeRepository.findAll());
		model.addAttribute("employes", employeRepository.findAll());
		model.addAttribute("emplDiplm", new EmplDiplome());
		return "formAfectationDplm" ;
	}
	///////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/SaveFonction" , method=RequestMethod.POST)
	public String saveTp( Fonction fonction , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "formFonction" ;
		fonctionRepository.save(fonction);
		return "redirect:/fonction" ;
		
	}

	@RequestMapping(value="/SaveType" , method=RequestMethod.POST)
	public String saveTp( Type type , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "formType" ;
		typeRepository.save(type);
		return "redirect:/type" ;
		
	}
	@RequestMapping(value="/SaveCompte" , method=RequestMethod.POST)
	public String saveTp( Compte compte , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "formType" ;
		compteRepository.save(compte);
		return "redirect:/formCompte" ;
		
	}
	@RequestMapping(value="/user/SaveConge" , method=RequestMethod.POST)
	public String saveTp( Conge conge , BindingResult bindingResult  , Principal principal) throws Exception {
		if(bindingResult.hasErrors()) 
			return "formConge" ;
		 
	  String cin = principal.getName();
		Employe employe = employeRepository.getById(cin) ;
		conge.setEmploye(employe);
		conge.setStatus("attente");
		congeRepository.save(conge);
		return "redirect:/user/etatDemande" ;
		
	}
	@RequestMapping(value="/SaveTypeConge" , method=RequestMethod.POST)
	public String saveTp( TypeConge typeConge , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "formTypeConge" ;
		typeCongeRepository.save(typeConge);
		return "redirect:/typeConge" ;
		
	}
	@RequestMapping(value="/SaveFiliere" , method=RequestMethod.POST)
	public String saveFl( Filiere filiere , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "formType" ;
		filiereRepository.save(filiere);
		return "redirect:/filiere" ;
		
	}
	@RequestMapping(value="/SaveEntite" , method=RequestMethod.POST)
	public String saveEn( Entite entite , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "formType" ;
		entiteRepository.save(entite);
		return "redirect:/entite" ;
		
	}
	@RequestMapping(value="/SaveDiplome" , method=RequestMethod.POST)
	public String saveDpl( Diplome diplome , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "formDiplome" ;
		diplomeRepository.save(diplome);
		return "redirect:/diplome" ;
		
	}
	@RequestMapping(value="/SaveEmplFonct" , method=RequestMethod.POST)
	public String saveEmplFonct( EmplFonction emplFonc , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "formAfectation" ;
		System.out.println("--------------"+emplFonc.getId());
		emlpFoncRepository.save(emplFonc);
		return "redirect:/EmplFonct" ;
		
	}
	@RequestMapping(value="/SaveEmplDiplm" , method=RequestMethod.POST)
	public String saveEmplDplm( EmplDiplome emplDiplm , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "formAfectationDplm" ;
		emlpDiplmRepository.save(emplDiplm);
		return "redirect:/EmplDiplm" ;
		
	}
	@RequestMapping(value="/SaveEmploye" , method=RequestMethod.POST)
	public String saveEm( Employe employe , BindingResult bindingResult , @RequestParam(name="picture") MultipartFile picture ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "formEmploye" ;
		employeRepository.save(employe);
		if(!(picture.isEmpty())) {
			employe.setPhoto(picture.getOriginalFilename());
			System.out.println(imageDir+employe.getCin());
//			picture.transferTo(new File(System.getProperty("user.home")+"/scolarite/"+picture.getOriginalFilename()));   ouverte à la modif -_-
//			picture.transferTo(new File(imageDir+picture.getOriginalFilename())); 
			picture.transferTo(new File(imageDir+employe.getCin()));
		}
		return "redirect:/employe" ;
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////

	
	
	@RequestMapping(value="/supprimerFnc")
	public String supprimerFnc(int id) {
		fonctionRepository.deleteById(id);
		return "redirect:/fonction" ;	
		}
	

	@RequestMapping(value="/supprimer")
	public String supprimer(int id) {
		typeRepository.deleteById(id);
		return "redirect:/type" ;	
		}
	@RequestMapping(value="/supprimerTypeCg")
	public String supprimertypeCg(int id) {
		typeCongeRepository.deleteById(id);
		return "redirect:/typeConge" ;	
		}
	@RequestMapping(value="/supprimerFl")
	public String supprimerFl(int id) {
		filiereRepository.deleteById(id);
		return "redirect:/filiere" ;	
		}
	@RequestMapping(value="/supprimerEn")
	public String supprimerEn(Long id) {
		entiteRepository.deleteById(id);
		return "redirect:/entite" ;	
		}
	@RequestMapping(value="/supprimerDp")
	public String supprimerDp(int id) {
		diplomeRepository.deleteById(id);
		return "redirect:/diplome" ;	
		}
	@RequestMapping(value="/supprimerem")
	public String supprimerem(String cin) {
		employeRepository.deleteById(cin);
		return "redirect:/employee" ;	
		}
///////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/editerFnc")
	public String editerFnc(int id , Model model) {
		Fonction fonction = fonctionRepository.getById(id) ;
		model.addAttribute("fonction", fonction);
		return "editFonction" ;	
		}
	@RequestMapping(value="/editer")
	public String editer(int id , Model model) {
		Type type = typeRepository.getById(id) ;
		System.out.println(type.getId()+type.getNom());
		model.addAttribute("type", type);
		return "editType" ;	
		}
	@RequestMapping(value="/editerTypeCg")
	public String editerTypeCg(int id , Model model) {
		TypeConge typeConge = typeCongeRepository.getById(id) ;
		model.addAttribute("typeConge", typeConge);
		return "editTypeConge" ;	
		}
	@RequestMapping(value="/editerFl")
	public String editerFl(int id , Model model) {
		Filiere filiere = filiereRepository.getById(id) ;
		model.addAttribute("filiere", filiere);
		return "editFiliere" ;	
		}
	
	
	@RequestMapping(value="/editerEn")
	public String editerEn(Long id , Model model) {
		Entite entite = entiteRepository.getById(id) ;
		model.addAttribute("types", typeRepository.findAll());
		model.addAttribute("entitePeres", entiteRepository.findAll());
		model.addAttribute("entite", entite);
		return "editEntite" ;	
		}
	@RequestMapping(value="/editerDp")
	public String editerDp(int id , Model model) {
		Diplome diplome = diplomeRepository.getById(id) ;
		model.addAttribute("filieres", filiereRepository.findAll());
		model.addAttribute("diplome", diplome);
		return "editDiplome" ;	
		}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/UpdateEmploye" , method=RequestMethod.POST)
	public String updateEm( Employe employe , BindingResult bindingResult , @RequestParam(name="picture") MultipartFile picture ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "editEmploye" ;
		employeRepository.save(employe);
		if(!(picture.isEmpty())) {
			employe.setPhoto(picture.getOriginalFilename());
			System.out.println(imageDir+employe.getCin());
//			picture.transferTo(new File(System.getProperty("user.home")+"/scolarite/"+picture.getOriginalFilename()));   ouverte à la modif -_-
//			picture.transferTo(new File(imageDir+picture.getOriginalFilename())); 
			picture.transferTo(new File(imageDir+employe.getCin()));
		}
		return "redirect:/employe" ;
		
	}
	@RequestMapping(value="/user/UpdateInfos" , method=RequestMethod.POST)
	public String updateInfos( Employe employe , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "editEmploye" ;
		employeRepository.save(employe);
		
		return "redirect:/user/user" ;
		
	}
	@RequestMapping(value="/UpdateType" , method=RequestMethod.POST)
	public String update(Type type , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "editType" ;
		System.out.println(type.getNom()+type.getId());
		typeRepository.save(type) ;
		
		return "redirect:/type" ;
		
	}
	@RequestMapping(value="/UpdateTypeConge" , method=RequestMethod.POST)
	public String updateTypeCg(TypeConge typeConge , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "editType" ;
		typeCongeRepository.save(typeConge) ;
		
		return "redirect:/typeConge" ;
		
	}
	@RequestMapping(value="/UpdateFiliere" , method=RequestMethod.POST)
	public String update(Filiere filiere , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "editFiliere" ;
		filiereRepository.save(filiere) ;
		
		return "redirect:/filiere" ;
		
	}
	@RequestMapping(value="/UpdateFonction" , method=RequestMethod.POST)
	public String updateFonc(Fonction fonction , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "editFonction" ;
		fonctionRepository.save(fonction) ;
		
		return "redirect:/fonction" ;
		
	}
	@RequestMapping(value="/UpdateEntite" , method=RequestMethod.POST)
	public String update(Entite entite , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "editEntite" ;
		entiteRepository.save(entite) ;
		
		return "redirect:/entite" ;
		
	}
	@RequestMapping(value="/UpdateDiplome" , method=RequestMethod.POST)
	public String updateDp(Diplome diplome , BindingResult bindingResult  ) throws Exception {
		if(bindingResult.hasErrors()) 
			return "editDiplome" ;
		diplomeRepository.save(diplome) ;
		
		return "redirect:/diplome" ;
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/user/getPhoto", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(String cin) throws Exception {
		File f = new File(imageDir+cin);
		return org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(f));
		
	}
	@RequestMapping(value="/index")
	public String login() {
		return "index" ;
	}
	
}
