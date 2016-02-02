(ns holy-grail.systems
  (:require 
   [holy-grail.handler :refer [app]]
   [environ.core :refer [env]]
   [system.core :refer [defsystem]]
   (system.components 
    [jetty :refer [new-web-server]]
    [repl-server :refer [new-repl-server]])))
   
(defsystem dev-system
  [:web (new-web-server (Integer. (env :http-port)) app)])

(defsystem prod-system
  [:web (new-web-server (Integer. (env :http-port)) app)
   :repl-server (new-repl-server (Integer. (env :repl-port)))])
