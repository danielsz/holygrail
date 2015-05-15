(ns holy-grail.core
  (:gen-class)
  (:require [holy-grail.systems :refer [prod-system]]
            [reloaded.repl :refer [system init start stop go reset]]))

  (defn -main [& args]
    (reloaded.repl/set-init! prod-system)
    (go))
