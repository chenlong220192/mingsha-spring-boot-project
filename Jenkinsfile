pipeline {
    agent { label 'linux' }

    tools {
        jdk 'jdk17'
    }

    environment {
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
        REPO_DIR = "${env.WORKSPACE}"
        EMAIL_RECIPIENTS = 'dev-team@example.com' // 收件人
        EMAIL_SUBJECT = '[构建通知] mingsha-spring-boot-project #${BUILD_NUMBER} - ${BUILD_STATUS}'
        EMAIL_BODY = '''
            <h3>Jenkins 构建通知</h3>
            <ul>
                <li>项目: mingsha-spring-boot-project</li>
                <li>构建编号: ${BUILD_NUMBER}</li>
                <li>状态: ${BUILD_STATUS}</li>
                <li>分支: ${GIT_BRANCH}</li>
                <li>提交: ${GIT_COMMIT}</li>
                <li>详情: <a href="${BUILD_URL}">${BUILD_URL}</a></li>
            </ul>
        '''
        // 只保留1个归档版本
        NUM_TO_KEEP = 1
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: env.NUM_TO_KEEP))
    }

    stages {
        stage('Build') {
            steps {
                echo "Repository directory: ${env.REPO_DIR}"
                sh 'cd $REPO_DIR && ./mvnw clean package -DskipTests'
            }
        }
        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar,**/target/*.war', fingerprint: true
            }
        }
    }
    post {
        always {
            cleanWs()
        }
        success {
            script {
                emailext(
                    to: env.EMAIL_RECIPIENTS,
                    subject: env.EMAIL_SUBJECT.replace('${BUILD_STATUS}', '成功'),
                    body: env.EMAIL_BODY.replace('${BUILD_STATUS}', '成功'),
                    mimeType: 'text/html'
                )
            }
        }
        failure {
            script {
                emailext(
                    to: env.EMAIL_RECIPIENTS,
                    subject: env.EMAIL_SUBJECT.replace('${BUILD_STATUS}', '失败'),
                    body: env.EMAIL_BODY.replace('${BUILD_STATUS}', '失败'),
                    mimeType: 'text/html'
                )
            }
        }
    }
    
} 