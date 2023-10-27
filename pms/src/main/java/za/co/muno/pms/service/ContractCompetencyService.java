package za.co.muno.pms.service;

import org.springframework.stereotype.Service;
import za.co.muno.pms.entity.Contract;
import za.co.muno.pms.entity.ContractCompetency;
import za.co.muno.pms.entity.GenericManagementCompetencies;
import za.co.muno.pms.repository.ContractCompetencyRepository;

import java.util.Optional;

@Service
public class ContractCompetencyService {
    private final ContractCompetencyRepository contractCompetencyRepository;

    public ContractCompetencyService(ContractCompetencyRepository contractCompetencyRepository) {
        this.contractCompetencyRepository = contractCompetencyRepository;
    }

    public ContractCompetency saveContractCompetency( ContractCompetency contractCompetency )
    {
        return this.contractCompetencyRepository.save(contractCompetency);
    }

    public ContractCompetency findByCompetencyAndContract(GenericManagementCompetencies genericManagementCompetencies, Contract contract)
    {
        Optional<ContractCompetency> optional = this.contractCompetencyRepository.findByCompetencyAndContract(genericManagementCompetencies,contract);

        return optional.orElse(null);
    }


}
