(ns holy-grail.core
  (:gen-class)
  (:require [holy-grail.systems :refer [prod-system]]
            [system.repl :refer [set-init! go]]))

(defn -main
  "Start a production system, unless a system is passed as argument (as in the dev-run task)."
  [& args]
  (let [candidate (first args)
        system (condp #(%1 %2) candidate
                    fn? candidate
                    var? candidate
                    #'prod-system)]
    (set-init! system)
    (go)))

