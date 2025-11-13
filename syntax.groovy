
def buildJar(){

     steps {
        echo 'This is the Build stage!'
        echo 'I am building...'
        sh 'mvn package'


}

}


def buildImage(String credentialsId){


    echo 'I am building docker image'
                    withCredentials([usernamePassword(credentialsId: credentialsId, passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t acrdevopsabdessamad.azurecr.io/my-java-app/$BUILD_NUMBER ."
                        sh "echo ${PASS} | docker login -u ${USER} acrdevopsabdessamad.azurecr.io --password-stdin"
                        sh "docker push acrdevopsabdessamad.azurecr.io/my-java-app/$BUILD_NUMBER"
                        sh "docker logout acrdevopsabdessamad.azurecr.io"

                    }

    


}


def test(){


    echo 'This is the Test stage!'


}




