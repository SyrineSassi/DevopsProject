pipeline { 
     agent any
     stages{
        stage('Checkout GIT') 
        { 
        steps{ 
            echo 'Pulling...'   
                git branch: 'Siwar-Noueili', credentialsId: 'TOKEN', url: 'https://github.com/SyrineSassi/DevopsProject.git'
               
                 
          }
        }
          
          stage('Creation livrable'){ 
             steps{ 
                 sh "mvn clean package"
             }
         }
          
         stage('Compilation'){ 
             steps{ 
                 sh "mvn compile"
             }
         } 
          
            stage ('SonarQube tests') {
            steps {
              sh' mvn sonar:sonar -Dsonar.projectKey=DevOps -Dsonar.host.url=http://172.20.2.128:9000 -Dsonar.login=5c35462ae955048ee097bccb7ee16b5e1e71464c'
      }
    }
          
      /*   stage ('Mockito/Junit') {
             steps {
            
            sh "mvn test"
                echo """Bravo! tous les tests sont pris en charge"""
                }
            }
          stage('JUnit/Mockito'){
                steps {
                sh '''mvn -version
                mvn -B -DskipTests clean package'''
                     sh 'mvn test'
                }
          } 
          */
           
          
       stage ('Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'
      }
    }  
          
       
          }
    /*     stage("Building Docker Image") {
                steps{
                   // sh 'sudo chmod 666 /var/run/docker.sock'
                    sh 'docker build -t liliaabdeljelil/imagedevops .'
                }
        }

   
   stage("Login to DockerHub") {
                steps{
                   // sh 'sudo chmod 666 /var/run/docker.sock'
                    sh 'echo 25041996TUNIS| docker login -u liliaabdeljelil -p 25041996TUNIS'
                }
        }
       stage("Push to DockerHub") {
                steps{             
                    sh 'docker push liliaabdeljelil/imagedevops'
                }
        }
        stage("Docker-compose") {
                steps{
                    //sh 'docker-compose up -d'
                    sh 'docker-compose up -d --force-recreate --build'
                }
        }*/
          
     }

}
