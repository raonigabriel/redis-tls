package com.github.raonigabriel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.raonigabriel.model.City;
import com.github.raonigabriel.service.CityService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

	private final CityService service;

	@GetMapping
	public Flux<City> getAll() {
		return service.getAll()
				.onErrorMap(this::internalServerError);
	}

	@GetMapping(path = "/{id}")
	public Mono<City> getById(@PathVariable("id") final String id) {
		return service.getById(id)
				.onErrorMap(this::internalServerError)
				.switchIfEmpty(Mono.error(this::notFound));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteById(@PathVariable("id") final String id) {
		return service.deleteById(id)
				.onErrorMap(this::internalServerError);
	}

	private ResponseStatusException notFound() {
		return new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	private ResponseStatusException internalServerError(final Throwable ex) {
		log.error("Failure: ", ex);
		return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
