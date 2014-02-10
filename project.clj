(defproject
  eining
  "0.1.0-SNAPSHOT"
  :repl-options
  {:init-ns eining.repl}
  :dependencies
  [[ring-server "0.3.1"]
   [domina "1.0.2"]
   [com.taoensso/timbre "3.0.0"]
   [environ "0.4.0"]
   [markdown-clj "0.9.41"]
   [prismatic/dommy "0.1.2"]
   [org.clojure/clojurescript "0.0-2138"]
   [com.taoensso/tower "2.0.1"]
   [org.clojure/clojure "1.5.1"]
   [cljs-ajax "0.2.3"]
   [lib-noir "0.8.0"]
   [compojure "1.1.6"]
   [selmer "0.5.9"]]
  :cljsbuild
  {:builds
   [{:source-paths ["src-cljs"],
     :compiler
     {:pretty-print false,
      :output-to "resources/public/js/site.js",
      :optimizations :advanced}}]}
  :ring
  {:handler eining.handler/app,
   :init eining.handler/init,
   :destroy eining.handler/destroy}
  :profiles
  {:uberjar {:aot :all},
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}},
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.1"]],
    :env {:dev true}}}
  :url
  "http://example.com/FIXME"
  :plugins
  [[lein-ring "0.8.10"]
   [lein-environ "0.4.0"]
   [lein-cljsbuild "0.3.3"]]
  :description
  "FIXME: write description"
  :min-lein-version "2.0.0")