package org.java.app.best;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.java.app.movie.Movie;
import org.java.app.song.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
	
	
	
	@GetMapping("/")
	public String index(Model model) {	
		
		String name = "Gertrude";
		
		model.addAttribute("name", name);
		
		return "index";
	}
	
	
	
	@GetMapping("/movies")
	public String movies(Model model) {
		
		List <Movie> moviesList = getBestMovies();
		
		String moviesListString = moviesList.stream()
				.map(Movie::toString)
				.collect(Collectors.joining(", "));

		model.addAttribute("moviesListString", moviesListString);
				
		return "movies";
	}
	
	
	
	@GetMapping("/songs")
	public String songs(Model model) {
		
		List <Song> songsList = getBestSongs();
		
		String songsListString = songsList.stream()
				.map(Song::toString)
				.collect(Collectors.joining(", "));

		model.addAttribute("songsListString", songsListString);
				
		return "songs";
	}
	

	
	@GetMapping("/movies/{id}")
	public String movie(@PathVariable int id, Model model) {
		
		String titolo = "";
		
		for (Movie m : getBestMovies())
			if (m.getId() == id)
				titolo = m.getTitolo();
		
		model.addAttribute("titolo", titolo);
		
		return "title";
	}
	

	
	@GetMapping("/songs/{id}")
	public String song(@PathVariable int id, Model model) {
		
		String titolo = "";
		
		for (Song s : getBestSongs())
			if (s.getId() == id)
				titolo = s.getTitolo();
		
		model.addAttribute("titolo", titolo);
		
		return "title";
	}
	
	
	
	private List<Movie> getBestMovies() {
		
		List<Movie> movies = new ArrayList<>();
		
		movies.add(new Movie(1, "arancia"));
		movies.add(new Movie(2, "odissea"));
		movies.add(new Movie(3, "jacket"));
		movies.add(new Movie(4, "eye"));
		movies.add(new Movie(5, "il bi e il ba"));
		
		return movies;
	}
	
	
	
	private List<Song> getBestSongs() {
		
		List<Song> songs = new ArrayList<>();
		
		songs.add(new Song(1, "money"));
		songs.add(new Song(2, "robot"));
		songs.add(new Song(3, "upside"));
		songs.add(new Song(4, "freak"));
		songs.add(new Song(5, "tour"));

		return songs;
	}
}
