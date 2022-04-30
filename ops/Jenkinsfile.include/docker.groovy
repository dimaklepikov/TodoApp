def buildAndUpload(String dockerfilePath) {
    withDockerRegistry([ credentialsId: "${REGISTRY_CREDENTIALS}", url: "http://" + "${REGISTRY}" ]) {
        wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'XTerm']) {

            docker.build("${DOCKER_IMAGE}",  "-f ${dockerfilePath} .")
            sh "docker tag ${DOCKER_IMAGE} ${REGISTRY}/${DOCKER_IMAGE}:latest"
            sh "docker push ${REGISTRY}/${DOCKER_IMAGE}:latest"
        }
    }
}

def deleteImage() { sh "docker image rm -f ${DOCKER_IMAGE}:latest" }

return this
