(ns playground.data
  (:require [schema.coerce :as coerce]
            [schema.core :as s]))

(def ^:private default-coercions
  {s/Uuid    coerce/string->uuid
   s/Bool    coerce/string->boolean
   s/Keyword coerce/string->keyword})

(def ^:private default-matcher (coerce/first-matcher
                                [default-coercions
                                 coerce/keyword-enum-matcher
                                 coerce/set-matcher]))

(defn coerce!
  [value schema]
  (let [coercer (coerce/coercer! schema default-matcher)]
    (coercer value)))
