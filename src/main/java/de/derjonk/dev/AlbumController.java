package de.derjonk.dev;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Album.class)
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private EntityLinks entityLinks;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Resource<Album>> getAllAlbum() {
		return Arrays.asList("123", "456", "789").stream().map(n -> {
			final Resource<Album> a = new Resource<>(new Album(n));
			a.add(entityLinks.linkToSingleResource(Album.class, n));
			return a;
		}).collect(Collectors.toList());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Resource<Album> getAlbumDetails(@PathVariable(value = "id") final String albumId) {

		final Resource<Album> album = new Resource<>(new Album(albumId));
		album.add(linkTo(methodOn(AlbumController.class).getAlbumDetails(albumId)).withSelfRel());
		album.add(linkTo(methodOn(AlbumController.class).getSongs(albumId)).withRel("songs"));

		return album;
	}

	@RequestMapping(value = "/{albumId}/songs", method = RequestMethod.GET)
	@ResponseBody
	public Collection<Resource<Song>> getSongs(@PathVariable("albumId") final String albumId) {
		return Arrays.asList("Song1", "Song2", "Song3").stream().map(Song::new).map(s -> {
			final Resource<Song> r = new Resource<>(s);
			r.add(entityLinks.linkToSingleResource(Song.class, s.getName()));
			return r;
		}).collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public Resource<Album> createAlbum(final String name) {
		final Resource<Album> album = new Resource<>(new Album(name));
		album.add(entityLinks.linkToSingleResource(Album.class, name));

		return album;
	}
}
