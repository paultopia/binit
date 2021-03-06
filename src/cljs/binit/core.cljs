(ns binit.core
  (:require [cljs.core.async :refer [promise-chan <! >! close!]]))

(defn fcc [arr]
  (.apply (.fromCharCode js/String) nil arr))

(defn transform [ab]
  (let [uia (js/Uint8Array. ab)]
    (js/btoa (fcc uia))))

(defn make-req [url]
  (let [xh (js/XMLHttpRequest.)
        data-chan (promise-chan)]
    (.open xh "GET" url true)
    (set! (.-responseType xh) "arraybuffer")
    (set! (.-onload xh) #(go (>! auth-chan (transform %))))
    (set! (.-onerror xh) #(do
                            (close! promise-chan)
                            (.error js/console (.-statusText xh))))
    (.send xh nil)
    data-chan))

(defn fetch-binary [func url]
  (go
    (let [b64 (<! (make-req url))]
      (func b64))))
