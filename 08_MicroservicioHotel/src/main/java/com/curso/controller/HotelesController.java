package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Hotel;
import com.curso.service.HotelesService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * Clase controlador: HotelesController
 * @author Daniel Rodriguez
 * @version 1.0.0 02-06-2023
 */
@RestController
public class HotelesController {
	@Autowired
	HotelesService service;
	@ApiOperation(value="Devuelve una lista de hoteles")
	@GetMapping(value="hoteles",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hoteles() {
		return service.hoteles();
	}
	@ApiOperation(value="Devuelve un hotel a partir de su nombre")
	@GetMapping(value="hotel/{nombre}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Hotel buscarHotel(@PathVariable("nombre")String nombre) {
		return service.buscarHotel(nombre);
	}
	@ApiOperation(value="Actualiza un hotel pasando el id por parametro y su disponibilidad")
	@PutMapping(value="hotel/{idHotel}/{disponible}")
	public void actualizarHotel(@ApiParam("Identificador del hotel")@PathVariable("idHotel") int idHotel,@ApiParam("Disponibilidad del hotel")@PathVariable("disponible") boolean disponible) {
		service.actualizarHotel(idHotel, disponible);
	}
}
