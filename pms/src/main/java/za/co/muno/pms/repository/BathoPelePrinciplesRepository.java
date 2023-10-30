package za.co.muno.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.muno.pms.entity.BathoPelePrinciples;

public interface BathoPelePrinciplesRepository extends JpaRepository<BathoPelePrinciples, Long> {
    BathoPelePrinciples findByName(String name);
}
