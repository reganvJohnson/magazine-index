package magazineIndex.controller;

import magazineIndex.entity.Publication;
import magazineIndex.repository.PublicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PublicationController {


    private final PublicationRepository pRepo;
    private static final Logger log = LoggerFactory.getLogger(PublicationController.class);

    @Autowired
    public PublicationController(PublicationRepository pRepo) {
        this.pRepo = pRepo;
    }


    @ModelAttribute("allPublications")
    public Iterable<Publication> populatePublications() {
        return pRepo.findAll();
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
        return "publication/list";
    }

    // delete a publication
    @GetMapping("/publication/delete/{id}")
    public String deletePublicaton(@PathVariable("id") long id, Model model) {
        log.info("delete Publication called");
        Publication publication = pRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid publication Id:" + id));
        pRepo.delete(publication);
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
        log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxSave called");
        if (result.hasErrors()) {
            publication.setId(id);
            return "publication/update";
        }
        pRepo.save(publication);
        return "publication/list";
    }


}
