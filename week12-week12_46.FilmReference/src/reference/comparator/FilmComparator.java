package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FilmComparator implements Comparator<Film>{

    Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        int one = 0;
        int two = 0;

        for(Rating rating: this.ratings.get(o1)){
            one += rating.getValue();
        }
        for(Rating rating: this.ratings.get(o2)){
            two += rating.getValue();
        }

        if(one > two){
            return -1;
        }
        if(one < two){
            return 1;
        }
        else{
            return 0;
        }
    }
}
