def call() {
  echo "Performing SCA"
  DART_ANALYSIS_STATUS = sh(script: """
    /usr/local/bin/flutter/bin/dart run dart_code_metrics:metrics analyze lib --reporter=html --set-exit-on-violation-level=alarm
  """, returnStatus: true)
  if (DART_ANALYSIS_STATUS != 0) {
    echo "Static code analysis failed with exit code ${DART_ANALYSIS_STATUS}"
  } else {
    echo "Static code analysis is successfull"
  }
}
