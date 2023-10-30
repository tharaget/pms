package za.co.muno.pms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.muno.pms.entity.Cycle;
import za.co.muno.pms.service.CycleService;

import java.util.List;

@RestController
@RequestMapping("api/cycle")
@CrossOrigin("*")
public class CycleController
{
    private final CycleService cycleService;

    public CycleController(CycleService cycleService) {
        this.cycleService = cycleService;
    }

    @GetMapping
    public List<Cycle> findAll()
    {
        return this.cycleService.findAll();
    }

}
