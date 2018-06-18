package com.bahaida.readinglist;

import com.bahaida.readinglist.persistence.domain.Reader;
import com.bahaida.readinglist.persistence.repositories.ReaderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReadingListApplication {

	private static final Logger logger = LoggerFactory.getLogger(ReadingListApplication.class);
	@Bean
	CommandLineRunner commandLineRunner (ReaderRepository readerRepository){
		return args -> {
			Reader r1 = new Reader();
			r1.setFullName("Brahim Bahaida");
			r1.setUsername("admin");
			r1.setPassword("password");

			r1.getAuthorities().forEach(a -> logger.info(a.getAuthority()));
			readerRepository.save(r1);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}
}
