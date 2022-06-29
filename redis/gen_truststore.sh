#!/bin/bash
keytool -noprompt -import -trustcacerts -file ./pki/ca.crt -alias Easy-RSA -storepass changeit -storetype jks -keystore truststore.jks