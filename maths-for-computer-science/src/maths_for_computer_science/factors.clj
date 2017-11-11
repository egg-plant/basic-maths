(ns maths-for-computer-science.factors)


;; https://www.bbc.co.uk/education/guides/zpvgdxs/revision


;; Multiples of a number 
;; for example multiples of 5 are 5 10 15 20 25 .. n

;; Factor is a number that will divide a number into a integer
;; eg 8 is a factor of 24 as 8 divides 24 into a integer of 3

(defn is-factor? [factor number]
  (zero? (mod number factor)))

;; Factor pairs are two numbers that calculate a number
;; Example factor pairs of 12 are 1 and 12, 2 and 6 and 3 and 4

(defn factors [number]
  "Bind the number max as the range needs to be +1 of it"
  (let [number-max (inc number)]
    (filter #(is-factor? %1 number) 
            (take number-max (range 1 number-max)))))

(defn is-factor-pair? [factor-a factor-b number]
  "Calculates if this is a factor pair of the number and returns true or false"
  (= (* factor-a factor-b) number))


;; Prime numbers
;; a number can only be divided by itself or one
;; 1 is not a prime number as its only factor is itself
;; 2 is the only even prime number every other even prime number has a factor of 
;; It turns out that there is a common algorithm to make this more efficient which 
;; states that you only need to test the numbers that are equal to or less than the squ are root of that number. This is because we can always find the divisors of a number in pairs. One member of the pair will be less than the square root and the other will be more.
;; (range 3 (inc (Math/sqrt 100)) 2) this uses step so ignores multiples of 2
;; eg (range 3 (inc (Math/sqrt 100))) (3 4 5 6 7 8 9 10)
;; (range 3 (inc (Math/sqrt 100)) 2) (3 5 7 9)
;; cons returns a new sequence begging with x and seq is rest eg cons 2 range

(defn is-prime? [n]
  (cond 
   (< n 2) false
   (= 2 n) true
   :else
   (not-any? #(zero? (mod n %)) (cons 2 (range 3 (inc (Math/sqrt n)) 2)))))

;; Square number is given when a number is multiplied by itself
(defn square [x]
  (* x x))

;; Estimating power and roots can be done by looking above and below
;; Estimate 3.7^3 look at 3^3 and 4^3 and estimate about 50

;; **** Prime factors ***** are any factors of a number that are also prime
(defn prime-factors [number]
  (filter is-prime? (factors number)))

;; For example write 40 as a product of its prime factors for example start
;; 4*10 = 40 but they are not prime so find factors of each 2*2 and 2*5 which are prime
;; so the factors of 40 which are prime are 2*2*2*5 = 40


;; *** Common factors *****
;; Are a factor that is shared by two or more numbers eg 2 is a factor of 8 and 10
;; Higest Common Factor is found by finding all common factors and selecting highest
;; Find common factors by listing the factors for each number
;; Then match common ones and take the max for the highest

(defn common-factors [a b] 
  (filter (set (factors a)) (set (factors b))))

(defn highest-common-factor [a b]
  (apply max (common-factors a b)))

;; *** Lowest common multiple ****
;; ** common multiple is a multiple shared between two numbers
;; Eg List multiples of 5 (5 10 15 20 25 30 35 ..) and 6 (6 12 18 24 30 36 ...)
;; So 30 is the lower common multiple

(defn gcd [numerator denominator]
  (if (= denominator 0)
      numerator
      (gcd denominator (rem numerator denominator ))))

(defn lowest-common-multiple [a b]
  (/ (* a b) (gcd a b)))



;; *** Finding Highest common factor and lowest common multiple can be slow
;; so can use prime factors take the prime factors of the two values
;; find the ones that match and multiply them

(defn highest-common-factor-by-prime-factors [a b]
  (reduce * (filter (set (prime-factors a)) (set (prime-factors b)))))


