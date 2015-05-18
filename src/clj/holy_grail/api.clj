(ns holy-grail.api)

(defn quiz [{:keys [params] :as request}] (if (= "Nineveh" (:answer params))
                                            (str "<p>You may cross the bridge.</p>")
                                            (str "<p>You have been cast into the gorge of eternal peril.</p>")))
