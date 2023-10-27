package za.co.muno.pms.service;

import org.springframework.stereotype.Service;
import za.co.muno.pms.entity.Cycle;
import za.co.muno.pms.repository.CycleRepository;

import java.util.List;

@Service
public class CycleService
{
    private final CycleRepository cycleRepository;

    public CycleService(CycleRepository cycleRepository) {
        this.cycleRepository = cycleRepository;
    }

    public List<Cycle> findAll()
    {
        return this.cycleRepository.findAll();
    }
}
