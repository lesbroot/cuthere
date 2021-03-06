(defproject cuthere "0.1.0-SNAPSHOT"
  :description "CU there app"
  :url "http://cuthe.re"
  :license {:name "The MIT License (MIT)"
            :url "http://opensource.org/licenses/MIT"}
  :source-paths ["src-clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [lib-noir "0.7.9"]
                 [clj-json "0.5.0"]
                 [http-kit "2.1.13"]
                 [com.taoensso/timbre "2.7.1"]
                 [org.clojure/core.incubator "0.1.3"]
                 [org.clojure/tools.cli "0.2.4"]
                 [com.cemerick/friend "0.2.0"]
                 [com.novemberain/monger "1.5.0"]
                 [ring-server "0.3.1"]
                 [ritz/ritz-nrepl-middleware "0.7.0"]
                 [org.clojure/tools.trace "0.7.6"]
                 [com.draines/postal "1.11.1"]
                 [wuzhe/clj-oauth2 "0.5.3"]
                 [crypto-random "1.1.0"]
                 [ring/ring-json "0.2.0"]
                 [cljs-ajax "0.2.3"]
                 [enfocus "2.0.2"]
                 [org.clojure/core.cache "0.6.3"]
                 [org.clojure/clojurescript "0.0-2014" :exclusions [org.apache.ant/ant]]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :main cuthere.core
  :plugins [[lein-cljsbuild "1.0.1"]
            [lein-ring "0.8.6"]
            [lein-ritz "0.7.0"]]
  :cljsbuild {:builds [{:source-paths ["src-cljs"]
                        :compiler {:output-to "resources/public/js/main.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]}
  :repl-options {:nrepl-middleware
                 [ritz.nrepl.middleware.javadoc/wrap-javadoc
                  ritz.nrepl.middleware.simple-complete/wrap-simple-complete]}
  :ring {:handler cuthere.web/handler :init cuthere.web/init})
