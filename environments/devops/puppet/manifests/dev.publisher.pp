node 'publisher1.smithstone.local' {
  include apt


  include apt::update

  apt::ppa { 'ppa:webupd8team/java': }
  ->
  package { "vim" : ensure => 'present'  }
  ->
  package { "nano" : ensure => 'absent' }
  ->
  package { "tmux" : ensure => 'present'}

  file { "/home/vagrant/aem" : ensure => 'directory' , owner => "vagrant" , group => "vagrant" }
  ->
  file { "/home/vagrant/aem/publisher" : ensure => 'directory' , owner => "vagrant" , group => "vagrant" }
  ->
  file { "/home/vagrant/aem/publisher/license.properties" : ensure => 'present' ,
    content => "license.product.name=Adobe Experience Manager
  license.customer.name=Day Training
  license.product.version=5.6.1.20130606
  license.downloadID=16c35d55-6a3d-8a48-986c-9d1be7ebbf70

      ", owner => "vagrant" , group => "vagrant"

  }
  ->
  file { "/home/vagrant/aem/run_cq.sh" :
    ensure => 'present',
    content => "#!/bin/bash
  java -Djava.awt.headless=true -Xms1024m -Xmx2048M -XX:MaxPermSize=512M -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=1045 -jar /aem_data/cq-quickstart-5.6.1.jar -nobrowser -r dev,publish -p 4503

  ", owner => "vagrant" , group => "vagrant"
  }

}