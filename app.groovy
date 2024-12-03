pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "crhacker7hub/spring-boot-app"
        AWS_REGION = "us-east-1"
        ECR_REGISTRY = "<your-aws-account-id>.dkr.ecr.${AWS_REGION}.amazonaws.com"
        ECR_REPOSITORY = "bookspageable"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Crhacker7/BooksPageable.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}