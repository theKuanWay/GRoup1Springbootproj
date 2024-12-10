package sg.edu.ntu.ftbsolutionscrm.service;

import java.util.List;

import sg.edu.ntu.ftbsolutionscrm.entity.Favourite;

public interface FavouriteService {

    Favourite saveFavourite(Favourite favourite);

    Favourite getFavourite(Long id);

    List<Favourite> getAllFavourites();

    Favourite updateFavourite(Long id, Favourite favourite);

    void deleteFavourite (Long id);
    
}
