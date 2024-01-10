package damir.kad.medicine;


import Services.CategoryService;
import model.Category;
import model.Medicine;
import Services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EntityScan(basePackages = {"model"})
public class MedicineApplication {

    private CategoryService categoryService;
    private MedicineService medicineService;

    public static void main(String[] args) {
        SpringApplication.run(MedicineApplication.class, args);
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Category> categories = categoryService.findAll();
        List<Medicine> medicines = medicineService.findAll();

        model.addAttribute("categories", categories);
        model.addAttribute("medicines", medicines);

        return "index";
    }
}