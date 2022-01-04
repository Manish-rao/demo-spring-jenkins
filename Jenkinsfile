node {
    def mvnHome
    stage('Build') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
            } else {
                cmd.exe /k ""C:\Program Files\apache-maven-3.8.4\bin\mvn.exe" -f pom.xml & "exit %%ERRORLEVEL%%""
            }
        }
    }
}
