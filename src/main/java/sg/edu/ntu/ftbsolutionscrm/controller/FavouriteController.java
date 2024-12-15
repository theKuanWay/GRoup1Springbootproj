package sg.edu.ntu.ftbsolutionscrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // Add a favourite
    @PostMapping("/{userId}/{flatId}")
    public ResponseEntity<String> addFavourite(@PathVariable Long userId, @PathVariable Long flatId) {
        favouriteService.addFavourite(userId, flatId);
        return new ResponseEntity<>("Favourite added successfully!", HttpStatus.CREATED); // HTTP 201
    }
    
        // Get all favourites for a user
    @GetMapping("/{userId}")
    public ResponseEntity< List<Favourite>> getFavouritesByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(favouriteService.getFavouritesByUser(userId), HttpStatus.OK);
    }

        // Delete a favourite by its ID
    @DeleteMapping("/{favouriteId}")
    public ResponseEntity<HttpStatus> deleteFavourite(@PathVariable Long favouriteId) {
        favouriteService.deleteFavourite(favouriteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
