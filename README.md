redis-tls
---
An example to demonstrate how to run redis on docker, using tls.

---
## Requirements:
* OpenSSL
* Docker Compose
---
## Usage:
Run "gen_cert.sh" to create a CA and certificates (will create a folde "./pki")
Run "docker-compose up -d"
Go to http://localhost:8081

---
## Disclaimer:
CA and certificates are created **WITHOUT** password, do not use this on production.
