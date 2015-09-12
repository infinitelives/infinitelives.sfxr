(ns ^:figwheel-always infinitelives.sfxr.main
    (:require [infinitelives.sfxr.core :as sfx]))

(enable-console-print!)

; test playing a sound generated from sfxr URL code
(def a (sfx/to-audio "#12TSMv9WmPWMqHPc1DsCjgCiRhGfmD9FdwFyr4Gd5Nx3SadrCu9pm8BffuTtxwedvbXeritFVSqwakcFLDyZWLjwdmTBGc7hwzirsTZbGbnrXGgfHSs2y8SsTy"))
; attach an event handler to the button to play the sound
(.addEventListener (js/document.getElementById "play-code") "click" (fn [] (.play a)))

; load a hash-map of json-encoded sounds from resources/sounds/ at compile time
(def my-sfx (sfx/load-sfx-directory))
; attach an event handler to the button to play the sound
(.addEventListener (js/document.getElementById "play-disk") "click" (fn [] (.play (my-sfx :donk))))

; *** default figwheel stuff ***

; (println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

; (defonce app-state (atom {:text "Hello world!"}))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
