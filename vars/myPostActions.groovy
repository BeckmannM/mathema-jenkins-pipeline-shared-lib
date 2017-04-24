def call() {
	
	// Skript laden und ausführen
	def shellScript = libraryResource 'com/godyo/mathema/jenkins/shared/resources/deployUpdateSite.sh'
	sh "${shellScript}"
	
	// Emails versenden
	step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'manuel.beckmann@godyo.com', sendToIndividuals: false])
}
