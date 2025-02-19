pipeline{

    agent any
     tools{
        maven "myMaven"
    }

     stages{

         stage("Build"){

                 steps{
                     echo"Building the application"
                     bat "mvn clean install"
                 }
          }

         stage("Test"){

               steps{
                 echo "Running the surefire tests"
                 bat "mvn clean test"
               }

         }

          stage("Issue surefire report"){

                             steps{
                               echo "Generating report..."


                             }

                       }

          stage('SonarQube Analysis') {
           
           steps {
               withSonarQubeEnv("mySonar) {
                  bat "mvn clean verify sonar:sonar -Dsonar.projectKey=group3Project -Dsonar.projectName='group3Project'"
                                }
                      }
          }

          stage("Deploy"){

                     steps{
                         
                      echo "Deploying Application..."
                    }

              }


         }

    }
