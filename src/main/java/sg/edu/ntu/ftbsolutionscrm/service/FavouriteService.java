package sg.edu.ntu.ftbsolutionscrm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.ntu.ftbsolutionscrm.entity.Favourite;
import sg.edu.ntu.ftbsolutionscrm.entity.HDBUser;
import sg.edu.ntu.ftbsolutionscrm.entity.ResaleHdb;
import sg.edu.ntu.ftbsolutionscrm.repository.FavouriteRepository;
import sg.edu.ntu.ftbsolutionscrm.repository.HdbUserRepository;
import sg.edu.ntu.ftbsolutionscrm.repository.ResaleHDBRepository;

@Service
public class FavouriteService {

    @Autowired
    private ResaleHDBRepository resaleHDBRepository;

    @Autowired
    private HdbUserRepository hdbUserRepository;

    @Autowired
    private FavouriteRepository favouriteRepository;

    public void addFavourite(Long userId, Long flatId) {
        Optional<HDBUser> userOpt = hdbUserRepository.findById(userId);
        Optional<ResaleHdb> flatOpt = resaleHDBRepository.findById(flatId);
        if (userOpt.isPresent() && flatOpt.isPresent()) {
            Favourite favourite = new Favourite();
            favourite.setUser(userOpt.get());
            favourite.setFlat(flatOpt.get());
            favouriteRepository.save(favourite);
        } else {
            throw new RuntimeException("User or Flat not found");

        }
    }

    public List<Favourite> getFavouritesByUser(Long userId) {
        return favouriteRepository.findByUserId(userId);
    }

    public void deleteFavourite(Long favouriteId) {
        if (favouriteRepository.existsById(favouriteId)) {
            favouriteRepository.deleteById(favouriteId);
        } else {
            throw new RuntimeException("Favourite not found with ID: " + favouriteId);
        }
    }

}
