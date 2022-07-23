pipeline {
    agent any
	tools {
	    maven "maven384"
	 	}
	stages {
//         stage('Clean and Install') {
//             steps {
//                 sh 'mvn clean install'
//             }
//         }
        stage ('Package'){
            steps {
                sh 'mvn clean package'
             }
        }

        stage ("Auto-Increment version"){

             steps {
                sh "mvn build-helper:parse-version versions:set -DnewVersion='${parsedVersion.majorVersion}.${parsedVersion.minorVersion}.${parsedVersion.nextIncrementalVersion}.${parsedVersion.qualifier}'"
             }
        }

        stage ('Server'){
                steps {
                   rtServer (
                     id: "Artifactory",
                     url: 'http://192.168.1.163:8082/artifactory',
                     username: 'admin',
                      password: 'artifactory',
                      bypassProxy: true,
                       timeout: 300
                            )
                }
            }
            stage('Upload'){
                steps{
                    rtUpload (
                     serverId:"Artifactory" ,
                      spec: '''{
                       "files": [
                          {
                          "pattern": "*.jar",
                          "target": "example-repo-local"
                          }
                                ]
                               }''',
                            )
                }
            }
            stage ('Publish build info') {
                steps {
                    rtPublishBuildInfo (
                        serverId: "Artifactory"
                    )
                }
            }
        }
}
