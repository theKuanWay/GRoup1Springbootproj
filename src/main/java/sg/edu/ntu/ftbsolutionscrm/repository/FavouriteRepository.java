package sg.edu.ntu.ftbsolutionscrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.ftbsolutionscrm.entity.Favourite;

public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
    
}
