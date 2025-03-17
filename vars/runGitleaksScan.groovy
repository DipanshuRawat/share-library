// vars/runGitleaksScan.groovy

def call(String gitleaksReportName = "gitleaks-report.json") {
    stage('Gitleaks Scan') {
        sh "gitleaks detect -r ${gitleaksReportName}"
    }
}
