(ns maths-for-computer-science.standard-form-test
  (:require [maths-for-computer-science.standard-form :refer :all]
            [clojure.test :refer :all]))

(deftest standard-form-test
  (is (= "202 x 10^3" (standard-form 202000)))
  (is (= "5 x 10^4" (standard-form 50000)))
  (is (= "8 x 10^5" (standard-form 800000)))
  )
