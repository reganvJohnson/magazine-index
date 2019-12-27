package magazineIndex;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import magazineIndex.repository.ArticleRepository;
import magazineIndex.repository.IssueRepository;
import magazineIndex.repository.PublicationRepository;
import magazineIndex.entity.Article;
import magazineIndex.entity.Issue;
import magazineIndex.entity.Publication;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(ArticleRepository aRepo, IssueRepository iRepo, PublicationRepository pRepo) {
		//pRepo.save(new Publication("Model Railroader"));
		//pRepo.save(new Publication("Railroad Model Craftsman"));
		
		//Publication pub = pRepo.findByTitle("Model Railroad Planning").get(0);
		//iRepo.save(new Issue("2019", "", "", pub));

//		Issue issue = iRepo.findById(new Long("1")).orElseThrow();
		//aRepo.save(new Article(issue, "Modeling a sense of place", "Ken Karlewicz", "Big time railroading in a basement and a half", "design"));
		//aRepo.save(new Article(issue, "A multi-deck railroad in O scale!", "Michael George", "A move up to a larger scale presented some layout design challenges", "O, multi-deck, design"));
		//aRepo.save(new Article(issue, "The Lehigh Valley in N scale", "Ron Papiercavich", "A proessional railroader models the era when Alco Centuries prevailed", "design"));
		log.info("REGANXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//		log.info(issue.toString()); 
		return (args) -> {
			// fetch all customers
			log.info("Publications found with findAll():");
			log.info("-------------------------------");
			for (Publication publication : pRepo.findAll()) {
				log.info(publication.toString());
			}
			log.info("");
/*
			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(customer -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
*/
		};
	}
}