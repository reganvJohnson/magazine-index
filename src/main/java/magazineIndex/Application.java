package magazineIndex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import magazineIndex.repository.IssueRepository;
import magazineIndex.repository.PublicationRepository;
import magazineIndex.entity.Issue;
import magazineIndex.entity.Publication;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(IssueRepository iRepo, PublicationRepository pRepo) {
		//pRepo.save(new Publication("Model Railroader"));
		//pRepo.save(new Publication("Railroad Model Craftsman"));
		
		//Publication pub = pRepo.findByTitle("Model Railroad Planning").get(0);
		//iRepo.save(new Issue("2019", "", "", pub));

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