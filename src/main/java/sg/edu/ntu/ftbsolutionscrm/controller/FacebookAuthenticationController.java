package sg.edu.ntu.ftbsolutionscrm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.ftbsolutionscrm.service.FacebookAuthenticationService;

// import com.google.firebase.auth.FirebaseAuth;
// import com.google.firebase.auth.FirebaseAuthException;
// import com.google.firebase.auth.FirebaseToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class FacebookAuthenticationController {

    @Autowired
    private FacebookAuthenticationService facebookAuthenticationService;

    @PostMapping("/facebook-login")
    public ResponseEntity<?> authenticateWithFacebook(@RequestBody Map<String, String> requestBody) {
        String facebookUid = requestBody.get("facebookUid");

        if (facebookUid == null || facebookUid.isEmpty()) {
            return ResponseEntity.badRequest().body("Missing or invalid Facebook UID");
        }

        boolean isAuthenticated = facebookAuthenticationService.authenticateWithFacebook(facebookUid);
        if (isAuthenticated) {
            return ResponseEntity.ok("Facebook login successful");
        } else {
            return ResponseEntity.status(401).body("Facebook authentication failed");
        }
    }
}
