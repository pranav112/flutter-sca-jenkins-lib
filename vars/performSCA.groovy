def call() {
  echo "Performing SCA"
  installDependencies()
  DART_ANALYSIS_STATUS = sh(script: """
      flutter pub run dart_code_metrics:metrics analyze lib --reporter=html --set-exit-on-violation-level=alarm --no-fatal-style --fatal-performance --no-fatal-warnings 
  """, returnStatus: true)
  if (DART_ANALYSIS_STATUS != 0) {
      throw new Exception("Static code analysis failed with exit code ${DART_ANALYSIS_STATUS}")
  } else {
      echo "Static code analysis is successfull"
  }
}

def installDependencies() {
    sh "flutter pub add --dev dart_code_metrics" 
}
