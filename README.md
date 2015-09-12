## Use ##

	; test playing a sound generated from sfxr URL code
	(def a (sfx/to-audio "#12TSMv9WmPWMqHPc1DsCjgCiRhGfmD9FdwFyr4Gd5Nx3SadrCu9pm8BffuTtxwedvbXeritFVSqwakcFLDyZWLjwdmTBGc7hwzirsTZbGbnrXGgfHSs2y8SsTy"))
	
	; play the sound that was generated
	(.play a)
	
	; load a hash-map of json-encoded sounds from resources/sounds/ at compile time
	(def my-sfx (sfx/load-sfx-directory))
	
	; play one of the sounds loaded - "donk.sfxr.json"
	(.play (my-sfx :donk))

## Test / develop ##

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).

