pipeline {
    agent any
    tools  {
        maven 'maven-3.9'
        
    }

    stages {
        
        // 3. This is the first stage
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
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t abddesamdmhj/demo-app:jma-2.0 ."
                        sh "echo ${PASS} | docker login -u ${USER} --password-stdin"
                        sh "docker push abddesamdmhj/demo-app:jma-2.0"
                    }
                }
            }
        }

        stage('Test') {
            steps {
                // This is the work it does
                echo 'This is the Test stage!'
                echo 'I am testing...'
            }
        }

        
    }
    post {
        always {
            echo 'This will always run after the stages finish'
        }
    }
