(ns maths-for-computer-science.standard-form-test
  (:require [maths-for-computer-science.standard-form :refer :all]
            [clojure.test :refer :all]))

(deftest standard-form-test
  (is (= "2.02 x 10^5" (standard-form 202000)))
  (is (= "5 x 10^4" (standard-form 50000)))
  (is (= "8 x 10^5" (standard-form 800000)))
  (is (= "1 x 10^-4" (standard-form 0.0001)))
  (is (= "8.7 x 10^4" (standard-form 87000)))
  (is (= "5 x 10^-4" (standard-form 0.0005))))


(deftest standard-form-to-number-test
  (is (= 1340.0 (standard-form-to-number {:value 1.34 :power 3}))))
