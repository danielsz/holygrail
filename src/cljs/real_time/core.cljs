(ns real-time.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [cljs.core.async :as async :refer [<! timeout chan put!]]
            [cljs-utils.core :refer [by-id]])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(def app-state (atom {}))

(defn form
  "Om component for new paste-link"
  [data owner]
  (reify
    om/IDisplayName
    (display-name [this]
      "paste-link")
    om/IRender
    (render [_]
      (dom/form #js {:className "input-form"}
                (dom/input #js {:type "url" :name "link"})
                (dom/input #js {:type "submit" :value "Submit"})))))

(defn app [data owner]
  (reify
    om/IWillMount
    (will-mount [_])
    om/IDidMount
    (did-mount [_])
    om/IDisplayName
    (display-name [this]
      "app")
    om/IRender
    (render [this]
      (om/build form data))))

(om/root app app-state
         {:target (by-id "container")})
