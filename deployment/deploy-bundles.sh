#!/bin/bash


mvn org.apache.sling:maven-sling-plugin:install-file -Dsling.file=domain/target/domain-1.0-SNAPSHOT.jar -Dsling.url=$bamboo_host_ip/$bamboo_sling_url -Dsling.user=$bamboo_sling_user -Dsling.password=$bamboo_sling_password -Dsling.usePut=true
mvn org.apache.sling:maven-sling-plugin:install-file -Dsling.file=domain-cq/target/domain-cq-1.0-SNAPSHOT.jar -Dsling.url=$bamboo_host_ip/$bamboo_sling_url -Dsling.user=$bamboo_sling_user -Dsling.password=$bamboo_sling_password -Dsling.usePut=true
mvn org.apache.sling:maven-sling-plugin:install-file -Dsling.file=domain-web/target/domain-web-1.0-SNAPSHOT.jar -Dsling.url=$bamboo_host_ip/$bamboo_sling_url -Dsling.user=$bamboo_sling_user -Dsling.password=$bamboo_sling_password -Dsling.usePut=true
mvn org.apache.sling:maven-sling-plugin:install-file -Dsling.file=web-tags/target/web-tags-1.0-SNAPSHOT.jar -Dsling.url=$bamboo_host_ip/$bamboo_sling_url -Dsling.user=$bamboo_sling_user -Dsling.password=$bamboo_sling_password -Dsling.usePut=true
mvn org.apache.sling:maven-sling-plugin:install-file -Dsling.file=web-cq-tags/target/web-cq-tags-1.0-SNAPSHOT.jar -Dsling.url=$bamboo_host_ip/$bamboo_sling_url -Dsling.user=$bamboo_sling_user -Dsling.password=$bamboo_sling_password -Dsling.usePut=true


