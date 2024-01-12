package damir.kad.medicine.comtroller;

import damir.kad.medicine.repositories.CategoryRepository;
import damir.kad.medicine.repositories.MedicineRepository;
import damir.kad.medicine.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/product")
public class MedicineController {
    private final CategoryRepository categoryRepository;
    private final MedicineRepository medicineRepository;
    private final UserRepository userRepository;

    @GetMapping
    private String productList (Model model){

    }

}
