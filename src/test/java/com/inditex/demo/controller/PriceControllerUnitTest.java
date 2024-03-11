package com.inditex.demo.controller;

import com.inditex.demo.application.dto.PriceDTO;
import com.inditex.demo.infrastructure.controller.PriceController;
import com.inditex.demo.infrastructure.port.GetSpecificPriceUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceControllerUnitTest {

    @InjectMocks
    PriceController priceController;

    @Mock
    GetSpecificPriceUseCase getSpecificPrice;


    @Test
    void testOrdenarProductosPorCriterioYPeso_WithValidData() throws ParseException {
        Long productoId = 35455L;
        Long cadenaId = 1L;
        String fecha = "2020-06-14-10.00.00";
        Date parsedFecha = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").parse(fecha);
        PriceDTO expectedPriceDTO = new PriceDTO();
        when(getSpecificPrice.execute(productoId, cadenaId, parsedFecha)).thenReturn(expectedPriceDTO);

        ResponseEntity<PriceDTO> responseEntity = priceController.ordenarProductosPorCriterioYPeso(fecha, productoId, cadenaId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedPriceDTO, responseEntity.getBody());
    }

    @Test
    void testOrdenarProductosPorCriterioYPeso_WithNotFound() throws ParseException {
        Long productoId = 35455L;
        Long cadenaId = 1L;
        String fecha = "2020-06-14-10.00.00";
        Date parsedFecha = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").parse(fecha);

        when(getSpecificPrice.execute(productoId, cadenaId, parsedFecha)).thenReturn(null);

        ResponseEntity<PriceDTO> responseEntity = priceController.ordenarProductosPorCriterioYPeso(fecha, productoId, cadenaId);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}
