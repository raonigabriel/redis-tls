#!/bin/bash
./easyrsa/easyrsa init-pki
./easyrsa/easyrsa build-ca nopass
./easyrsa/easyrsa --subject-alt-name="DNS:localhost,DNS:redis;DNS:redis.local.gd" build-server-full redis nopass