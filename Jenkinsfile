node {
    def mvnHome
    stage('Build') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
            } else {
                bat(/mvn -f "C:\Users\manis\git\demo-spring-jenkins\pom.xml" clean install -Dmaven.test.skip=true /)
            }
        }
    }
}