cq-bootstrap
============

CQ Bootstrap

Why
----
On current cq projects there is a lot of duplicate work with front end being done outside of CQ due to the nature of the work,
and then there is round of effort to take the front end code and integrate it into CQ templates/components, so this bootstrap is
here to allows front end developers to code using a light weight jee container into the structure needed by cq and then the developer
can provide namespace tags to include into the components to allow them to run both inside CQ using the necessary CQ code and outside
in the container using fakes that represent state the application is going to be in.


Modules
----

### domain
This is just plain old java objects base classes for the domain, interfaces for the UI and Model, in this module
there should be reference to anything to do with the web or cq or sling.

### domain-cq
This is the implementation of domain interfaces that encapsulate how to get model,ui elements from the
jcr, this can contain jcr code.

### domain-web
This is the implementation of the domain which is just concerned with the web tier , no sling ,cq.


## web
This is the views for the web using jsp , jstl, tag files, there so be no scriplets in the pages
no importing of cq or sling , the idea behind this module is that it will be merged with the web-cq
module for deployment inside of cq.

## web-cq
This for the cq components contains files like .content.xml , dialog.xml and the main cq components which
should include cq objects but then loads in the web jsps that are merged using script include.

## web-tags
This is a module for creating the domain and populating the jsps with the objects for use in jstl,
this module should not include cq, sling just web and domain most of the, this module uses the
osgi classpath to determine which factories to use.

## web-cq-tags
This module is for cq versions of the factories used by web-tags, this should contain cq , sling code and
the interfaces from the web-tags, domain.


## web-js
This module contains the javascript and is to merged into the design of cq, its
a seperate module to not confuse frontend developers.


## web-tests
This is a module that is used to create the application outside of CQ, it uses the resources
from domain, domain-web, web, web-tags, web-js anything that does not contain cq, and runs
inside of the lightweight jetty server with the same path structure as CQ, it runs the javascript
tests using karma and can test the views, the idea here is to create the ui in a state that can be automated
tested, using fakes we can setup components into different states without use interaction.


Building
----

From the top level directory running maven package will compile all the submodules
with tests.

to test the javascript and live components you need to drop inside of web-tests and

`sh run-karma.sh`

this in turn with fire up the jetty server and then run the jasmine test suite using phantomjs.

inside of web-tests you can run jetty using
`mvn jetty:run`
and then fire up a browser and see the site running using fakes that use live components.

Intellij
----

This project also supports development in intellij simple open the top level pom and this should create the structure needed,
you will then need a jetty server configured on port 9999 using jvm option -Djetty.port=9999 with the web-tests artifact deployed with custom context of /web-tests
once that is up and running you can browse to http://localhost:9999/web-tests/fixtures/<file>.jsp and you can then also configure a karma running using the
karma module that npm install will download and use the karma-conf.js as the configuration
