package magazineIndex.controller;

import javax.validation.Valid;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import magazineIndex.entity.Publication;
import magazineIndex.repository.PublicationRepository;
import magazineIndex.entity.Issue;
import magazineIndex.repository.ArticleRepository;
import magazineIndex.repository.IssueRepository;
import magazineIndex.viewClasses.IssueAdd;
import magazineIndex.viewClasses.SeedsView;

@Controller
public class MagazineController {

private final PublicationRepository pRepo;
private final IssueRepository iRepo;
private final ArticleRepository aRepo;
private static final Logger log = LoggerFactory.getLogger(MagazineController.class);

   @Autowired
    public MagazineController(PublicationRepository pRepo, IssueRepository iRepo, ArticleRepository aRepo) {
        this.pRepo = pRepo;
        this.iRepo = iRepo;
        this.aRepo = aRepo;
    }

   // index page
   @RequestMapping(value = "/index")
   public String index(Model model) {
	   List<SeedsView> bob = new ArrayList<SeedsView>();
	   bob.add(new SeedsView("1", "2", "3")); 
	   model.addAttribute("seedstarter", bob);
      return "index";
   }
   @RequestMapping(value = "")
   public String index() {
      return "index";
   }
   
   @RequestMapping(value="seeds")
   public String seeds() {
	   return "seeds";
   }



//     // not working attempt to have a default page.
//    @RequestMapping(value = "*")
//    public String getFallback(@RequestParam("name") String name, HttpServletRequest request) {
//        String path = request.getServletPath();
//    	log.error("unknown path: " + path);
//        return "index";
//    }

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

    

}