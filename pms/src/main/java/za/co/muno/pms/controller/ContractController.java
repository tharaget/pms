package za.co.muno.pms.controller;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import za.co.muno.pms.dto.ContractDTO;
import za.co.muno.pms.dto.KPABathoPeleDTO;
import za.co.muno.pms.dto.KPADTO;
import za.co.muno.pms.entity.*;
import za.co.muno.pms.service.BathoPelePrinciplesService;
import za.co.muno.pms.service.ContractCompetencyService;
import za.co.muno.pms.service.ContractService;
import za.co.muno.pms.service.GenericManagementCompetenciesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/contract")
@CrossOrigin("*")
public class ContractController
{
    private final ContractService contractService;

    private final BathoPelePrinciplesService bathoPelePrinciplesService;

    private final GenericManagementCompetenciesService genericManagementCompetenciesService;

    private final ContractCompetencyService contractCompetencyService;

    public ContractController(ContractService contractService, BathoPelePrinciplesService bathoPelePrinciplesService, GenericManagementCompetenciesService genericManagementCompetenciesService, ContractCompetencyService contractCompetencyService) {
        this.contractService = contractService;
        this.bathoPelePrinciplesService = bathoPelePrinciplesService;
        this.genericManagementCompetenciesService = genericManagementCompetenciesService;
        this.contractCompetencyService = contractCompetencyService;
    }

    @PostMapping(path = "find_by_account")
    public ContractDTO findContractByAccount(@RequestBody Account account)
    {
        ContractDTO dto = new ContractDTO();
        dto.setSubordinatesContracts(this.contractService.findContractByAccountSupervisorPersonalNumber(account.getPersonalNumber()));
        dto.setMyContracts( this.contractService.findContractByAccount(account) );

        return dto;
    }


    @PostMapping(path = "create_contract")
    public Contract newContract(@RequestBody Account account)
    {
        System.out.println("newContract***********************************************");
        return this.contractService.createNewContract( account );
    }

    @PostMapping(path = "load_contract")
    public Contract loadContract(@RequestBody ContractDTO dto)
    {
        return this.contractService.findContractById(dto.getContractId());
    }

    @PostMapping(path = "update_contract_status")
    public void updateContract(@RequestBody ContractDTO dto)
    {
        Contract contract = this.contractService.updateContractStatus(dto.getContractId(), dto.getStatus());
        if( dto.getComment() != null ) {
            this.contractService.createNotes(dto.getAccount(), dto.getComment(), contract, dto.getStatus());
        }
    }



    @PostMapping(path = "delete_kpa_batho_pele_principle")
    public void deleteKpaBathoPelePrinciple(@RequestBody KPABathoPelePrinciples kpaBathoPelePrinciples )
    {
        contractService.deleteKpaBathoPelePrinciple(kpaBathoPelePrinciples.getId());
    }


    @PostMapping(path = "save_kpa_batho_pele_principle")
    public KPABathoPelePrinciples saveKpaBathoPelePrinciple(@RequestBody KPABathoPeleDTO kpaBathoPeleDTO)
    {
        Optional<BathoPelePrinciples> optional = bathoPelePrinciplesService.findById( kpaBathoPeleDTO.getBathoPelePrinciplesId() );

        if( optional.isEmpty() )
        {
            throw new IllegalArgumentException("Could not find Batho Pele Principles");
        }
        return contractService.saveKpaBathoPelePrinciple(kpaBathoPeleDTO.getKpa(), optional.get() );
    }


    @PostMapping(path = "save_kpa")
    public IndividualKPA saveIndividualKPA(@RequestBody KPADTO dto)
    {
        dto.getKpa().setContract(contractService.findContractById(dto.getContractId()));
        return contractService.saveIndividualKPA( dto.getKpa() );
    }

    @PostMapping(path = "delete_kpa")
    public void deleteKpa(@RequestBody IndividualKPA kpa )
    {
        contractService.deleteKpa(kpa.getId());
    }


    @PostMapping(path = "delete_contract_competency")
    public void deleteCompetencies(@RequestBody ContractDTO dto )
    {
        contractService.deleteContractCompetency(dto.getContractCompetencyId());
    }


    @PostMapping(path = "save_contract_competency")
    public ContractDTO saveContractCompetency(@RequestBody ContractDTO dto)
    {
        GenericManagementCompetencies competencies = this.genericManagementCompetenciesService.findById( dto.getGenericManagementCompetenciesId());
        Contract contract = this.contractService.findContractById(dto.getContractId());

        ContractCompetency contractCompetency = new ContractCompetency(contract, competencies);

        if (this.contractCompetencyService.findByCompetencyAndContract( competencies, contract) == null )
        {
            dto.setContractCompetency(this.contractCompetencyService.saveContractCompetency(contractCompetency));
        } else {
            throw new DuplicateKeyException("Generic Management Competencies already inserted");
        }

        return dto;
    }

    @PostMapping(path = "delete_contract_key_results_areas")
    public void deleteContractKeyResultsAreas(@RequestBody ContractDTO dto)
    {
        this.contractService.deleteContractKeyResultsAreas(dto.getContractKeyResultsAreasId());
    }

    @PostMapping(path = "delete_key_results_areas_activity")
    public void deleteContractKeyResultsAreasActivity(@RequestBody ContractDTO dto)
    {
        this.contractService.deleteContractKeyResultsAreasActivity(dto.getKeyResultsAreasActivityId());
    }

    @PostMapping(path = "delete_developmental_plan")
    public void deleteDevelopmentalPlan(@RequestBody ContractDTO dto)
    {
        this.contractService.deleteDevelopmentalPlan(dto.getDevelopmentalPlanId());
    }


    @PostMapping(path = "save_contract_key_results_areas")
    public ContractDTO saveContractKeyResultsAreas(@RequestBody ContractDTO dto)
    {
        ContractKeyResultsAreas kpa = dto.getKeyResultsAreas();
        kpa.setContract( this.contractService.findContractById(dto.getContractId()) );

        dto.setKeyResultsAreas(this.contractService.saveContractKeyResultsAreas( kpa));

        return dto;
    }

    @PostMapping(path = "save_key_results_areas_activity")
    public ContractDTO saveKeyResultsAreasActivity(@RequestBody ContractDTO dto)
    {
        KeyResultsAreasActivity activity = dto.getActivity();
        activity.setKeyResultsAreas( dto.getKeyResultsAreas() );

        dto.setActivity(this.contractService.saveKeyResultsAreasActivity( activity));

        return dto;
    }

    @PostMapping(path = "save_developmental_plan")
    public ContractDTO saveDevelopmentalPlan(@RequestBody ContractDTO dto)
    {
        DevelopmentalPlan plan = dto.getDevelopmentalPlan();

        plan.setContract( this.contractService.findContractById(dto.getContractId()) );

        dto.setDevelopmentalPlan(this.contractService.saveDevelopmentalPlan( plan));

        return dto;
    }

}
