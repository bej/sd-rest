package de.derjonk.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ExposesResourceFor(Song.class)
@RequestMapping("/song")
public class SongController implements ResourceProcessor<Resource<Song>> {

	@Autowired
	private EntityLinks entityLinks;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Resource<Song> getSong(@PathVariable("id") final String id) {
		return new Resource<Song>(new Song(id));
	}

	@Override
	public Resource<Song> process(final Resource<Song> song) {
		System.out.println("process resource");
		song.add(entityLinks.linkToSingleResource(Song.class, song.getContent().getName()));
		return song;
	}

}
