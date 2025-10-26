pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build & Test') {
      steps {
        sh 'mvn clean test'
      }
    }
    stage('Allure Report') {
      steps {
        sh 'mvn allure:report || true'
      }
    }
  }
  post {
    always {
      archiveArtifacts artifacts: 'target/allure-results/**', allowEmptyArchive: true
    }
  }
}
