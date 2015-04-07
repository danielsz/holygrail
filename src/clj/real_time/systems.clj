(ns real-time.systems
  (:require 
   [real-time.webapp :refer [app]]
   [system.core :refer [defsystem]]
   (system.components 
    [http-kit :refer [new-web-server]]
    [sente :refer [new-channel-sockets]])))
   
(defsystem dev-system
  [:web (new-web-server 3010 app)])

(defsystem prod-system
  [:web (new-web-server 8080 app)])
