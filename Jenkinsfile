pipeline{
    agent any
    tools {
        maven 'M2_HOME'
    }


    stages {
    
    
        stage('Getting project from Git') {
            steps{
      			checkout([$class: 'GitSCM', branches: [[name: '*/Syrine']], 
			extensions: [], 
			userRemoteConfigs: [[url: 'https://github.com/SyrineSassi/DevopsProject.git']]])
            }
	} 
	    
        stage('Cleaning the project') {
            steps{
                	sh "mvn -B -DskipTests clean  " 
            }
        }
	    stage('Artifact Construction') {
            steps{
                	sh "mvn -B -DskipTests package "
            }
        }
	    stage('Mockito') {
            steps{
               		 sh "mvn test "
            }
        }
	    
	     stage('Code Quality Check via SonarQube') {
            steps{
                
             		sh "  mvn sonar:sonar -Dsonar.projectKey=achat -Dsonar.host.url=http://192.168.1.19:9000 -Dsonar.login=1ab584d36d9d9338ab8e95fa6621e3091e607cf8"
		             
 
            }
        }
	    
	    stage('Publish to Nexus') {
            steps {


  sh 'mvn clean package deploy:deploy-file -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.19:8081/repository/maven-releases/ -Dfile=target/achat-1.0.jar'


            }
        }
	    
	    stage('Build Docker Image') {
                              steps {
                                  script {
                                    sh 'docker build -t syrinesassi/achat:latest .'
                                  }
                              }
                          }

                          stage('login dockerhub') {
                                                steps {
                                              sh 'docker login -u syrinesassi --password Syrine1234'
                                                    }
        		  }

        	                      stage('Push Docker Image') {
                                                steps {
                                           sh 'docker push syrinesassi/achat:latest'
                                                    }
        		  }


        		   stage('Run Spring && MySQL Containers') {
                                        steps {
                                            script {
                                              sh 'docker-compose up -d'
                                            }
                                        }
                                    }


	    
}



}

