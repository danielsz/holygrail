(ns real-time.handler
  (:require [clojure.java.io :as io]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (route/resources "css" {:root "css"})
  (GET "/" [] "Hello World")
  (GET "/bar" [] (io/resource "index.html"))
  (GET "/foo" [] (str "<h1>Hello user Daniel</h1>"))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)))
