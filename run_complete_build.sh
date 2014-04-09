#!/bin/bash
mvn clean install && cd web-tests && mvn clean verify -Dtest.host.servername=localhost -Dtest.host.port=9999 -Dtest.host.context=/ && cd ..
