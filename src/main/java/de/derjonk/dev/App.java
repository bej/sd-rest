package de.derjonk.dev;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableEntityLinks;

import de.derjonk.dev.model.Factor;
import de.derjonk.dev.model.FactorGroup;
import de.derjonk.dev.model.Name;
import de.derjonk.dev.model.Reference;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEntityLinks
public class App {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(final String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner demo(final ArtistRepository artistRepo, final AlbumRepository albumRepo,
			final FactorRepository factorRepo, final FactorGroupRepository factorGroupRepo) {
		return (args) -> {

			artistRepo.save(new Artist("Muddy", "Waters"));
			artistRepo.save(new Artist("Kari", "Bremnes"));
			albumRepo.save(new Album("Folk Singer"));
			albumRepo.save(new Album("Folk"));

			for (final Artist artist : artistRepo.findAll()) {
				logger.info(artist.toString());
			}

			final List<Artist> artistMatches = artistRepo.findByLastName("Waters");
			if (!artistMatches.isEmpty()) {
				final Artist artist = artistMatches.get(0);
				final List<Album> albums = Arrays.asList("Folk Singer", "Folk").stream().map(albumRepo::findByName)
						.flatMap(List::stream).collect(Collectors.toList());

				artist.addAlbum(albums.toArray(new Album[albums.size()]));
				artistRepo.save(artist);
			}

			final Factor asthma = new Factor(new Name("Asthma"), "medical");
			factorRepo.save(asthma);
			final Factor diabetes = new Factor(new Name("Diabetes"), "medical");
			factorRepo.save(diabetes);

			final FactorGroup asthmaGroup = new FactorGroup(new Name("AsthmaGroup"));
			factorGroupRepo.save(asthmaGroup);

			final FactorGroup match = factorGroupRepo.findByNameValue("AsthmaGroup").get(0);
			match.addFactorReference(new Reference(asthma.getName()));
			factorGroupRepo.save(match);

		};
	}
}
