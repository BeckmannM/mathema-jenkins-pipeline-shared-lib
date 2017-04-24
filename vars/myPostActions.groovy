import com.godyo.mathema.jenkins.shared.Logger

def call() {
	
	def logger = new Logger(steps);
	logger.log("Nun werden die post build-Aktionen ausgefuehrt");
	
	// Emails versenden
	step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'manuel.beckmann@godyo.com', sendToIndividuals: false])
}
