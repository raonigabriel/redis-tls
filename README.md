redis-tls
---
An example to demonstrate how to run redis on docker, using tls.

---
## Requirements:
- OpenSSL
- Docker Compose
---
## Usage:
- Go to "redis folder then run **"gen_cert.sh"** to create a CA and certificates, just hit **ENTER** till it finishes. This will create a folder **"./pki"**.

- After that, run **"gen_truststore.sh"** to create a CA and certificates, just hit **ENTER** till it finishes. This will create a file **"truststore.jks"**.

- On the root folder, run "docker-compose up -d"

- Access http://localhost:8081 (redis-commander)

- Go to "spring-redis-app" folder and run the spring boot app: ```./mvnw spring-boot:run```

---
## Disclaimer:
- CA and certificates are created **WITHOUT** password, do not use this on production.
- Redis password: 3zjZM?%#y8X#Wv@nEHuh
- CA and certificates are genenrated using [easy-rsa](https://github.com/OpenVPN/easy-rsa) script.
