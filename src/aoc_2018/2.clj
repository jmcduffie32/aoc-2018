(ns aoc-2018.2
  (:require [clojure.string :as str]))

(def ids (-> "./resources/2.txt"
             (slurp)
             (str/split-lines)))

(def dup-counts
  (-> ids
      (sort)
      (->> (map #(str/split % #""))
           (map sort)
           (map #(partition-by identity %))
           (map #(map count %))
           (map #(into #{} %))
           )))

(defn solve []
  (* (count (filter #(contains? % 2) dup-counts))
     (count (filter #(contains? % 3) dup-counts))))
