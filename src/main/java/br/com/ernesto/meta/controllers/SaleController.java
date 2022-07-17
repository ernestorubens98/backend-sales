package br.com.ernesto.meta.controllers;

import br.com.ernesto.meta.entities.Sale;
import br.com.ernesto.meta.services.SaleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro inesperado")
    })
    @ApiOperation(value = "Busca todas a vendas no intervalo informado.")
    public Page<Sale> findAllSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            @PageableDefault(page = 0, size=10) Pageable pageable) {
        return service.findSales(minDate, maxDate, pageable);
    }
}
