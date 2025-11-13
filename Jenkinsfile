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

                    utils = load 'synrax.groovy'
                }
            }

            



        }



        stage('Build Jar') {

            steps{

                script {

                    buildJar()
                }
            }
           
                
            }
        

        stage('Build Image') {
            steps {
                script {
                    
                  buildImage('docker-hub-repo')

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
