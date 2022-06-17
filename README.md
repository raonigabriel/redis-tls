redis-tls
---
An example to demonstrate how to run redis on docker, using tls.

---
## Requirements:
- OpenSSL
- Docker Compose
---
## Usage:
- Run **"gen_cert.sh"** to create a CA and certificates, just hit **ENTER** till it finishes. This will create a folder **"./pki"**.

- Run "docker-compose up -d"

- Access http://localhost:8081

---
## Disclaimer:
- CA and certificates are created **WITHOUT** password, do not use this on production.
- Redis password: 3zjZM?%#y8X#Wv@nEHuh
- CA and certificates are genenrated using [easy-rsa](https://github.com/OpenVPN/easy-rsa) script.
