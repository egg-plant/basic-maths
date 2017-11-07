(ns maths-for-computer-science.core)

;; Intro to proofs
;; Pythag theorem proof
;; calculates if its a right angle if this is true
;; a^2 + b^2 = c^2

(defn pythag-theorem [a b c]
  (=(+ (Math/pow a 2)(Math/pow b 2)
       ) (Math/pow c 2)))

;; Proof create a a*a square and a b*b square then should match the area
;; of a c*c square have a b-a square from c triangles create square. 
;; proof by picture
;; problem lot of hidde assumptions
