(ns real-time.core
  (:gen-class)
  (:require [real-time.systems :refer [dev-system]]
            [reloaded.repl :refer [system init start stop go reset]]))

  (defn -main [& args]
    (reloaded.repl/set-init! prod-system)
    (go))
