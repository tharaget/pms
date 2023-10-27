package za.co.muno.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.muno.pms.entity.Account;
import za.co.muno.pms.entity.Contract;
import za.co.muno.pms.entity.Cycle;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long>
{
    List<Contract> findContractByAccount(Account account);

    List<Contract> findContractByAccount_SupervisorPersonalNumber( String supervisorPersonalNumber);
    Optional<Contract> findContractById(Long id);
    Contract findByCycleAndAccount_PersonalNumber(Cycle cycle, String personalNumber);
}
