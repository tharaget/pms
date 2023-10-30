package za.co.muno.pms.service;

import org.springframework.stereotype.Service;
import za.co.muno.pms.entity.BathoPelePrinciples;
import za.co.muno.pms.repository.BathoPelePrinciplesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BathoPelePrinciplesService
{
    private final BathoPelePrinciplesRepository bathoPelePrinciplesRepository;

    public BathoPelePrinciplesService(BathoPelePrinciplesRepository bathoPelePrinciplesRepository) {
        this.bathoPelePrinciplesRepository = bathoPelePrinciplesRepository;
    }

    public List<BathoPelePrinciples> findAll()
    {
        return this.bathoPelePrinciplesRepository.findAll();
    }

    public Optional<BathoPelePrinciples> findById(Long id )
    {
        return this.bathoPelePrinciplesRepository.findById(id);
    }
}
