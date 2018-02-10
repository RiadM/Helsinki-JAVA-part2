package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class RatingRegister {

    private Map<Film, List<Rating>> ratings;
    private Map<Person,Map<Film, Rating>> personRating;

    public RatingRegister() {
        this.ratings = new HashMap();
        this.personRating = new HashMap();
    }

    public void addRating(Film film, Rating rating){
        if(this.ratings.containsKey(film)){
            this.ratings.get(film).add(rating);
        }else{
            List<Rating> newRatingList = new ArrayList();
            newRatingList.add(rating);
            this.ratings.put(film, newRatingList);
        }
    }

    public void addRating(Person person, Film film, Rating rating){
        if(this.personRating.containsKey(person)){
            addRating(film,rating);
            this.personRating.get(person).put(film,rating);
        }else{
            HashMap<Film,Rating> filmRating = new HashMap();
            filmRating.put(film,rating);
            addRating(film,rating);
            this.personRating.put(person,filmRating);
        }
    }

    public Rating getRating(Person person, Film film) {
        if (this.personRating.containsKey(person)) {
            if(this.personRating.get(person).keySet().contains(film)){
                return this.personRating.get(person).get(film);
            }
            return Rating.NOT_WATCHED;
        } else {
            return Rating.NOT_WATCHED;
        }
    }

    public List<Rating> getRatings(Film film){
        List<Rating> ratings = this.ratings.get(film);
        return ratings;
    }

    public Map<Film,Rating> getPersonalRatings(Person person){
        if(this.personRating.containsKey(person)){
            return this.personRating.get(person);
        }
        return new HashMap();
    }

    public List<Person> reviewers(){
        List<Person> reviewers = new ArrayList();
        for(Person person: this.personRating.keySet()){
            reviewers.add(person);
        }
        return reviewers;
    }


    public Map<Film, List<Rating>> filmRatings(){
        return this.ratings;
    }
}
