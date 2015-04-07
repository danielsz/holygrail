(ns real-time.webapp
  (:require [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [compojure.core :refer :all]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] (fn [req] nil))
  (route/not-found (fn [req] nil)))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)))
