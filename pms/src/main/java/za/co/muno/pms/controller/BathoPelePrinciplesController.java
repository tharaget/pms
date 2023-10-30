package za.co.muno.pms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.muno.pms.entity.BathoPelePrinciples;
import za.co.muno.pms.service.BathoPelePrinciplesService;

import java.util.List;

@RestController
@RequestMapping("api/batho_pele_principles")
@CrossOrigin("*")
public class BathoPelePrinciplesController {
    private final BathoPelePrinciplesService bathoPelePrinciplesService;

    public BathoPelePrinciplesController(BathoPelePrinciplesService bathoPelePrinciplesService)
    {
        this.bathoPelePrinciplesService = bathoPelePrinciplesService;
    }

    @GetMapping
    public List<BathoPelePrinciples> findAll()
    {
        return this.bathoPelePrinciplesService.findAll();
    }
}
