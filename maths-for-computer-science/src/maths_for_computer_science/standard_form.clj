(ns maths-for-computer-science.standard-form)

(defn- standard-form-base [number]
  (if (zero? number)
    false
    (if (= (mod number 10) 0)
      (recur (/ number 10)) number)))


(defn- standard-form-power [number]
  (let [number-atom (atom number) zeroes-counter (atom 0)]
    (while (= (mod @number-atom 10) 0)
      (do (swap! number-atom (fn [b] (/ b 10))) (swap! zeroes-counter inc)))
    @zeroes-counter))

(defn standard-form [number]
  (format  "%s x 10^%s" (standard-form-base number) (standard-form-power number)))
