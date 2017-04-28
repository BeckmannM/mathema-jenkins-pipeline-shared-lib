def call(String src) {
	
	echo zipFile;
	
	def targetDir = null;
	
	try {
		timeout(1) {
			// some block
			targetDir = input(
					message: 'Alles gut? Ausliefern?',
					ok: 'OK',
					parameters: [
						string(
						defaultValue: 'C:\\Users\\Manuel\\Desktop\\MathemaCampus2017\\Deployment',
						description: 'Wohin soll ausgeliefert werden?',
						name: 'Verzeichnisname'
						)
					]
					)
		}
		
		if (targetDir != null) {
			sh "cp -r ${src} ${targetDir}"
		}
		
	} catch (Exception e) {
		echo "exception caught: " + e;
		currentBuild.result = "SUCCESS"
	}
}
