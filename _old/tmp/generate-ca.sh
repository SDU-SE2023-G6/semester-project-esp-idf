
# Generate the private keyof the CA with a password of 1234
openssl genrsa -out rootCAKey.pem 2048

# Generate the self signed root CA 
openssl req -x509 -sha256 -new -nodes -key rootCAKey.pem -days 3650 -out rootCACert.pem

openssl x509 -in rootCACert.pem -text
