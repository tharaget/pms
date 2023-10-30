package za.co.muno.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.muno.pms.entity.Contract;
import za.co.muno.pms.entity.ContractCompetency;
import za.co.muno.pms.entity.GenericManagementCompetencies;

import java.util.Optional;

public interface ContractCompetencyRepository extends JpaRepository<ContractCompetency, Long> {

    Optional<ContractCompetency> findByCompetencyAndContract(GenericManagementCompetencies competency, Contract contract);
}
