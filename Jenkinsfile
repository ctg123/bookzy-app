pipeline {
    agent any
    stages {
        stage("Cleaning the package") {
            steps {
                sh "mvn clean package"
            }
        }
        stage("Compiling the Bookzy Maven application") {
            steps {
                sh "mvn compile"
            }
        }
        stage("Running the Unit Test(s)") {
            steps {
                sh "mvn test"
                junit allowEmptyResults: true, testResults: "**/target/surefire-reports/*.xml" 
                sh 'rm -r archive'
                sh 'mkdir archive'
                sh 'echo test > archive/test.txt'
                script{
                    zip archive: true, dir: 'archive', glob: '', zipFile: 'test.zip'
                }
            }
        }
        stage("Deploy to Tomcat Server"){
            steps {
                echo "Deploying war file to Tomcat Server."
                deploy adapters: [tomcat9(credentialsId: '521c684c-fb8c-4b6b-9910-bfa6b2ada88c', path: '',
                url: 'http://ec2-3-129-88-225.us-east-2.compute.amazonaws.com:8080/')], contextPath: 'demoApplication', 
                war:'**/*.war'
            } 
        }
    }
    
    post {
        failure {
            echo 'This will run only if failed'
            emailext attachmentsPattern: 'test.zip', body: '''${SCRIPT, template="groovy-html.template"}''', 
                    subject: "${env.JOB_NAME} - Build # ${env.BUILD_NUMBER} - Failed", 
                    mimeType: 'text/html',to: "chaance.graves@ctginnovations.io"
            }
         success {
               echo 'This will only run if successful'
               emailext attachmentsPattern: 'test.zip', body: '''${SCRIPT, template="groovy-html.template"}''', 
                    subject: "${env.JOB_NAME} - Build # ${env.BUILD_NUMBER} - Successful", 
                    mimeType: 'text/html',to: "chaance.graves@ctginnovations.io"
                }        
        always {
            echo 'This will always run'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}