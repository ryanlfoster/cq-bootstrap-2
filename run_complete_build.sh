#!/bin/bash
mvn clean install -Djava.awt.headless=true -q && cd web-tests && mvn clean verify -Djava.awt.headless=true -Dtest.host.servername=localhost -Dtest.host.port=9999 -Dtest.host.context=/ -q && cd ..
