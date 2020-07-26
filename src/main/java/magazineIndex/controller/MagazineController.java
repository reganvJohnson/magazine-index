package magazineIndex.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import magazineIndex.repository.PublicationRepository;
import magazineIndex.repository.IssueRepository;
import magazineIndex.viewClasses.SeedsView;

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