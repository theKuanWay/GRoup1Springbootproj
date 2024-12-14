package sg.edu.ntu.ftbsolutionscrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.ftbsolutionscrm.entity.HDBUser;

public interface HdbUserRepository extends JpaRepository <HDBUser, Long> {

    
}
