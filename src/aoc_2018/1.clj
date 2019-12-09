(ns aoc-2018.1
  (:require [clojure.string :as str]
            [clojure.edn :as edn]))

(defn solve []
  (-> "./resources/1.txt"
      (slurp)
      (str/split-lines)
      (->> (mapv edn/read-string)
           (apply +))))

(def changes
  (-> "./resources/1.txt"
      (slurp)
      (str/split-lines)
      (->> (mapv edn/read-string)
           ;; (cycle)
           )))

;; (def changes (cycle [3 3 4 -2 -4]))

(defn get-duplicate-freq [changes]
  (loop [i 0
         seen {0 true}
         freq 0]
    (let [v (nth changes (mod i (count changes)))
          new-freq (+ v freq)]
      (if (get seen new-freq)
        new-freq
        (do 
            (recur (inc i) (assoc seen new-freq true) new-freq))))))

(defn solve2 []
  (get-duplicate-freq changes))
