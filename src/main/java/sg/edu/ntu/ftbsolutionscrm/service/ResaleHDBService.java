package sg.edu.ntu.ftbsolutionscrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.ntu.ftbsolutionscrm.entity.ResaleHdb;
import sg.edu.ntu.ftbsolutionscrm.exception.HDBUserNotFoundException;
import sg.edu.ntu.ftbsolutionscrm.exception.ResaleHdbNotFoundException;
import sg.edu.ntu.ftbsolutionscrm.repository.ResaleHDBRepository;

import java.util.List;
import java.util.Optional;

public interface ResaleHDBService {

    List<ResaleHdb> getAllResaleHDB();

    ResaleHdb getResaleHDBById(Long id);

    ResaleHdb updatResaleHDB(Long id, ResaleHdb resaleHDB);

    ResaleHdb createResaleHDB(ResaleHdb resaleHDB);

    public void deleteResaleHDB(Long id);
}
