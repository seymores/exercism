(ns bob
 (:require [clojure.string :as string]))

(defn- scrub-sentences
 [sentences]
 (apply str (filter #(Character/isLetter %) (seq sentences))))

(defn- is-question? 
 [reply]
 (= (last reply) \?))

(defn- is-shouting?
 [reply]
 (and (not (string/blank? reply))
  (= reply (string/upper-case reply))))

(defn response-for
 [reply]
 (cond
  (string/blank? reply) "Fine. Be that way!"
  (is-shouting? (scrub-sentences reply)) "Whoa, chill out!"
  (is-question? reply) "Sure."
  :else "Whatever."))
