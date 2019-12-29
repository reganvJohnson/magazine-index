package magazineIndex.controller;

import magazineIndex.entity.Issue;
import magazineIndex.entity.Publication;
import magazineIndex.repository.IssueRepository;
import magazineIndex.repository.PublicationRepository;
import magazineIndex.viewClasses.IssueAdd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IssueController {
    private static final Logger log = LoggerFactory.getLogger(MagazineController.class);
    private final IssueRepository iRepo;
    private final PublicationRepository pRepo;
    @Autowired
    public IssueController(PublicationRepository pRepo, IssueRepository iRepo) {
        this.iRepo = iRepo;
        this.pRepo = pRepo;
    }


    @ModelAttribute("allIssues")
    public Iterable<Issue> populateIssues() {
        return iRepo.findAll();

    }
    @ModelAttribute("allPublications")
    public Iterable<Publication> populatePublications() {
        return pRepo.findAll();
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
        return "issue/list";
    }

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
        model.addAttribute("issueAdd", new IssueAdd());
        model.addAttribute("publications", pRepo.findAll());
        return "issue/add";
    }

    // process result of filled in add form
    @PostMapping("/issue/add")
    public String newIssue(@Valid IssueAdd issueAdd, BindingResult result, Model model) {
        log.info("newIssue called");
        log.info(issueAdd.toString());

        if (result.hasErrors()) {
            log.info("errors were found!!!");
            model.addAttribute("issueAdd", new IssueAdd());
            model.addAttribute("publications", pRepo.findAll());
            return "issue/add";
        }
        //iRepo.save(issueAdd);
        model.addAttribute("issues", iRepo.findAll());
        return "issue/list";
    }



    // Show edit form
    @GetMapping("/issue/edit/{id}")
    public String showEditIssueForm(@PathVariable("id") long id, Model model) {
        log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx showIssueForm()");
        Issue issue = iRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid issue Id:" + id));
        model.addAttribute("issue", issue);
        log.info("issue is" + issue.toString());
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
