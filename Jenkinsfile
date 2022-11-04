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
	    stage('Unit Tests') {
            steps{
               		 sh "mvn test "
            }
        }
	    
	     stage('Code Quality Check via SonarQube') {
            steps{
                
             		sh "  mvn sonar:sonar -Dsonar.projectKey=achat -Dsonar.host.url=http://172.26.0.121:9000 -Dsonar.login=1ab584d36d9d9338ab8e95fa6621e3091e607cf8"
		             
 
            }
        }
	    
	    stage('Publish to Nexus') {
            steps {


  sh 'mvn clean package deploy:deploy-file -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.17:8081/repository/maven-releases/ -Dfile=target/achat-1.0.jar'


            }
        }
	    
	    
	    
}
}
       
