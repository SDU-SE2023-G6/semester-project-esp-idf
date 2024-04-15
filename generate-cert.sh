#!/bin/sh


# Generate initial cert
openssl genrsa -aes256 -out ca.key 4096


# Generate root certificate
openssl req -x509 -new -nodes -key ca.key -sha256 -days 1024 -out ca.pem

# Verify the cert 
openssl x509 -in ca.pem -text -noout
