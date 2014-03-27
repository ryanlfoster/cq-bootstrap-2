#!/bin/bash

curl -u $bamboo_crx_user:$bamboo_crx_password -F name=uk.co.smithstone.ecommerce.web -F install=true -F file=@web/target/web-1.0-SNAPSHOT.zip $bamboo_host_ip/$bamboo_crx_url
curl -u $bamboo_crx_user:$bamboo_crx_password -F name=uk.co.smithstone.ecommerce.web.cq -F install=true -F file=@web-cq/target/web-cq-1.0-SNAPSHOT.zip $bamboo_host_ip/$bamboo_crx_url
curl -u $bamboo_crx_user:$bamboo_crx_password -F name=uk.co.smithstone.ecommerce.web.js -F install=true -F file=@web-js/target/web-js-1.0-SNAPSHOT.zip $bamboo_host_ip/$bamboo_crx_url

