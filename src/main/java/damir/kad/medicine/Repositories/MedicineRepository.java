package damir.kad.medicine.Repositories;

import damir.kad.medicine.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findAllByDisplayTrue();
}
