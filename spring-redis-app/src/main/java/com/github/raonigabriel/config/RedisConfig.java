package com.github.raonigabriel.config;

import java.io.File;

import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration.LettuceClientConfigurationBuilder;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.SslOptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(TrustStoreProperties.class)
public class RedisConfig implements LettuceClientConfigurationBuilderCustomizer {

	private final TrustStoreProperties truststore;

	private final RedisProperties redis;

	@Override
	public void customize(LettuceClientConfigurationBuilder builder) {

		if (redis.isSsl()) {
			log.info("Using trustStore: {}", truststore.getPath());

			final SslOptions sslOptions = SslOptions.builder()
					.jdkSslProvider()
					.truststore(new File(truststore.getPath()), truststore.getPassword())
					.build();					

			final ClientOptions clientOptions = ClientOptions.builder()
					.sslOptions(sslOptions)
					.build();

			builder.clientOptions(clientOptions);
		}

	}

}
