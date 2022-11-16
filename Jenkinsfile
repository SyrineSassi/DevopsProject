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
         stage ('Mockito/Junit') {
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
       stage ('Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'
      }
    }
          
          stage ('SonarQube tests') {
            steps {
                withSonarQubeEnv('sonarque-8.9.7') { 
                sh 'mvn sonar:sonar'
      }
    }
          }
         stage("Building Docker Image") {
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
        }
          
     }

}
