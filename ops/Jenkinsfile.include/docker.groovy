def buildAndUpload(String dockerfilePath) {
    // withDockerRegistry([ credentialsId: "d08fc05c-36d9-4ca7-9d41-8d30ca8b1687", url: "" ]) {
        wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'XTerm']) {
            sh "docker build . -t ${DOCKER_IMAGE}:${env.VERSION}"

            // docker.build("${DOCKER_IMAGE}:${env.VERSION}", "--no-cache -f ${WORKSPACE}/${dockerfilePath} .").push()
        }
    // }
}

def deleteImage() { sh "docker image rm -f ${DOCKER_IMAGE}:${env.VERSION}" }

return this
