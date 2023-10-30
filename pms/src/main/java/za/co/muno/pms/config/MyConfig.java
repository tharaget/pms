package za.co.muno.pms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.muno.pms.entity.*;
import za.co.muno.pms.repository.AccountRepository;
import za.co.muno.pms.repository.BathoPelePrinciplesRepository;
import za.co.muno.pms.repository.CycleRepository;
import za.co.muno.pms.repository.GenericManagementCompetenciesRepository;

@Configuration
public class MyConfig
{
    private final AccountRepository accountRepository;
    private final CycleRepository cycleRepository;
    private final BathoPelePrinciplesRepository bathoPelePrinciplesRepository;
    private final GenericManagementCompetenciesRepository genericManagementCompetenciesRepository;

    public MyConfig(AccountRepository accountRepository,
                    CycleRepository cycleRepository,
                    BathoPelePrinciplesRepository bathoPelePrinciplesRepository,
                    GenericManagementCompetenciesRepository genericManagementCompetenciesRepository) {
        this.accountRepository = accountRepository;
        this.cycleRepository = cycleRepository;
        this.bathoPelePrinciplesRepository = bathoPelePrinciplesRepository;
        this.genericManagementCompetenciesRepository = genericManagementCompetenciesRepository;
    }

    @Bean
    public void initializeDB()
    {
//        Cycle cycle = new Cycle(2022,false);
//        this.cycleRepository.save(cycle);
//        cycle = new Cycle(2023,true);
//        this.cycleRepository.save(cycle);
//
//        Account account = new Account("2001","password","Mr. Tharage TG");
//        this.accountRepository.save(account);
//        account = new Account("2002","password","Mr. Tharage RR");
//        this.accountRepository.save(account);
//
//        BathoPelePrinciples principles = new BathoPelePrinciples("Consultation");
//        this.bathoPelePrinciplesRepository.save(principles);
//        principles = new BathoPelePrinciples("Service standards");
//        this.bathoPelePrinciplesRepository.save(principles);
//        principles = new BathoPelePrinciples("Redress");
//        this.bathoPelePrinciplesRepository.save(principles);
//        principles = new BathoPelePrinciples("Access");
//        this.bathoPelePrinciplesRepository.save(principles);
//        principles = new BathoPelePrinciples("Courtesy");
//        this.bathoPelePrinciplesRepository.save(principles);
//        principles = new BathoPelePrinciples("Information");
//        this.bathoPelePrinciplesRepository.save(principles);
//        principles = new BathoPelePrinciples("Openness and transparency");
//        this.bathoPelePrinciplesRepository.save(principles);
//        principles = new BathoPelePrinciples("Value for money");
//        this.bathoPelePrinciplesRepository.save(principles);
//
//        GenericManagementCompetencies competencies = new GenericManagementCompetencies(CompetencyType.CORE_MANAGEMENT,"Strategic Capability and Leadership" );
//        this.genericManagementCompetenciesRepository.save(competencies);
//        competencies = new GenericManagementCompetencies(CompetencyType.CORE_MANAGEMENT,"People Management and empowerment" );
//        this.genericManagementCompetenciesRepository.save(competencies);
//        competencies = new GenericManagementCompetencies(CompetencyType.CORE_MANAGEMENT,"Programme and Project Management" );
//        this.genericManagementCompetenciesRepository.save(competencies);
//        competencies = new GenericManagementCompetencies(CompetencyType.CORE_MANAGEMENT,"Financial Management" );
//        this.genericManagementCompetenciesRepository.save(competencies);
//        competencies = new GenericManagementCompetencies(CompetencyType.CORE_MANAGEMENT,"Change Management" );
//        this.genericManagementCompetenciesRepository.save(competencies);
//
//
//        competencies = new GenericManagementCompetencies(CompetencyType.PROCESS,"Knowledge management" );
//        this.genericManagementCompetenciesRepository.save(competencies);
//        competencies = new GenericManagementCompetencies(CompetencyType.PROCESS,"Problem solving and analysis" );
//        this.genericManagementCompetenciesRepository.save(competencies);
//        competencies = new GenericManagementCompetencies(CompetencyType.PROCESS,"Service Delivery Innovation" );
//        this.genericManagementCompetenciesRepository.save(competencies);
//        competencies = new GenericManagementCompetencies(CompetencyType.PROCESS,"Communication" );
//        this.genericManagementCompetenciesRepository.save(competencies);
//        competencies = new GenericManagementCompetencies(CompetencyType.PROCESS,"Client Orientation and customer focus" );
//        this.genericManagementCompetenciesRepository.save(competencies);
    }
}
