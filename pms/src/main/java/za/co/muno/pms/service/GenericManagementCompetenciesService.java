package za.co.muno.pms.service;

import org.springframework.stereotype.Service;
import za.co.muno.pms.entity.GenericManagementCompetencies;
import za.co.muno.pms.repository.GenericManagementCompetenciesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenericManagementCompetenciesService
{
    private final GenericManagementCompetenciesRepository genericManagementCompetenciesRepository;

    public GenericManagementCompetenciesService(GenericManagementCompetenciesRepository genericManagementCompetenciesRepository) {
        this.genericManagementCompetenciesRepository = genericManagementCompetenciesRepository;
    }

    public List<GenericManagementCompetencies> findAll()
    {
        return this.genericManagementCompetenciesRepository.findAll();
    }

    public GenericManagementCompetencies findById( Long id)
    {
        Optional<GenericManagementCompetencies> optional = this.genericManagementCompetenciesRepository.findById(id);

        if( optional.isPresent() )
        {
            return optional.get();
        } else
        {
            throw new IllegalArgumentException("Could not find Generic Management Competencies");
        }


    }
}
