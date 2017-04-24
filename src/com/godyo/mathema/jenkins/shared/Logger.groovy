package com.godyo.mathema.jenkins.shared
import org.apache.commons.lang3.text.StrSubstitutor;

@Grab('org.apache.commons:commons-lang3:3.5')
class Logger implements Serializable {

	def steps;
	
	Logger(steps) {
		this.steps = steps;
	}
	
	public void log(String message) {
		
		// Skript von Datei laden
		def script = steps.libraryResource 'com/godyo/mathema/jenkins/shared/resources/echo.sh'

		// Message im Skript ersetzen
		def map = new HashMap();
		map.put("MESSAGE", message)
		script = new StrSubstitutor(map).replace(script);
		
		sh "${script}"
	}
}
