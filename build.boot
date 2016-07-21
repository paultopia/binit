(set-env!
 :source-paths #{"src/cljs"}

 :dependencies '[[adzerk/boot-cljs "1.7.228-1"]
                 [org.clojure/core.async "0.2.374"]
                 [org.clojure/clojurescript "1.9.76"]])

(require '[adzerk.boot-cljs :refer [cljs]])
