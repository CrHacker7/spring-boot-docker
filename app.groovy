pipeline {
    agent any
    stages {
        stage("Clean Up"){
            steps{
                deleteDir()
            }
        }
        stage("Clone Repo"){
            steps {
                bat "git clone https://github.com/CrHacker7/spring-boot-docker.git"
            }
        }
        stage("Build"){
            steps {
                dir("sspringbootbooksXXX") {
                    bat "mvn clean install"
                }
            }
        }
        stage("Test") {
            steps {
                dir("spring-boot-docker") {
                    bat "mvn test"
                }
            }
        }
        stage("Run") {
            steps {
                dir("sspringbootbooksXXX") {
                    bat "mvn spring-boot:run"
                }
            }
        }
    }
}

