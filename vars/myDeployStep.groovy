import com.godyo.mathema.jenkins.shared.Logger

def call(String zipFile, String targetDir) {

	try {
		timeout(1) {
			// some block
			env.deploymnetTarget = input(
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
		
		if (env.deploymnetTarget != null) {
			unzip dir: targetDir , zipFile: zipFile
		}
		
	} catch (Exception e) {
		currentBuild.currentResult = SUCCESS
	}
}
