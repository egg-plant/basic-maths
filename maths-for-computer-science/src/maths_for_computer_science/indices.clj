(ns maths.indices)

;; a^1 = a


;; *** Indices Multiplication **

(defn select-values [map ks]
  (reduce #(conj %1 (map %2)) [] ks))

(defn select-matching-keys [coll {:keys [key]}]
  (flatten (map #(select-values %1 [key]) coll)))

(defn perform-operation-on-indices-with-matching-base [indices operation]
  (merge 
   {:base (:base (first indices))}
   {:power (reduce operation (flatten (map #(select-values %1 [:power]) indices)))}))


(defn indices-operation [indices operation]
  (map #(perform-operation-on-indices-with-matching-base %1 operation ) (vals (group-by :base indices))))


(defn divide-indices [indices]
  "Divide the provided indices input by subtracting the powers"
  (indices-operation indices -))

(defn multiply-indices [indices]
  "Multiply the indices by add the powers"
  (indices-operation indices +))

;; (multiply-indices [{:base 3 :power 2} {:base 2 :power 2} {:base 3 :power 2}])


(def data [{:base 2, :power 3} {:base 2, :power 3} {:base 3 :power 5}])

;; When raising a power multiply the powers together the them together example (k^3)^2 = k^3 x k^3 = k^6

(defn raise-power [base power raise]
  {:base base :power (+ power raise)})

;; any letter or number to the power of zero is 1 k^0 = 1
(defn format-power-zero [{base :base power :power :as original}]
  (if (zero? power) 1 original))

;; Equation: a^{-m} = frac{1}{a^m}
(defn format-negative-indices [{base :base power :power :as original}]
  (if (neg? power) {:numerator 1 :denominator base :power power} original ))

