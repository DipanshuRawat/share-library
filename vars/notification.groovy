// vars/notification.groovy

def call(String recipientEmail, String status, String gitleaksReportName = "gitleaks-report.json") {
    def subject = "Jenkins Build ${status}: ${env.JOB_NAME} #${env.BUILD_NUMBER}"
    def body = """Hello,

The Jenkins pipeline *${env.JOB_NAME}* has ${status.toLowerCase()} on *Build #${env.BUILD_NUMBER}*.

*Build Details:*
- *Job Name:* ${env.JOB_NAME}
- *Build Number:* ${env.BUILD_NUMBER}
- *Build URL:* ${env.BUILD_URL}

You can find the Gitleaks scan report attached.

Best regards,
Jenkins CI
"""

    emailext(
        to: recipientEmail,
        subject: subject,
        body: body,
        attachmentsPattern: gitleaksReportName
    )
}
