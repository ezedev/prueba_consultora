package com.inditex.demo.controller;


import com.inditex.demo.application.dto.PriceDTO;
import com.inditex.demo.infrastructure.controller.PriceController;
import com.inditex.demo.infrastructure.port.GetSpecificPriceUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.math.BigDecimal;
import java.util.Date;

@WebMvcTest(controllers = PriceController.class)
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetSpecificPriceUseCase getSpecificPriceUseCase;

    @Test
    void testGetPrice() throws Exception {
        testGetSpecificPrice("2020-06-14-10.00.00", 35455L, 1L, new BigDecimal("35.5"));
        testGetSpecificPrice("2020-06-14-16.00.00", 35455L, 1L, new BigDecimal("38.95"));
        testGetSpecificPrice("2020-06-14-21.00.00", 35455L, 1L, new BigDecimal("38.95"));
        testGetSpecificPrice("2020-06-15-10.00.00", 35455L, 1L, new BigDecimal("30.5"));
        testGetSpecificPrice("2020-06-16-21.00.00", 35455L, 1L, new BigDecimal("30.5"));
    }

    private void testGetSpecificPrice(String fecha, Long productoId, Long cadenaId, BigDecimal expectedPrice) throws Exception {
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setPrice(expectedPrice);
        Mockito.when(getSpecificPriceUseCase.execute(Mockito.anyLong(), Mockito.anyLong(), Mockito.any(Date.class))).thenReturn(priceDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/prices/specific")
                        .param("fecha", fecha)
                        .param("productoId", String.valueOf(productoId))
                        .param("cadenaId", String.valueOf(cadenaId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(expectedPrice));
    }
}
