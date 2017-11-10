(ns maths-for-computer-science.indices-test
  (:require [clojure.test :refer :all]
            [maths.indices :refer :all]))

(deftest select-values-test
  (testing "Selecting values from a map by providing base key")
  (is (= [2] (select-values {:base 2 :power 3} [:base]))))


(deftest divide-indices-test
  (testing "Dividng indices")
  (is (= '({:base 3, :power 0} {:base 2, :power 2}) (divide-indices [{:base 3 :power 2} {:base 2 :power 2} {:base 3 :power 2}] ))))



(deftest multiply-indices-test
  (testing "Multiply indices")
  (is (= '({:base 3, :power 4} {:base 2, :power 2}) (multiply-indices [{:base 3 :power 2} {:base 2 :power 2} {:base 3 :power 2}] ))))


(deftest raise-power-test
 (is (= {:base 2 :power 3} (raise-power 2 1 2))))

(deftest format-pwer-zero-test
  (is (= 1 (format-power-zero {:base 2 :power 0}))))

(deftest format-negative-indices-test
  (is (= {:numerator 1 :denominator 2 :power 3} (format-negative-indices {:base 2 :power -3}))))
