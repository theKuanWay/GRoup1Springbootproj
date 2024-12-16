package sg.edu.ntu.ftbsolutionscrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.ftbsolutionscrm.dto.FavouriteDTO;
import sg.edu.ntu.ftbsolutionscrm.entity.Favourite;
import sg.edu.ntu.ftbsolutionscrm.service.FavouriteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/favourites")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @GetMapping("")
    public ResponseEntity<List<Favourite>> getAllFavouriteDTOs() {
        try {
            List<Favourite> favourites = favouriteService.getAllFavouriteDTOs();
            return ResponseEntity.ok(favourites);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Add a favourite
    @PostMapping("/{userId}/{flatId}")
    public ResponseEntity<String> addFavourite(@PathVariable Long userId, @PathVariable Long flatId) {
        favouriteService.addFavourite(userId, flatId);
        return new ResponseEntity<>("Favourite added successfully!", HttpStatus.CREATED); // HTTP 201
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FavouriteDTO>> getAllFavourites(@PathVariable Long userId) {
        try {
            List<FavouriteDTO> favourites = favouriteService.getAllFavouritesForUser(userId);
            return ResponseEntity.ok(favourites);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{favouriteId}")
    public ResponseEntity<String> deleteFavourite(@PathVariable Long favouriteId) {
        try {
            favouriteService.deleteFavourite(favouriteId);
            return ResponseEntity.ok("Favourite deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
