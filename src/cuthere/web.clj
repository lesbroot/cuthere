(ns cuthere.web
  (:gen-class)
  (:require [cuthere.web.pages.routes]
            [cuthere.db.core :as db]
            [ring.middleware.stacktrace]
            [ring.middleware.reload]
            [ganelon.web.middleware :as middleware]
            [ganelon.web.app :as webapp]
            [taoensso.timbre :as timbre]
            [noir.session :as sess]))

(defmacro dbg[x] `(let [x# ~x] (println "dbg:" '~x "=" x#) x#))

(defn init []
  (timbre/info "initialize app")
  (db/init))

(defn destroy []
  (timbre/info "cuthere destroy"))

(def handler
  (->
    (ganelon.web.app/app-handler
     (ganelon.web.app/javascript-actions-route))
    middleware/wrap-x-forwarded-for
    (ring.middleware.stacktrace/wrap-stacktrace)
    (ring.middleware.reload/wrap-reload {:dirs ["src/cuthere/web"]})))
