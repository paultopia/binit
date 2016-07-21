(set-env!
 :source-paths #{"src/cljs"}

 :dependencies '[[adzerk/boot-cljs "1.7.228-1" :scope "test"]
                 [org.clojure/clojure "1.8.0" :scope "provided"]
                 [org.clojure/core.async "0.2.374" :scope "provided"]
                 [org.clojure/clojurescript "1.9.76":scope "provided"]
                 [adzerk/bootlaces "0.1.13" :scope "test"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[adzerk.bootlaces :refer :all])

(def +version+ "0.0.1-SNAPSHOT") 
(bootlaces! +version+)

(task-options!
 push {:ensure-branch nil}
 pom {:project 'org.clojars.paulitheism/binit
      :version +version+
      :description "ClojureScript library to fetch binary data as base64 from in-browser."
      :url "https://github.com/paultopia/binit"
      :scm {:url "https://github.com/paultopia/binit"}
      :license {"MIT License" "https://opensource.org/licenses/MIT"}})

(deftask install-jar
  []
  (merge-env! :resource-paths #{"src"})
  (comp
   (pom)
   (jar)
   (install)))
