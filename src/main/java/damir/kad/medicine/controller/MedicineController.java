package damir.kad.medicine.controller;

import damir.kad.medicine.model.*;
import damir.kad.medicine.model.enums.UserRole;
import damir.kad.medicine.repositories.CategoryRepository;
import damir.kad.medicine.repositories.MedicineRepository;
import damir.kad.medicine.services.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/medicines")
public class MedicineController {
    private final CategoryRepository categoryRepository;
    private final MedicineRepository medicineRepository;
    private final UserService userService;

    @GetMapping
    private String medicineList (Model model){
        User currentUser = userService.getCurrentUser();
        List<Medicine> medicines;
        if(currentUser != null && currentUser.getRole() == UserRole.ADMIN){
            medicines = medicineRepository.findAll();
        } else {
            medicines = medicineRepository.findAllByDisplayTrue();
        }
        model.addAttribute("medicines", medicines);
        return "medicines/medicine_list_page";
    }

    @GetMapping(path = "/create")
    private String createMedicinePage(Model model){
        List<Category> categories = categoryRepository.findAll(Sort.by("name"));
        model.addAttribute("categories", categories);
        model.addAttribute("medicine", new Medicine());
        return "medicines/create_medicine_page";
    }

    @PostMapping(path = "/create")
    private String createMedicineAction(@ModelAttribute(name = "medicine") Medicine medicine){
        medicineRepository.save(medicine);
        return "redirect:/medicines";
    }

    @GetMapping(path = "/update")
    private String updateMedicinePages(@RequestParam(name = "medicineId") Long medicineId, Model model){
        List<Category> categories = categoryRepository.findAll(Sort.by("name"));
        model.addAttribute("categories", categories);
        Medicine medicine = medicineRepository.findById(medicineId).orElseThrow();
        model.addAttribute("medicine", medicine);
        medicineRepository.deleteById(medicineId);
        return "medicines/update_medicine_page";
    }

    @PostMapping(path = "/update")
    private String updateMedicineAction(@ModelAttribute(name = "medicine") Medicine medicine){
        medicineRepository.save(medicine);
        return "redirect:/medicines";
    }

    @GetMapping(path = "/delete")
    private String deleteMedicine(@RequestParam(name = "medicineId") Long medicineId){
        medicineRepository.deleteById(medicineId);
        return "redirect:/medicines";
    }
}