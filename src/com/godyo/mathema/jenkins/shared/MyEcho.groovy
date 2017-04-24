package com.godyo.mathema.jenkins.shared
import org.apache.commons.lang3.text.StrSubstitutor;

@Grab('org.apache.commons:commons-lang3:3.5')
class MyEcho implements Serializable {

	def steps;
	
	MyEcho(steps) {
		this.steps = steps;
	}
	
	public void echo(String message) {
		
		// Skript von Datei laden
		def script = libraryResource 'com/godyo/mathema/jenkins/shared/resources/deployUpdateSite.sh'

		// Message im Skript ersetzen
		def map = new HashMap();
		map.put("MESSAGE", message)
		script = new StrSubstitutor(map).replace(script);
		
		sh "${script}"
	}

}
