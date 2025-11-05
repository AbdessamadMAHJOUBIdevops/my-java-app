pipeline {
    agent any

    // 2. 'stages' is the block that holds all the work
    stages {
        
        // 3. This is the first stage
        stage('Build') {
            steps {
                // This is the work it does
                echo 'This is the Build stage!'
                echo 'I am building...'
            }
        }

        // 4. This is the second stage
        stage('Test') {
            steps {
                // This is the work it does
                echo 'This is the Test stage!'
                echo 'I am testing...'
            }
        }
    }
}
