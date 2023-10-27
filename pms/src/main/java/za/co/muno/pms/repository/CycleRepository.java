package za.co.muno.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.muno.pms.entity.Cycle;

import java.util.Optional;

public interface CycleRepository extends JpaRepository<Cycle, Long> {

    Cycle findByAllowCreate(boolean allowCreate);
}
