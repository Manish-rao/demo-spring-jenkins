pipeline {

agent any
        
	stages {

        stage('Build') {
        	print 'Pulling...' + env.BRANCH_NAME
            sh 'mvn --version'
        }
}
}