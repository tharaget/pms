package za.co.muno.pms.service;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import za.co.muno.pms.entity.*;
import za.co.muno.pms.repository.*;

import java.util.*;

@Service
public class ContractService
{
    private final ContractRepository contractRepository;
    private final CycleRepository cycleRepository;

    private final IndividualKPARepository individualKPARepository;

    private final GenericManagementCompetenciesRepository genericManagementCompetenciesRepository;

    private final ContractCompetencyRepository contractCompetencyRepository;

    private final NoteRepository noteRepository;

    private final ContractKeyResultsAreasRepository contractKeyResultsAreasRepository;

    private final KeyResultsAreasActivityRepository keyResultsAreasActivityRepository;

    private final DevelopmentalPlanRepository developmentalPlanRepository;

    private final BathoPelePrinciplesRepository bathoPelePrinciplesRepository;

    private final KPABathoPelePrinciplesRepository kpaBathoPelePrinciplesRepository;

    public ContractService(ContractRepository contractRepository,
                           CycleRepository cycleRepository, IndividualKPARepository individualKPARepository, GenericManagementCompetenciesRepository genericManagementCompetenciesRepository, ContractCompetencyRepository contractCompetencyRepository, NoteRepository noteRepository, ContractKeyResultsAreasRepository contractKeyResultsAreasRepository, KeyResultsAreasActivityRepository keyResultsAreasActivityRepository, DevelopmentalPlanRepository developmentalPlanRepository, BathoPelePrinciplesRepository bathoPelePrinciplesRepository, KPABathoPelePrinciplesRepository kpaBathoPelePrinciplesRepository) {
        this.contractRepository = contractRepository;
        this.cycleRepository = cycleRepository;
        this.individualKPARepository = individualKPARepository;
        this.genericManagementCompetenciesRepository = genericManagementCompetenciesRepository;
        this.contractCompetencyRepository = contractCompetencyRepository;
        this.noteRepository = noteRepository;
        this.contractKeyResultsAreasRepository = contractKeyResultsAreasRepository;
        this.keyResultsAreasActivityRepository = keyResultsAreasActivityRepository;
        this.developmentalPlanRepository = developmentalPlanRepository;
        this.bathoPelePrinciplesRepository = bathoPelePrinciplesRepository;
        this.kpaBathoPelePrinciplesRepository = kpaBathoPelePrinciplesRepository;
    }

    public List<Contract> findContractByAccount(Account account)
    {
        return this.contractRepository.findContractByAccount( account );
    }

    public List<Contract> findContractByAccountSupervisorPersonalNumber( String supervisorPersonalNumber )
    {
        return this.contractRepository.findContractByAccount_SupervisorPersonalNumber( supervisorPersonalNumber );
    }

    public Contract findContractById(Long id)
    {
        Optional<Contract> optionalContract = this.contractRepository.findContractById(id);

        if( optionalContract.isEmpty() )
        {
            throw new NoSuchElementException("Contract not found");
        } else {
            return optionalContract.get();
        }
    }


