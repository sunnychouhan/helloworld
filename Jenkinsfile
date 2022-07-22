pipeline {
    agent any
	tools {
	    maven "maven384"
	 	}
	stages {
        stage('Clean and Install') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage ('Package'){
            steps {
                sh 'mvn package'
             }
        }
    }
}