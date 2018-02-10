package reference;

import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class Reference {

    private RatingRegister ratingRegister;

    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }

    //It work well for people who never watched movie before in the list of movies
    public Film recommendFilm(Person person){
        //Get all the person who reviewed movies
        List<Person> reviewers = this.ratingRegister.reviewers();

        List<Film> filmsToWatch = new ArrayList();
        filmsToWatch.addAll(this.ratingRegister.filmRatings().keySet());

        //Return the film with the best average if the user never saw one movie
        if(reviewers.contains(person) == false){
            Collections.sort(filmsToWatch, new FilmComparator(this.ratingRegister.filmRatings()));
            return filmsToWatch.get(0);
        }else{
            //Create a list of film watched by the person
            List<Film> filmWatched = new ArrayList();
            filmWatched.addAll(this.ratingRegister.getPersonalRatings(person).keySet());

            //Remove the person from the reviewers
            reviewers.remove(person);

            //Find the best person by score to suggest a movie to the person
            Person bestPerson = null;
            int bestScore = 0;

            for(Person reviewer: reviewers){
                int score = 0;
                List<Film> films = new ArrayList();
                films.addAll(this.ratingRegister.getPersonalRatings(reviewer).keySet());
                films.retainAll(filmWatched);

                for(Film film: films){
                    score +=  (this.ratingRegister.getRating(reviewer,film).getValue() *  this.ratingRegister.getRating(person,film).getValue());
                }
                if(score > bestScore){
                    bestPerson = reviewer;
                }
            }

            if(bestPerson == null){
                return null;
            }

            //Films rated by this person
            Map<Film, Rating> bestPersonRatings = this.ratingRegister.getPersonalRatings(bestPerson);
            //Remove Film not seen by this person
            List<Film> bestPersonFilmNotWatched = new ArrayList();
            bestPersonFilmNotWatched.addAll(bestPersonRatings.keySet());

            Film filmRecommended = null;
            bestScore = 1;
            for(Film film: bestPersonFilmNotWatched){
                int score = bestPersonRatings.get(film).getValue();
                if(score > bestScore){
                    filmRecommended = film;
                    bestScore = score;
                }
            }
            return filmRecommended;
        }
    }
}