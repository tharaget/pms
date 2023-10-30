package za.co.muno.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.muno.pms.entity.BathoPelePrinciples;
import za.co.muno.pms.entity.IndividualKPA;
import za.co.muno.pms.entity.KPABathoPelePrinciples;

import java.util.Optional;

public interface KPABathoPelePrinciplesRepository extends JpaRepository<KPABathoPelePrinciples,Long> {
    Optional<KPABathoPelePrinciples> findByBathoPelePrinciplesAndAndKpa(BathoPelePrinciples principles, IndividualKPA kpa);
}
