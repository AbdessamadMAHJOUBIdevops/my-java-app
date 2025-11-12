pipeline {
    agent any
    tools  {
        maven 'maven-3.9'
    }

    stages {
        stage('Build Jar') {
            steps {
                echo 'This is the Build stage!'
                echo 'I am building...'
                sh 'mvn package'
            }
        }

        stage('Build Image') {
            steps {
                script {
                    echo 'I am building docker image'
                    withCredentials([usernamePassword(credentialsId: 'acr-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t acrdevopsabdessamad.azurecr.io/my-java-app/$BUILD_NUMBER ."
                        sh "echo ${PASS} | docker login -u ${USER} acrdevopsabdessamad.azurecr.io --password-stdin"
                        sh "docker push acrdevopsabdessamad.azurecr.io/my-java-app/$BUILD_NUMBER"
                        sh "docker logout acrdevopsabdessamad.azurecr.io"
                    }
                }
            }
        }

        stage('Test') {
            steps {
                echo 'This is the Test stage!'
            }   // ✅ fermeture de steps
        }       // ✅ fermeture de stage
    }           // ✅ fermeture de stages

}               // ✅ fermeture de pipeline
