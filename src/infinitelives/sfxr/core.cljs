(ns infinitelives.sfxr.core
  (:require [jsfxr] [RIFFWAVE])
  (:require-macros [infinitelives.sfxr.utils :refer [load-file-set]]))

(enable-console-print!)

; turn a sfxr datastructure into an Audio element
(defn to-audio [sdef]
  (.getAudio (.generate (jsfxr/SoundEffect. (clj->js sdef)))))

; process the sound files into native data
(defn load-sfx-defs [] (->> (map
    (fn [[fname sdef]]
      [(first (.split fname ".")) (js->clj (.parse js/JSON sdef))])
    (load-file-set "resources/sounds/" ".sfxr.json")) (into {})))

; load a directory of sfx in json format from disk at compile time
(defn load-sfx-directory [] (->> (map (fn [[id sdef]] [(keyword id) (to-audio sdef)]) (load-sfx-defs)) (into {})))
