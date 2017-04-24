def call() {
	
	// Emails versenden
	step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'manuel.beckmann@godyo.com', sendToIndividuals: false])
}
