#!/bin/sh

# INICIAR APLICACIÓN JAVA
java -jar distribuidora-bebidas-0.0.1-SNAPSHOT.jar &

# INICIAR NGINX
nginx -g "daemon off;"