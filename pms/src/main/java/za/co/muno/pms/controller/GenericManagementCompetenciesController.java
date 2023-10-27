package za.co.muno.pms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.muno.pms.entity.BathoPelePrinciples;
import za.co.muno.pms.entity.GenericManagementCompetencies;
import za.co.muno.pms.service.GenericManagementCompetenciesService;

import java.util.List;

@RestController
@RequestMapping("api/competencies")
@CrossOrigin("*")
public class GenericManagementCompetenciesController
{
    private final GenericManagementCompetenciesService genericManagementCompetenciesService;

    public GenericManagementCompetenciesController(GenericManagementCompetenciesService genericManagementCompetenciesService) {
        this.genericManagementCompetenciesService = genericManagementCompetenciesService;
    }

    @GetMapping
    public List<GenericManagementCompetencies> findAll()
    {
        return this.genericManagementCompetenciesService.findAll();
    }
}
