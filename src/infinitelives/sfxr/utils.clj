(ns infinitelives.sfxr.utils
  (require [clojure.string :refer [split]]))

; slurp in a single text file at compile time (for json sfx definitions)
(defmacro load-text-file [relative-uri-filename] (slurp relative-uri-filename))

; load in a set of files from a directory that match a particular extension at compile time
; https://www.refheap.com/18583
(defmacro load-file-set
  [dir ext]
  (->> (for [file (file-seq (clojure.java.io/file (str dir)))
             :when (and (.isFile file) (.endsWith (str file) (str ext)))]
        [(last (split (str file) #"/")) (slurp file)]) (into {})))
