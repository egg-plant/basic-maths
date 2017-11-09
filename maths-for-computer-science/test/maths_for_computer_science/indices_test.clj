(ns maths-for-computer-science.indices-test
  (:require [clojure.test :refer :all]
            [maths.indices :refer :all]))

(deftest select-values-test
  (testing "Selecting values from a map by providing base key")
  (is (= [2] (select-values {:base 2 :power 3} [:base]))))





