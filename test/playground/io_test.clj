(ns playground.io-test
  (:require [clojure.java.io :as io]
            [clojure.test :refer :all]
            [playground.io :as play-io]))

(defn- printing
  [my-fn]
  (comp println my-fn))

(deftest process-by-line
  (testing "process a file"
    (is (= "5\n6\n"
           (with-out-str
             (play-io/process-by-line (io/resource "test.txt") (printing count)))))))
