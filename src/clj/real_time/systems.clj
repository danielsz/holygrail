(ns real-time.systems
  (:require 
   [real-time.handler :refer [app]]
   [environ.core :refer [env]]
   [system.core :refer [defsystem]]
   (system.components 
    [http-kit :refer [new-web-server]]
    [sente :refer [new-channel-sockets]])))
   
(defsystem dev-system
  [:web (new-web-server (Integer. (env :http-port)) app)])

(defsystem prod-system
  [:web (new-web-server (Integer. (env :http-port)) app)])
