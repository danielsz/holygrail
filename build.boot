(set-env!
 :source-paths   #{"src/cljs" "src/clj"}
 :resource-paths #{"resources"}
 :dependencies '[[org.clojure/clojure "1.7.0"     :scope "provided"]
                 [org.clojure/clojurescript "1.7.189"]
                 [adzerk/boot-cljs "1.7.170-3" :scope "test"]
                 [adzerk/boot-reload    "0.4.2"      :scope "test"]

                 [adzerk/boot-cljs-repl   "0.3.0"] ;; latest release
                 [com.cemerick/piggieback "0.2.1"  :scope "test"]
                 [weasel                  "0.7.0"  :scope "test"]

                 [environ"1.0.1"]
                 [boot-environ "1.0.1"]
                 [org.danielsz/system "0.2.1-SNAPSHOT"]
                 [org.clojure/tools.nrepl "0.2.12"]

                 ; server
                 [ring/ring-defaults "0.1.5"]
                 [http-kit "2.1.19"]
                 [compojure "1.4.0"]
                 ; client
                 [org.omcljs/om "1.0.0-alpha28" :exclusions [[cljsjs/react]]]
                 [cljsjs/react "0.14.3-0"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload    :refer [reload]]
 '[reloaded.repl :refer [init start stop go reset]]
 '[holy-grail.systems :refer [dev-system prod-system]]
 '[environ.boot :refer [environ]]
 '[system.boot :refer [system run]])

(deftask dev
  "Run a restartable system in the Repl"
  []
  (comp
   (environ :env {:http-port "3000"})
   (watch :verbose true)
   (system :sys #'dev-system :auto-start true :hot-reload true :files ["handler.clj"])
   (reload)
   (cljs :source-map true)
   (repl :server true)))

(deftask dev-cljs-repl
  "Run a restartable system in the Repl"
  []
  (comp
   (environ :env {:http-port "3000"})
   (watch :verbose true)
   (system :sys #'dev-system :auto-start true :hot-reload true :files ["handler.clj"])
   (reload)
   (cljs-repl)
   (cljs :source-map true)))

(deftask dev-run
  "Run a dev system from the command line"
  []
  (comp
   (environ :env {:http-port "3000"})
   (cljs)
   (run :main-namespace "holy-grail.core" :arguments [#'dev-system])
   (wait)))

(deftask prod-run
  "Run a prod system from the command line"
  []
  (comp
   (environ :env {:http-port "8008"
                  :repl-port "8009"})
   (cljs :optimizations :advanced)
   (run :main-namespace "holy-grail.core" :arguments [#'prod-system])
   (wait)))


