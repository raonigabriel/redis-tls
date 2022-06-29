package com.github.raonigabriel.config;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Validated
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "truststore")
public class TrustStoreProperties {

	/**
	 * Required: The truststore type
	 */
	@NotNull
	private final StoreType type;

	/**
	 * Required: The truststore path
	 */
	@NotBlank
	private final String path;

	/**
	 * Optional: The truststore password
	 */
	private final String password;

	public enum StoreType {
		JKS,
		PKCS12
	}

}
