(ns maths-for-computer-science.factors-test
  (:require [clojure.test :refer :all]
            [maths-for-computer-science.factors :refer :all]))

(deftest is-factor-test
 (is (= true (is-factor? 8 24))))

(deftest factors-test 
  (is (= [1 2 3 4 6 12] (factors 12))))

(deftest is-factor-pair-yes-test
  (is (= true (is-factor-pair? 3 4 12))))

(deftest is-factor-pair-no-test
  (is (= false (is-factor-pair? 3 5 12))))

;; Look how to provide many test cases
(deftest is-prime-test? 
  (is (= false (is-prime? 1))))

(deftest is-prime-factor-test?
  (is (= [2 5] (prime-factors 40))))

(deftest is-common-factor-test
  (is (= '(1 2) (common-factors 8 10))))

(deftest is-highest-common-factor-test 
  (is (= 2 (highest-common-factor 8 10))))

(deftest gcd-test
  (is (= 4 (gcd 40 28))))

(deftest lowest-common-multiple-test
  (is (= 30 (lowest-common-multiple 5 6))))

(deftest highest-common-factor-by-prime-factors-test
  (is (= 2 (highest-common-factor-by-prime-factors 8 10))))





