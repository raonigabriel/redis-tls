#!/bin/bash
./easyrsa/easyrsa init-pki
./easyrsa/easyrsa build-ca nopass
./easyrsa/easyrsa gen-req redis nopass
./easyrsa/easyrsa sign-req server redis