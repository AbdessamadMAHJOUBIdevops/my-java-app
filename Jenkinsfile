def utils

pipeline {
    agent any
    tools  {
        maven 'maven-3.9'
    }

    stages {

        stage('init'){

            steps {

                script{

                    utils = load 'syntax.groovy'
                }
            }

            



        }



        stage('Build Jar') {

            steps{

                script {

                    utils.buildJar()
                }
            }
           
                
            }
        

        stage('Build Image') {
            steps {
                script {
                    
                  utils.buildImage('docker-hub-repo')

                    }
                }
            }
        

        stage('Test') {
            steps {
                script {
                    test()
                }
            }   
        }       
    }           

}               
