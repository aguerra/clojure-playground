(ns playground.io-test
  (:require [clojure.java.io :as io]
            [clojure.test :refer :all]
            [playground.io :as play-io]))

(defn- with-print
  [my-fn]
  (comp print my-fn))

(deftest process-by-line
  (testing "process a file"
    (is (= "56"
           (with-out-str
             (play-io/process-by-line (io/resource "test.txt") (with-print count))))))

  (testing "process stdin"
    (is (= "firstsecond"
           (with-in-str "first\nsecond"
             (with-out-str
               (play-io/process-by-line *in* (with-print identity))))))))
