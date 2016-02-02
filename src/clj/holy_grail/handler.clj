(ns holy-grail.handler
  (:require
   [holy-grail.api :refer :all]
   [clojure.java.io :as io]
   [compojure.core :refer [defroutes GET]]
   [compojure.route :as route ]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
   [ring.util.response :refer [response content-type resource-response]]))

(defroutes routes
  (GET "/" [] (-> (resource-response "index.html")
                  (content-type "text/html")))
  (route/not-found "Not Found"))

(def middleware (-> site-defaults
                 (assoc-in [:static :resources] "/")
                 (assoc-in [:security :anti-forgery] false)))

(def app
  (-> routes
      (wrap-defaults middleware)))
