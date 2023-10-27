package za.co.muno.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.muno.pms.entity.CompetencyType;
import za.co.muno.pms.entity.GenericManagementCompetencies;

public interface GenericManagementCompetenciesRepository extends JpaRepository<GenericManagementCompetencies, Long> {
    GenericManagementCompetencies findByNameAndType(String name, CompetencyType type);
}
