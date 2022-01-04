pipeline {

agent any
        
	stages {

        stage('Build') {
        	echo 'Pulling...' + env.BRANCH_NAME
            sh 'mvn --version'
        }
}