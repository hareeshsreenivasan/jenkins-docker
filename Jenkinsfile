pipeline{
    agent any

    stages {
        stage ('Build'){
            steps{
            script {
                    properties([pipelineTriggers([pollSCM('')])])
                    }
                bat 'docker build -t hareesh52/jenkins-docker:version1.0 .'
            }
        }
        stage ('Publish'){
            steps{
                withDockerRegistry([credentialsId:"docker-hub", url:""]){
                    bat 'docker push hareesh52/jenkins-docker:version1.0'
                    }
                }
            }
        }
    }