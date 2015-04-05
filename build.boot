(set-env!
 :source-paths   #{"src"}
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/boot-cljs      "0.0-2814-4" :scope "test"]
                 [adzerk/boot-reload    "0.2.6"      :scope "test"]
                 [pandeiro/boot-http    "0.6.2"      :scope "test"]
                 [cljsjs/boot-cljsjs     "0.4.7"      :scope "test"]
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
 '[danielsz.autoprefixer :refer [autoprefixer]])
