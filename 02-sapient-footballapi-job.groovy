node{
    stage("Git Clone"){
        git credentialsId: 'GIT_CREDENTIALS', url: 'https://github.com/kundanrecbki/02-SpientMicroserviceTest.git'
    }
    
    stage("Maven clean build"){
        def mavenHome = tool name:"Maven-3.6.3", type: "maven"
        def mavenCMD = "${mavenHome}/bin/mvn"
        bat "${mavenCMD} clean package"
    }
    
    stage("Build Docker Images"){
       bat  "docker build -t kundanrecbki/02-sapient-footballapi-config-server ./02-sapient-footballapi-config-server"
       bat  "docker build -t kundanrecbki/02-sapient-footballapi-zuul-apigateway ./02-sapient-footballapi-zuul-apigateway"
       bat  "docker build -t kundanrecbki/02-sapient-footballapi-eureka-server ./02-sapient-footballapi-eureka-server"
       bat  "docker build -t kundanrecbki/02-sapient-footballapi-service ./02-sapient-footballapi-service"
    }
    
    stage("Docker image push"){
        withCredentials([string(credentialsId: 'DOCKER_HUB_PASSWORD', variable: 'DOCKER_HUB_PASSWORD')]) {
            bat "docker login -u kundanrecbki -p ${DOCKER_HUB_PASSWORD}"
        }
        bat  "docker push kundanrecbki/02-sapient-footballapi-config-server"
        bat  "docker push kundanrecbki/02-sapient-footballapi-zuul-apigateway"
        bat  "docker push kundanrecbki/02-sapient-footballapi-eureka-server"
        bat  "docker push kundanrecbki/02-sapient-footballapi-service"
    }
}