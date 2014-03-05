cq-bootstrap
============

CQ Bootstrap


Building
----

From the top level directory running maven package will compile all the submodules
with tests.

to test the javascript and live components you need to drop inside of web-tests and

`sh run-karma.sh`

this in turn with fire up the jetty server and then run the jasmine test suite using phantomjs

Intellij
----

This project also supports development in intellij simple open the top level pom and this should create the structure needed,
you will then need a jetty server configured on port 9999 using jvm option -Djetty.port=9999 with the web-tests artifact deployed with custom context of /web-tests
once that is up and running you can browse to http://localhost:9999/web-tests/fixtures/<file>.jsp and you can then also configure a karma running using the
karma module that npm install will download and use the karma-conf.js as the configuration
