package magazineIndex.controller;

import javax.validation.Valid;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import magazineIndex.entity.Publication;
import magazineIndex.repository.PublicationRepository;
import magazineIndex.entity.Issue;
import magazineIndex.repository.IssueRepository;


@Controller
public class MagazineController {

private final PublicationRepository pRepo;
private final IssueRepository iRepo;
private static final Logger log = LoggerFactory.getLogger(MagazineController.class);

   @Autowired
    public MagazineController(PublicationRepository pRepo, IssueRepository iRepo) {
        this.pRepo = pRepo;
        this.iRepo = iRepo;
    }

   // index page
   @RequestMapping(value = "/index")
   public String index() {
      return "index";
   }
   @RequestMapping(value = "")
   public String indexx() {
      return "index";
   }

   // list all the publications
   @RequestMapping(value = "/publications")
   public String showPublicationForm(Model model) {
   			log.info("Publications found with findAll():");
			log.info("-------------------------------");
			for (Publication publication : pRepo.findAll()) {
				log.info(publication.toString());
			}
			log.info("");
		model.addAttribute("publications", pRepo.findAll());
       return "publication/list";
   }

    // show blank add form
    @GetMapping("/publication/new")
    public String showNewPublicationForm(Publication publication) {
   	    return "publication/add";
    }

    // process result of filled in add form
    @PostMapping("/publication/add")
    public String newPublication(@Valid Publication publication, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "publication/add";
        }
        pRepo.save(publication);
        model.addAttribute("publications", pRepo.findAll());
        return "publication/list";
    }

    // delete a publication
    @GetMapping("/publication/delete/{id}")
    public String deletePublicaton(@PathVariable("id") long id, Model model) {
    	log.info("delete Publication called");
        Publication publication = pRepo.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid publication Id:" + id));
        pRepo.delete(publication);
        model.addAttribute("publications", pRepo.findAll());
        return "publication/list";
    }

    // Show edit form
    @GetMapping("/publication/edit/{id}")
    public String showEditPublicationForm(@PathVariable("id") long id, Model model) {
   		Publication publication = pRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid publication Id:" + id));
        model.addAttribute("publication", publication);
        return "publication/update";
    }

    // process result of editing
    @PostMapping("publication/update/{id}")
    public String publicationUpdate(@PathVariable("id") long id, @Valid Publication publication, BindingResult result, Model model) {

        if (result.hasErrors()) {
            publication.setId(id);
            return "publication/update";
        }
        pRepo.save(publication);
        model.addAttribute("publications", pRepo.findAll());
        return "publication/list";
    }
    
     // not working attempt to have a default page.
    @RequestMapping(value = "*")
    public String getFallback(@RequestParam("name") String name, HttpServletRequest request) {    
        String path = request.getServletPath();
    	log.error("unknown path: " + path);
        return "index";
    }



   // list all the issues
   @RequestMapping(value = "/issues")
   public String showIssueList(Model model) {
   			log.info("Issues found with findAll():");
			log.info("-------------------------------");
			for (Issue issue : iRepo.findAll()) {
				log.info(issue.toString());
			}
			log.info("");
		model.addAttribute("issues", iRepo.findAll());
       return "issue/list";
   }
/*
   // show blank add form
    @GetMapping("/issue/new")
    public String showNewIssueForm(Issue issue) {
   	    return "issue/add";
    }

    // process result of filled in add form
    @PostMapping("/issue/add")
    public String newIssue(@Valid Issue issue, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "issue/add";
        }
        iRepo.save(issue);
        model.addAttribute("issues", iRepo.findAll());
        return "issue/list";
    }
*/
    // delete a issue
    @GetMapping("/issue/delete/{id}")
    public String deleteIssue(@PathVariable("id") long id, Model model) {
    	log.info("delete Issue called");
        Issue issue = iRepo.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid issue Id:" + id));
        iRepo.delete(issue);
        model.addAttribute("issues", iRepo.findAll());
        return "issue/list";
    }



    // show blank add form
    @GetMapping("/issue/new")
    public String showNewIssueForm(Model model) {
    	model.addAttribute("issue", new Issue());
    	model.addAttribute("publications", pRepo.findAll());
   	    return "issue/add";
    }

    // process result of filled in add form
    @PostMapping("/issue/add")
    public String newIssue(@Valid Issue issue, @Valid List<Publication> publications, BindingResult result, Model model) {
    	log.info("newIssue called");
        log.info(issue.toString());
        
        for (Publication publication: publications) {
        	log.info(publication.toString());
        }
        if (result.hasErrors()) {
        	log.info("errors were found!!!");
        	model.addAttribute("issue", new Issue());
        	model.addAttribute("publications", pRepo.findAll());
            return "issue/add";
        }
        log.info("REGAN1");
        //        iRepo.save(issue);
        log.info("REGAN2");
        model.addAttribute("issues", iRepo.findAll());
        log.info("REGAN3");

        return "issue/list";
    }



    // Show edit form
    @GetMapping("/issue/edit/{id}")
    public String showEditIssueForm(@PathVariable("id") long id, Model model) {
   		Issue issue = iRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid issue Id:" + id));
        model.addAttribute("issue", issue);
        return "issue/update";
    }

    // process result of editing
    @PostMapping("issue/update/{id}")
    public String issueUpdate(@PathVariable("id") long id, @Valid Issue issue, BindingResult result, Model model) {

        if (result.hasErrors()) {
            issue.setId(id);
            return "issue/update";
        }
        issue.setPublication(pRepo.findByTitle("Model Railroad Planning").get(0));
        log.info("Saving issue: " + issue.toString());
        iRepo.save(issue);
        model.addAttribute("issues", iRepo.findAll());
        return "issue/list";
    }
    

}