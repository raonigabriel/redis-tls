package com.github.raonigabriel.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.github.raonigabriel.model.City;
import com.github.raonigabriel.repository.CityRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CityService {

	private final CityRepository repo;

	@PostConstruct
	private void addSamples() {
		if (repo.count() == 0) {
			repo.save(new City("3550308", "São Paulo"));
			repo.save(new City("3304557", "Rio de Janeiro"));
			repo.save(new City("4106902", "Curitiba"));
			repo.save(new City("4104808", "Cascavel"));
		}
	}

	public final Flux<City> getAll() {
		return Flux.fromIterable(repo.findAll());
	}

	public Mono<City> getById(final String id) {
		return Mono.justOrEmpty(repo.findById(id));
	}

	public Mono<Void> deleteById(final String id) {
		return Mono.fromRunnable(() -> repo.deleteById(id));
	}
}
