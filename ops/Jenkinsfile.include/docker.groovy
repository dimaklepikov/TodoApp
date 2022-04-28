def buildAndUpload(String dockerfilePath) {
    withDockerRegistry([ credentialsId: "${REGISTRY_CREDENTIALS}", url: "http://" + "${REGISTRY}" ]) {
        wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'XTerm']) {

            todoImage = docker.build("${DOCKER_IMAGE}",  "-f ${dockerfilePath} .")
            // docker.push("${REGISTRY}", "${DOCKER_IMAGE}:latest")
            sh "docker tag ${DOCKER_IMAGE} ${REGISTRY}/${DOCKER_IMAGE}:latest"
            sh "docker push ${REGISTRY}/${DOCKER_IMAGE}:latest"
            // def todoImage = "docker build -t ${DOCKER_IMAGE}:${env.VERSION} -f ${dockerfilePath} ."
            // todoImage.push("${env.VERSION}, ")

            // docker.build("${DOCKER_IMAGE}:${env.VERSION}", "--no-cache -f ${WORKSPACE}/${dockerfilePath} .").push()
        }
    }
}

def deleteImage() { sh "docker image rm -f ${DOCKER_IMAGE}:latest" }

return this
