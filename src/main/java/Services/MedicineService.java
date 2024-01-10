package Services;

import Repositories.MedicineRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Medicine;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class MedicineService implements MedicineRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Medicine> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Medicine> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Medicine> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Medicine getOne(Long aLong) {
        return null;
    }

    @Override
    public Medicine getById(Long aLong) {
        return null;
    }

    @Override
    public Medicine getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Medicine> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Medicine> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Medicine> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Medicine> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Medicine> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Medicine> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Medicine, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Medicine> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Medicine> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Medicine> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Medicine> findAll() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("postgres");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Medicine> medicineTypedQuery = manager.createQuery("select m from Medicine m", Medicine.class);
        List<Medicine> medicines = medicineTypedQuery.getResultList();
        manager.close();
        factory.close();
        return medicines;
    }

    @Override
    public List<Medicine> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Medicine entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Medicine> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Medicine> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Medicine> findAll(Pageable pageable) {
        return null;
    }
}
