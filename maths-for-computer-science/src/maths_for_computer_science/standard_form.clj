(ns maths-for-computer-science.standard-form)

(defn- standard-form-base [number operator compare]
  (let [divided (operator number 10) compare-value (if (> number 1) 1 10)]
    (if (compare divided compare-value)
      (recur divided operator compare) (float number))))


(defn- standard-form-power [number operator compare]
  (let [number-atom (atom number) zeroes-counter (atom 0)
        compare-value (if (> number 1) 1 10)]
    (while (compare (operator @number-atom 10) compare-value)
      (do (swap! number-atom (fn [b] (operator b 10))) (swap! zeroes-counter inc)))
    @zeroes-counter))

(defn standard-form [number]
  "Returns the standard form of a arg number"
  (let [operator (if (> number 1) / *)
        compare (if (> number 1) >= <)
        sign (if (> number 1) "" "-")]
    (clojure.string/replace (format  "%s x 10^%s%s" (standard-form-base number operator compare) sign (standard-form-power number operator compare)) #".0 " " ")))