    public Contract createNewContract( Account account )
    {
        Cycle cycle =  this.cycleRepository.findByAllowCreate(true);
        Contract contract = null;
        if(cycle != null )
        {
            contract = this.contractRepository.findByCycleAndAccount_PersonalNumber(cycle, account.getPersonalNumber());
            if( contract == null )
            {
                contract = new Contract();
                contract.setAccount(account);
                contract.setCreatedDate(new Date());
                contract.setCycle( cycle );
                contract.setStatus( PMSStatus.SAVED );
                contract = this.contractRepository.save( contract );


                IndividualKPA individualKPA = new IndividualKPA("Improving provision of clinical services and related outcomes ",30,new Date(), contract);
                individualKPARepository.save(individualKPA);

                individualKPA.setKpaBathoPelePrinciples(new ArrayList<>());

                BathoPelePrinciples bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Access");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Information");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Consultation");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Openness and transparency");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                kpaBathoPelePrinciplesRepository.saveAll(individualKPA.getKpaBathoPelePrinciples());


                individualKPA = new IndividualKPA("Implementation of NHI",30,new Date(), contract);
                individualKPARepository.save(individualKPA);
                individualKPA.setKpaBathoPelePrinciples(new ArrayList<>());

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Access");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Information");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Consultation");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Openness and transparency");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                kpaBathoPelePrinciplesRepository.saveAll(individualKPA.getKpaBathoPelePrinciples());

                individualKPA = new IndividualKPA("Improved Human Resource Management\n",15,new Date(), contract);
                individualKPARepository.save(individualKPA);

                individualKPA.setKpaBathoPelePrinciples(new ArrayList<>());

                 bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Access");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Information");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Consultation");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Openness and transparency");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                kpaBathoPelePrinciplesRepository.saveAll(individualKPA.getKpaBathoPelePrinciples());

                individualKPA = new IndividualKPA("Effective cooperate governance and leadership",10,new Date(), contract);
                individualKPARepository.save(individualKPA);

                individualKPA.setKpaBathoPelePrinciples(new ArrayList<>());

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Access");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Information");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Consultation");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Openness and transparency");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                kpaBathoPelePrinciplesRepository.saveAll(individualKPA.getKpaBathoPelePrinciples());

                individualKPA = new IndividualKPA("Improved Financial and Supply Chain management ",15,new Date(), contract);
                individualKPARepository.save(individualKPA);

                individualKPA.setKpaBathoPelePrinciples(new ArrayList<>());

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Access");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Information");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Consultation");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                bathoPelePrinciples = bathoPelePrinciplesRepository.findByName("Openness and transparency");
                individualKPA.getKpaBathoPelePrinciples().add(new KPABathoPelePrinciples(bathoPelePrinciples,individualKPA));

                kpaBathoPelePrinciplesRepository.saveAll(individualKPA.getKpaBathoPelePrinciples());

                GenericManagementCompetencies competencies = genericManagementCompetenciesRepository.findByNameAndType("Strategic Capability and Leadership", CompetencyType.CORE_MANAGEMENT);
                ContractCompetency competency = new ContractCompetency(contract, competencies);
                contractCompetencyRepository.save(competency);


                competencies = genericManagementCompetenciesRepository.findByNameAndType("Strategic Capability and Leadership", CompetencyType.CORE_MANAGEMENT);
                competency = new ContractCompetency(contract, competencies);
                contractCompetencyRepository.save(competency);

                competencies = genericManagementCompetenciesRepository.findByNameAndType("Financial Management", CompetencyType.CORE_MANAGEMENT);
                competency = new ContractCompetency(contract, competencies);
                contractCompetencyRepository.save(competency);


                competencies = genericManagementCompetenciesRepository.findByNameAndType("Knowledge management", CompetencyType.PROCESS);
                competency = new ContractCompetency(contract, competencies);
                contractCompetencyRepository.save(competency);


                competencies = genericManagementCompetenciesRepository.findByNameAndType("Communication ", CompetencyType.PROCESS);
                competency = new ContractCompetency(contract, competencies);
                contractCompetencyRepository.save(competency);



                ContractKeyResultsAreas resultsAreas =
                        new ContractKeyResultsAreas("Improved maternal, infant and child health and well being",contract);
                contractKeyResultsAreasRepository.save(resultsAreas);

                KeyResultsAreasActivity activity = new KeyResultsAreasActivity("Operationalize ward 23 as a Maternity High care",100L,"% of beds operational", "September 2023","Advance midwifes/ Pns X 6, MOx4","Approval and funding for critical list",resultsAreas);
                keyResultsAreasActivityRepository.save( activity );
                activity = new KeyResultsAreasActivity("Operationalize two maternity ICU beds",100L,"2 ICU beds operational", "September 2023","Nurses X 4, Ens X 4","Approval and funding for critical list",resultsAreas);
                keyResultsAreasActivityRepository.save( activity );
                activity = new KeyResultsAreasActivity("Reduce maternal mortality in fatality ratio",53L,"Maternal mortality in facility ratio", "Annual","","",resultsAreas);
                keyResultsAreasActivityRepository.save( activity );


                resultsAreas =
                        new ContractKeyResultsAreas("Death of children under 5 years of diarrheal disease is reduced",contract);
                contractKeyResultsAreasRepository.save(resultsAreas);

                activity = new KeyResultsAreasActivity("Reduced Child under 5 case fatality ratio; Diarrhea, Pneumonia, Malnutrition",12L,"Child under 5 case fatality rate", "Annual","","",resultsAreas);
                keyResultsAreasActivityRepository.save( activity );
                activity = new KeyResultsAreasActivity("Implementation of CHIP/PIPP programmes",100L,"100% in Neonatal ward", "June 2023","ICT Software","",resultsAreas);
                keyResultsAreasActivityRepository.save( activity );
                activity = new KeyResultsAreasActivity("Commissioning of Paediatric Casualty",100L,"100% Paediatric Casualty functional", "January 2024, 2023","25 PN, 15 EN, 15 ENAS, 5 interns, 8 Medical Officers, 1 Specialist","Approval and funding for critical list",resultsAreas);
                keyResultsAreasActivityRepository.save( activity );

                resultsAreas =
                        new ContractKeyResultsAreas("Death of children under 5 years in health facilities is reduced",contract);
                contractKeyResultsAreasRepository.save(resultsAreas);

                activity = new KeyResultsAreasActivity("Creation of additional neonatal beds at kopanong hospital",100L,"8 beds", "September 2023","Pn X10, EN X8, ENA X8, MO X2","Complexity of Sebokeng and kopanong hospitals",resultsAreas);
                keyResultsAreasActivityRepository.save( activity );

                DevelopmentalPlan plan = new DevelopmentalPlan("Policy Development", DevelopmentalPlanType.COURSE, "September 2023", contract);
                developmentalPlanRepository.save(plan);
                plan = new DevelopmentalPlan("Knowledge of SLAs", DevelopmentalPlanType.WORKSHOP, "January 2024", contract);
                developmentalPlanRepository.save(plan);

            }
        }

        System.out.println(contract);

        return contract;
    }


    public void deleteKpaBathoPelePrinciple( Long kpaBathoPelePrinciplesId)
    {
        kpaBathoPelePrinciplesRepository.deleteById(kpaBathoPelePrinciplesId);
    }


    public KPABathoPelePrinciples saveKpaBathoPelePrinciple( IndividualKPA kpa, BathoPelePrinciples bathoPelePrinciples)
    {
        if( kpaBathoPelePrinciplesRepository.findByBathoPelePrinciplesAndAndKpa(bathoPelePrinciples,kpa).isPresent())
        {
            throw new DuplicateKeyException("Already inserted");
        }

        KPABathoPelePrinciples principles = new KPABathoPelePrinciples(bathoPelePrinciples,kpa);
        return kpaBathoPelePrinciplesRepository.save(principles);
    }

    public IndividualKPA saveIndividualKPA( IndividualKPA kpa )
    {
        Optional<IndividualKPA> foundKPA = individualKPARepository.findById( kpa.getId() );
        if( foundKPA.isPresent())
        {
            IndividualKPA oldKPA = foundKPA.get();
            oldKPA.setName( kpa.getName() );
            oldKPA.setWeight( kpa.getWeight() );
            return individualKPARepository.save(oldKPA);
        } else
        {
            return individualKPARepository.save(kpa);
        }
    }

    public ContractKeyResultsAreas saveContractKeyResultsAreas( ContractKeyResultsAreas kpa )
    {
        Optional<ContractKeyResultsAreas> foundKPA = contractKeyResultsAreasRepository.findById( kpa.getId() );
        if( foundKPA.isPresent())
        {
            ContractKeyResultsAreas oldKPA = foundKPA.get();
            oldKPA.setDescription( kpa.getDescription() );
            return contractKeyResultsAreasRepository.save(oldKPA);
        } else
        {
            return contractKeyResultsAreasRepository.save(kpa);
        }
    }


    public KeyResultsAreasActivity saveKeyResultsAreasActivity( KeyResultsAreasActivity activity )
    {
        Optional<KeyResultsAreasActivity> foundActivity = keyResultsAreasActivityRepository.findById( activity.getId() );
        if( foundActivity.isPresent())
        {
            KeyResultsAreasActivity oldActivity = foundActivity.get();
            oldActivity.setDescription(activity.getDescription());
            oldActivity.setIndicator(activity.getIndicator());
            oldActivity.setEnablingCondition(activity.getEnablingCondition());
            oldActivity.setResourceRequired(activity.getResourceRequired());
            oldActivity.setTarget(activity.getTarget());
            oldActivity.setTargetDate(activity.getTargetDate());

            return keyResultsAreasActivityRepository.save(oldActivity);
        } else
        {
            return keyResultsAreasActivityRepository.save(activity);
        }
    }

    public DevelopmentalPlan saveDevelopmentalPlan( DevelopmentalPlan plan )
    {
        Optional<DevelopmentalPlan> foundPlan = developmentalPlanRepository.findById( plan.getId() );
        if( foundPlan.isPresent())
        {
            DevelopmentalPlan oldPlan = foundPlan.get();
            oldPlan.setDescription( plan.getDescription() );
            oldPlan.setType( plan.getType());
            oldPlan.setTargetedDate( plan.getTargetedDate());
            return developmentalPlanRepository.save(oldPlan);
        } else
        {
            return developmentalPlanRepository.save(plan);
        }
    }

    public void deleteKpa( Long id)
    {
        individualKPARepository.deleteById(id);
    }


    public void deleteContractCompetency(Long contractCompetencyId)
    {
        contractCompetencyRepository.deleteById(contractCompetencyId);
    }

    public void deleteContractKeyResultsAreas( Long id)
    {
        this.contractKeyResultsAreasRepository.deleteById(id);
    }

    public void deleteContractKeyResultsAreasActivity( Long id)
    {
        this.keyResultsAreasActivityRepository.deleteById(id);
    }

    public void deleteDevelopmentalPlan( Long id)
    {
        this.developmentalPlanRepository.deleteById(id);
    }

    public Contract updateContractStatus( Long contractId, PMSStatus status)
    {
        Contract contract = null;

        Optional<Contract> optionalContract = this.contractRepository.findContractById(contractId);
        if( optionalContract.isPresent() )
        {
            contract = optionalContract.get();
            contract.setStatus( status );
            this.contractRepository.save(contract);
        } else {
            throw new NoSuchElementException("Contract not found");
        }
        return contract;
    }

    public Note createNotes( Account account, String comment , Contract contract, PMSStatus status )
    {
        Note note = new Note();
        note.setContract(contract);
        note.setCreatedBy( account );
        note.setDescription(comment);
        note.setCreatedDate(new Date());
        note.setStatus(status);
        note = this.noteRepository.save( note );

        return note;
    }
}
