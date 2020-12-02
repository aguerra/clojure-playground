(ns playground.exceptions)

(defn- is-else-clause
  [form]
  (and (seq? form)
       (#{'else} (first form))))

(defmacro try-else
  [& forms]
  (let [split-fn               (comp not is-else-clause)
        [try-forms rest-forms] (split-with split-fn forms)
        [[_ & else-forms]]     rest-forms]
    `(let [result# (try ~@try-forms (catch Exception e# ::exception))]
       (if (= result# ::exception)
         (do ~@else-forms)
         result#))))
