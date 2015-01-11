(ns nrepl-comp.core
  (:require [com.stuartsierra.component :as component]
            [clojure.tools.nrepl.server :as nrepl-server]
            [cider.nrepl :refer [cider-nrepl-handler]]))


(defrecord NREPLHandler [port]
  component/Lifecycle
  (start [nrepl-handler]
    (nrepl-server/start-server
      :port port :handler cider-nrepl-handler))
  (stop [nrepl-handler]
    ))
