package com.github.raonigabriel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RedisHash
@RequiredArgsConstructor
public class City {

	@Id
	@NonNull
	private final String id;

	@NonNull
	private final String name;

}
