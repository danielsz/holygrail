(set-env!
 :source-paths   #{"src/cljs" }
 :resource-paths #{"resources" "src/clj"}
 :dependencies '[[adzerk/boot-cljs      "0.0-2814-4" :scope "test"]
                 [adzerk/boot-reload    "0.2.6"      :scope "test"]
                 [pandeiro/boot-http    "0.6.2"      :scope "test"]
                 [cljsjs/boot-cljsjs     "0.4.7"      :scope "test"]
                 ; server
                 [org.danielsz/system "0.1.4"]
                 [ring/ring-defaults "0.1.4"]
                 [http-kit "2.1.16"]
                 [compojure "1.3.3"]
                 [com.taoensso/sente "1.4.1"]
                 ; client
                 [org.danielsz/cljs-utils "0.1.0-SNAPSHOT"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [org.clojure/core.match "0.3.0-alpha4"]
                 [secretary "1.2.3" :exclusions [org.clojure/clojurescript]]
                 [cljsjs/leaflet "0.7.3-0"]
                 [danielsz/boot-autoprefixer "0.0.1"]
                 [org.om/om "0.8.1" :exclusions [com.facebook/react]]
                 [cljsjs/hammer "2.0.4-4"]
                 [cljsjs/react-with-addons "0.13.1-0"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-reload    :refer [reload]]
 '[cljsjs.boot-cljsjs    :refer [from-cljsjs]]
 '[pandeiro.boot-http    :refer [serve]]
 '[danielsz.autoprefixer :refer [autoprefixer]]
 '[reloaded.repl :refer [system init start stop go reset]]
 '[real-time.systems :refer [dev-system]])

(task-options!
 autoprefixer {:files ["main.css"]})
