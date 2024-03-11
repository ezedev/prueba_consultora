package com.inditex.demo.infrastructure.controller;

import com.inditex.demo.application.dto.PriceDTO;
import com.inditex.demo.infrastructure.port.GetSpecificPriceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@RestController
@RequestMapping("/prices")
public class PriceController {

    private final GetSpecificPriceUseCase getSpecificPrice;

    @GetMapping("/specific")
    public ResponseEntity<PriceDTO> ordenarProductosPorCriterioYPeso(
            @RequestParam("fecha") String fecha,
            @RequestParam("productoId") Long productoId,
            @RequestParam("cadenaId") Long cadenaId
    ) {
        PriceDTO priceDTO = getSpecificPrice.execute(productoId, cadenaId, this.parseFecha(fecha));
        if (priceDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(priceDTO, HttpStatus.OK);
    }

    private Date parseFecha(String fecha) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
            return dateFormat.parse(fecha);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Error al parsear la fecha: " + fecha, e);
        }
    }
}
