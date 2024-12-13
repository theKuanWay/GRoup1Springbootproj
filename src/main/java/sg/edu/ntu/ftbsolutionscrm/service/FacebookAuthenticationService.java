package sg.edu.ntu.ftbsolutionscrm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.ntu.ftbsolutionscrm.entity.Login;
import sg.edu.ntu.ftbsolutionscrm.repository.FacebookLoginRepository;
import sg.edu.ntu.ftbsolutionscrm.repository.LoginRepository;

@Service
public class FacebookAuthenticationService {

    @Autowired
    private FacebookLoginRepository facebookLoginRepository;

    public boolean authenticateWithFacebook(String facebookUid) {
        return facebookLoginRepository.findByFacebookUid(facebookUid).isPresent();
    }
}
