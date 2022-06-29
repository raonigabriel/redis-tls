FROM redis:7-alpine

COPY --chown=redis:redis redis.conf /usr/local/etc/redis/redis.conf
COPY --chown=redis:redis ./pki/ca.crt /usr/local/etc/redis/tls/ca.crt
COPY --chown=redis:redis ./pki/private/redis.key /usr/local/etc/redis/tls/redis.key
COPY --chown=redis:redis ./pki/issued/redis.crt /usr/local/etc/redis/tls/redis.crt

ENV REDIS_TLS_ENABLED=yes

CMD [ "redis-server", "/usr/local/etc/redis/redis.conf" ]
