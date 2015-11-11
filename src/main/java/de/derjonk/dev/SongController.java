package de.derjonk.dev;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Song.class)
@RequestMapping("/song")
public class SongController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Resource<Song> getSong(@PathVariable("id") final String id) {
		final Resource<Song> song = new Resource<Song>(new Song(id));
		song.add(linkTo(methodOn(SongController.class).getSong(id)).withSelfRel());
		return song;
	}
}
