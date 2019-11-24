(ns playground.io
  (:require [clojure.java.io :as io]))

(defn process-by-line
  [x process-fn]
  (with-open [rdr (io/reader x)]
    (doseq [line (line-seq rdr)]
      (process-fn line))))
