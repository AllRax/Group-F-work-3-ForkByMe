pipeline {
    agent any
    tools {
        maven "myMaven"
    }

    stages {
        stage("Build") {
            steps {
                echo "Building the application"
                bat "mvn clean install"
            }
        }

        stage("Test") {
            steps {
                echo "Running the surefire tests"
                bat "mvn clean package"
                bat "mvn test"
            }
        }

        stage("Issue surefire report") {
            steps {
                echo "Generating report..."
            }
        }

        stage("SonarQube Analysis") {
            steps {
                withSonarQubeEnv("mySonar") {
                    bat "mvn clean verify sonar:sonar -Dsonar.projectKey=group3Project -Dsonar.projectName='group3Project'"
                }
            }
            post {
                success {
                    emailext(
                        subject: "Jenkins Build SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: """
                        Build Successful!
                        - Job: ${env.JOB_NAME}
                        - Build Number: ${env.BUILD_NUMBER}
                        - Build URL: ${env.BUILD_URL}
                        """,
                        to: 'andrewssuubi@gmail.com, aitaryanodrua@gmail.com, alexandermwase13@gmail.com'
                    )
                }
                failure {
                    emailext(
                        subject: "Jenkins Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: """
                        Build Failed!
                        - Job: ${env.JOB_NAME}
                        - Build Number: ${env.BUILD_NUMBER}
                        - Build URL: ${env.BUILD_URL}

                        Please check the logs for more details.
                        """,
                        to: 'aitaryanodrua@gmail.com, andrewssuubi@gmail.com, kyacamear@gmail.com'
                    )
                }
            }
        }

        stage("Deploy") {
            steps {
                echo "Deploying Application..."
                bat '''
                "C:/Program Files/butler.exe" push target/C:\Users\DELL\OneDrive\Desktop\itchTest\Group-F-work-3-ForkByMe\out\artifacts\Group_F_work_3_ForkByMe_jar\Group-F-work-3-ForkByMe.jar allrax/projectf:windows
                '''
            }
        }
    }
}
