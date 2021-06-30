package com.live.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.live.model.JornadaTrabalho;
import com.live.service.JornadaTrabalhoService;

@WebMvcTest
public class JornadaTrabalhoControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private JornadaTrabalhoService jornadaTrabalhoService;
	
	@Test
	void createJornadaTest() throws Exception{
		
		JornadaTrabalho jornadaTest = JornadaTrabalho.builder().id(1L).descricao("40 hrs semanais").build();
		
		//given
		Mockito.
			when(jornadaTrabalhoService.save(Mockito.any(JornadaTrabalho.class))).
			thenReturn(jornadaTest);
		
		String exampleJson = "{\"id\": 1, \"descricao\": \"40 horas\"}";
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.
				post("/jornada").
				accept(MediaType.APPLICATION_JSON).content(exampleJson).
				contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		System.out.println(response.getContentAsString());
		
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
	
	}
}

	
	
	