(ns maths-for-computer-science.standard-form
  (:require [maths-for-computer-science.indices :refer :all]
            [clojure.set :refer :all]))

(defn- standard-form-base [number operator compare]
  (let [result (operator number 10) compare-value (if (> number 1) 1 10)]
    (if (compare result compare-value)
      (recur result operator compare) (float number))))


(defn- standard-form-power [number operator compare]
  (let [number-atom (atom number) zeroes-counter (atom 0)
        compare-value (if (> number 1) 1 10)]
    (while (compare (operator @number-atom 10) compare-value)
      (do (swap! number-atom (fn [b] (operator b 10))) (swap! zeroes-counter inc)))
    @zeroes-counter))

(defn- format-standard-form
  [base power sign]
  (clojure.string/replace (format  "%s x 10^%s%s" base sign power) #".0 " " "))

(defn standard-form [number]
  "Returns the standard form of a arg number"
  (let [sign-positive (> number 1)
        operator (if sign-positive / *)
        compare (if sign-positive >= <)
        sign (if sign-positive "" "-")]
    (format-standard-form (standard-form-base number operator compare)
                          (standard-form-power number operator compare)sign)))

(defn standard-form-to-number [{value :value power :power}]
  (* value (Math/pow 10 power)))


(defn add-standard-forms [standard-forms]
  (reduce + (map standard-form-to-number standard-forms)))

(defn subtract-standard-forms [standard-forms]
  (reduce - (map standard-form-to-number standard-forms)))


(defn multiply-standard-forms [standard-forms]
  {:value (reduce * (flatten (map #(select-values % [:value]) standard-forms)))
   :power (get (nth (multiply-indices (map #(rename-keys % {:value :base}) standard-forms)) 0) :power)})



